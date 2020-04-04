package com.example.make_a_story_prototype.main.StorySelection.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.StorySelection.vm.StoryCardViewModel;
import com.example.make_a_story_prototype.main.StorySelection.vm.StorySelectionViewModel;
import com.example.make_a_story_prototype.main.StoryTemplate.view.StoryTemplateActivity;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class for Story Template Selection activities, including redirection to each story screen.
 */

public class StorySelectionActivity extends BaseActivity implements StorySelectionRecyclerViewAdapter.StoryAdapterHandler {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private StorySelectionViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_selection);

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

        vm = new StorySelectionViewModel(this);
        initRecyclerView();
    }


    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new StorySelectionRecyclerViewAdapter(this, vm);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        ((StorySelectionRecyclerViewAdapter) recyclerViewAdapter).handler = this;
    }

    @Override
    public void selectStoryCard(StoryCardViewModel vm) {
        int storyId = vm.getStory().getStoryId();
        StoryTemplateActivity.start(this, storyId);
    }
}