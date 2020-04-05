package com.example.make_a_story_prototype.main.Home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Characters.view.CharacterActivity;
import com.example.make_a_story_prototype.main.Home.vm.BrowseContext;
import com.example.make_a_story_prototype.main.Home.vm.HomeContext;
import com.example.make_a_story_prototype.main.StorySelection.view.StorySelectionActivity;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;

/**
* Class for Home page activities, including redirection to word bank and story screen.
*/
public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_home);
        Util.themeStatusBar(this, true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setNavigationContext(new HomeContext());
    }

    /**
     * goes to the word bank / quizzes screen
     * @param v view
     */
    public void homeWordBankOnClick(View v) {
        setNavigationContext(new BrowseContext());
        Intent intent = new Intent(this, CategoriesActivity.class);
        this.startActivity(intent);
    }

    /**
     * goes to the story page screen
     * @param v view
     */
    public void homeStoriesOnClick(View v) {
        setNavigationContext(null);
        Intent intent = new Intent(this, StorySelectionActivity.class);
        this.startActivity(intent);
    }

}
