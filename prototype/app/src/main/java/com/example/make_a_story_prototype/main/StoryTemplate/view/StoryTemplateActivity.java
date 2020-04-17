package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Characters.view.CharacterActivity;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.Home.vm.StoryBlankSelectionContext;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class StoryTemplateActivity extends BaseActivity implements StoryViewModel.StoryViewModelCallback, ViewPager.OnPageChangeListener {

    private static String STORY_ID_EXTRA_KEY = "STORY_ID";
    private static String STORY_PAGE_EXTRA_KEY = "PAGE_NUMBER";
    private static String MY_VM_KEY = WordbankActivity.class.getName() + ":VM_KEY";

    public static void start(Activity activity, int storyId, int pageNumber) {
        Intent intent = new Intent(activity, StoryTemplateActivity.class);
        intent.putExtra(STORY_ID_EXTRA_KEY, storyId);
        intent.putExtra(STORY_PAGE_EXTRA_KEY, pageNumber);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        activity.startActivity(intent);
    }

    private StoryViewModel vm;
    private ViewPager storyPager;
    private StoryPageAdapter storyPageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_template);

        if (savedInstanceState == null) {
            int storyId = getIntent().getIntExtra(STORY_ID_EXTRA_KEY, -1);
            int pageNumber = getIntent().getIntExtra(STORY_PAGE_EXTRA_KEY, 0);
            vm = new StoryViewModel(storyId, pageNumber);
        } else {
            vm = savedInstanceState.getParcelable(MY_VM_KEY);
        }

        vm.callback = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        storyPager = findViewById(R.id.story_pager);
        storyPageAdapter = new StoryPageAdapter(this, vm);
        storyPager.addOnPageChangeListener(this);
        storyPager.setAdapter(storyPageAdapter);
        storyPager.setCurrentItem(vm.getPageNumber());

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);
        TextView screenTitle = toolbar.findViewById(R.id.toolbar_title);
        screenTitle.setText(vm.getStory().getTitle());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putParcelable(MY_VM_KEY, vm);
    }

    // home icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO:
        switch (item.getItemId()) {
            case android.R.id.home:
                showSaveDialog();
//                storyPageView.pause();
                return true;
            case R.id.home_menu_icon:
//                storyPageView.pause();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showSaveDialog() {
        View saveDialog = findViewById(R.id.popup_dialog);
        saveDialog.setVisibility(View.VISIBLE);
        Button saveButton = findViewById(R.id.save_button);
        Button noSaveButton = findViewById(R.id.no_save_button);

        saveButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Saving", Toast.LENGTH_SHORT).show();

            finish();
        });

        noSaveButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Story not saved", Toast.LENGTH_SHORT).show();
            vm.clearSelections();
            finish();
        });
    }

    @Override
    public void onSelectedBlank(String identifier) {
        // TODO:
//        storyPageView.pause();

        setNavigationContext(new StoryBlankSelectionContext(vm.getStory().getStoryId(), identifier, vm.getPageNumber()));
        //If Character selection blank (format "X-2"), intent is character activity
        if (identifier.length() > 2) {
            Intent intent = new Intent(this, CharacterActivity.class);
            StoryTemplateActivity.this.startActivity(intent);
        } else {
            Intent intent = new Intent(this, CategoriesActivity.class);
            StoryTemplateActivity.this.startActivity(intent);
        }
    }

    @Override
    public void finishStory() {
        showShareDialogue();
    }

    private void showShareDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // share button allows the user to share story text
        //TODO: allow user to share story images
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                // creating email intent with type
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("application/image");
                String storyText = "";

                for (int i = 0; i < vm.getStory().getPages().size(); i++) {
                    //fetching story text based on pages
                    SpannableStringBuilder pageText = (SpannableStringBuilder) (vm.getTextForPage(i));
                    storyText = storyText + pageText.toString();

                    //fetching story image based on pages
//                    Uri path = Uri.parse("android.resource://com.example.make_a_story_prototype/" +
//                            vm.getStory().getPages().get(i).getImageResource());
//                    String imgPath = path.toString();
//                    emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imgPath));
                }

                // extra attributes to the email including subject and content text
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Brainy Make-A-Story Android: Completed Story Template");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, vm.getStory().getTitle() + "\n\n" + storyText);
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
            }
        });

        //cancel button directs user to home page with selections cleared
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                vm.clearSelections();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.setMessage("Congratulations! You finished the story.\nDo you want to share the completed story?");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //
    }

    @Override
    public void onPageSelected(int position) {
        vm.setPageNumber(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //
    }
}


