package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryPage;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryPageSampleData;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StorySegment;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryText;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StoryTemplateActivity extends AppCompatActivity implements ObservableScrollView.ScrollViewListener {

    public static String BlankSelectionIntentKey = "BlankSelection";
    private static String BLANK_PLACEHOLDER = " BLANK ";
    private static StoryViewModel sVm = new StoryViewModel(StoryPageSampleData.sampleStory());
    private static String currentIdentifier;
    private static int word1Resource = 0;
    private static int word2Resource = 0;
    private static int index = 0;

    private StoryViewModel vm = StoryTemplateActivity.sVm;

    private ImageView storyImageView;
    private TextView storyTextView;
    private ObservableScrollView scrollView = null;
    private FrameLayout fl;
    private ImageView image1;
    private ImageView image2;

    private String source = "template";

    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_template);

        View view = findViewById(R.id.constraint_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        Toolbar controlsbar = findViewById(R.id.controls_bar);
        storyImageView = findViewById(R.id.story_image);
        storyTextView = findViewById(R.id.story_text);
        progressBar = findViewById(R.id.progress_bar);
        image1 = findViewById(R.id.word_image1);
        image2 = findViewById(R.id.word_image2);
        fl = findViewById(R.id.image_layout);

        scrollView = findViewById(R.id.story_scroll);
        scrollView.setScrollViewListener(this);

        TextView screenTitle = toolbar.findViewById(R.id.toolbar_title);
        screenTitle.setText(vm.getStory().getTitle());

        storyImageView.setImageResource(vm.getStory().getPages().get(0).getImageResource());

        updateTextView(0);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        StoryViewModel.BlankSelection selection = bundle.getParcelable(BlankSelectionIntentKey);
        if (currentIdentifier != null && selection != null) {
            vm.setSelection(currentIdentifier, selection);
            updateTextView(0);
            updateImageView(selection.getImageResource());
        }
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
                return true;
            case R.id.home_menu_icon:
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

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Todo: Saving", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        noSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Not Saving", Toast.LENGTH_SHORT).show();
                vm.clearSelections();
                index = 0;
                finish();
            }
        });
    }


    public void updateTextView(int pageNum) {
        StoryPage currentPage = vm.getStory().getPages().get(pageNum);
        List<StorySegment> segments = currentPage.getSegments();

        SpannableStringBuilder builder = new SpannableStringBuilder();

        for (StorySegment s : segments) {
            if (s instanceof StoryText) {
                StoryText textSegment = (StoryText) s;
                builder.append(textSegment.getText());
            } else if (s instanceof StoryBlankIdentifier) {
                StoryBlankIdentifier identifier = (StoryBlankIdentifier) s;
                StoryViewModel.BlankSelection selection = vm.getSelections().get(identifier.get());

                if (selection == null) {
                    builder.append(
                            BLANK_PLACEHOLDER,
                            new ClickableSpan() {
                                @Override
                                public void onClick(@NonNull View v) {
                                    onSelectedBlank(identifier.get());
                                }
                            },
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                } else {
                    builder.append(selection.getText());
                }
            }
        }

        storyTextView.setMovementMethod(LinkMovementMethod.getInstance());
        storyTextView.setText(builder);
    }

    public void updateImageView(int resource) {
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.WRAP_CONTENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT);
//
//        image.setImageResource(resource);
//
//        // Adds image to layout
//        fl.addView(image, params);
//
//        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
//        image.getLayoutParams().height = dimensionInDp;
//        image.getLayoutParams().width = dimensionInDp;
//
//        image.setX(162);
//        image.setY(255);
//        image.requestLayout();

        // TODO: fix this
        // hard-coding for demo
        if (index == 0) {
            word1Resource = resource;

            image1.setImageResource(word1Resource);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);

        } else if (index == 1) {
            word2Resource = resource;
            image1.setImageResource(word1Resource);
            image2.setImageResource(word2Resource);

            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
        } else {
            image1.setImageResource(word1Resource);
            image2.setImageResource(word2Resource);

            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
        }

        index++;
    }

    private void onSelectedBlank(String blankIdentifier) {
        currentIdentifier = blankIdentifier;
        Intent intent = new Intent(this,   CategoriesActivity.class);
        intent.putExtra("source", source);
        StoryTemplateActivity.this.startActivity(intent);
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int prevX, int prevY) {
        float percentScrolled = (float) ((y / 3000.0) * 100);
        progressBar.setProgress(Math.min((int) percentScrolled, 100));
    }
}


