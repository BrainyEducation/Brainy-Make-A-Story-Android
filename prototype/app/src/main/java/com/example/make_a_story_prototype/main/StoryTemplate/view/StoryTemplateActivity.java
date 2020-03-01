package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

public class StoryTemplateActivity extends AppCompatActivity {

    private static String BLANK_PLACEHOLDER = " BLANK ";

    private StoryViewModel vm;

    private ImageView storyImageView;
    private TextView storyTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_template);

        View view = findViewById(R.id.constraint_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        storyImageView = findViewById(R.id.story_image);
        storyTextView = findViewById(R.id.story_text);
        Toolbar controlsbar = findViewById(R.id.controls_bar);

        vm = new StoryViewModel(StoryPageSampleData.sampleStory());

        TextView screenTitle = toolbar.findViewById(R.id.toolbar_title);
        screenTitle.setText(vm.getStory().getTitle());

        storyImageView.setImageResource(vm.getStory().getPages().get(0).getImageResource());

        updateTextView(0);
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
                super.finish();
                return true;
            case R.id.home_menu_icon:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                                public void onClick(@NonNull View widget) {
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

    private void onSelectedBlank(String blankIdentifier) {
//        startActivity(new Intent(getApplicationContext(), CategoriesActivity.class));

        vm.setSelection(blankIdentifier, new StoryViewModel.BlankSelection(
                "Billy",
                R.drawable.food_apple
        ));

        updateTextView(0);
    }
}


