package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Characters.view.CharacterActivity;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.Home.vm.StoryBlankSelectionContext;
import com.example.make_a_story_prototype.main.StoryTemplate.controller.StoryMediaController;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;

public class StoryTemplateActivity extends BaseActivity implements StoryViewModel.StoryViewModelCallback {

    private static String STORY_ID_EXTRA_KEY = "STORY_ID";
    private static String MY_VM_KEY = WordbankActivity.class.getName() + ":VM_KEY";

    public static void start(Activity activity, int storyId) {
        Intent intent = new Intent(activity, StoryTemplateActivity.class);
        intent.putExtra(STORY_ID_EXTRA_KEY, storyId);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        activity.startActivity(intent);
    }

    private StoryViewModel vm;
    private StoryPageView storyPageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_template);

        if (savedInstanceState == null) {
            int storyId = getIntent().getIntExtra(STORY_ID_EXTRA_KEY, -1);
            Log.d("TAG", "onCreate in template: intent extra [storyId] --> " + storyId);
            vm = new StoryViewModel(storyId);
        } else {
            vm = savedInstanceState.getParcelable(MY_VM_KEY);
        }

        vm.callback = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        storyPageView = findViewById(R.id.story_page);
        storyPageView.setViewModel(vm, 0);

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
        switch (item.getItemId()) {
            case android.R.id.home:
                showSaveDialog();
                storyPageView.pause();
                return true;
            case R.id.home_menu_icon:
                storyPageView.pause();
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
        storyPageView.pause();

        setNavigationContext(new StoryBlankSelectionContext(vm.getStory().getStoryId(), identifier));
        //If Character selection blank (format "X-2"), intent is character activity
        if (identifier.length() > 2) {
            Intent intent = new Intent(this, CharacterActivity.class);
            StoryTemplateActivity.this.startActivity(intent);
        } else {
            Intent intent = new Intent(this, CategoriesActivity.class);
            StoryTemplateActivity.this.startActivity(intent);
        }
    }
}


