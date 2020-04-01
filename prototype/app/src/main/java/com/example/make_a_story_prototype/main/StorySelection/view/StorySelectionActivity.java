package com.example.make_a_story_prototype.main.StorySelection.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Brainy.BrainyApplication;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.Home.vm.StoryContext;
import com.example.make_a_story_prototype.main.Navigation.NavigationController;
import com.example.make_a_story_prototype.main.StorySelection.vm.StorySelectionViewModel;
import com.example.make_a_story_prototype.main.StoryTemplate.view.StoryTemplateActivity;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.data.Story.DebugStoryRepository;
import com.example.make_a_story_prototype.main.data.Story.model.Story;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

/**
 * Class for Story Template Selection activities, including redirection to each story screen.
 */

public class StorySelectionActivity extends BaseActivity {
    private StorySelectionViewModel vm;
    private int storyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_selection);

        vm = new StorySelectionViewModel();
        List<Story> storyList = vm.getStories();

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Story Templates");

    }

    /**
     * goes to the story screen for "The Special Invention"
     * @param v view
     */
    public void SpecialInventionCardOnClick(View v) {
        storyId = vm.getStories().get(0).getStoryId();
        StoryContext c = (StoryContext) getNavigationContext();
        c.setStoryId(storyId);

        Intent intent = new Intent(this, StoryTemplateActivity.class);
        this.startActivity(intent);
    }

    /**
     * goes to the story screen for "The Wacky Costume Party"
     * @param v view
     */
    public void WackyCostumePartyCardOnClick(View v) {
        storyId = vm.getStories().get(2).getStoryId();
        StoryContext c = (StoryContext) getNavigationContext();
        c.setStoryId(storyId);

        Intent intent = new Intent(this, StoryTemplateActivity.class);
        this.startActivity(intent);
        Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();

    }

    /**
     * goes to the story screen for "Santa's Mixed-up Helper Elf"
     * @param v view
     */
    public void SantasElfCardOnClick(View v) {
        storyId = vm.getStories().get(3).getStoryId();
        StoryContext c = (StoryContext) getNavigationContext();
        c.setStoryId(storyId);

        Intent intent = new Intent(this, StoryTemplateActivity.class);
        this.startActivity(intent);
        Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();

    }

    /**
     * goes to the story screen for "The Space Alien"
     * @param v view
     */
    public void SpaceAlienCardOnClick(View v) {
        storyId = vm.getStories().get(1).getStoryId();
        StoryContext c = (StoryContext) getNavigationContext();
        c.setStoryId(storyId);

        Intent intent = new Intent(this, StoryTemplateActivity.class);
        this.startActivity(intent);
    }
}
