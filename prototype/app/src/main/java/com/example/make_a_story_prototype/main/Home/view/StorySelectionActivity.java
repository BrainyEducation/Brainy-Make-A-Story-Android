package com.example.make_a_story_prototype.main.Home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Characters.view.CharacterActivity;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Class for Story Template Selection activities, including redirection to each story screen.
 */

public class StorySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_story_selection);
        Util.themeStatusBar(this, false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    /**
     * goes to the story screen for "The Special Invention"
     * @param v view
     */
    public void SpecialInventionCardOnClick(View v) {
        Toast.makeText(this, "Todo: Special Invention Story", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "The Wacky Costume Party"
     * @param v view
     */
    public void WackyCostumePartyCardOnClick(View v) {
        Toast.makeText(this, "Todo: The Wacky Costume Party", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "Santa's Mixed-up Helper Elf"
     * @param v view
     */
    public void SantasElfCardOnClick(View v) {
        Toast.makeText(this, "Todo: Santa's Mixed-up Helper Elf", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "The Space Alien"
     * @param v view
     */
    public void SpaceAlienCardOnClick(View v) {
        Toast.makeText(this, "Todo: The Space Alien Story", Toast.LENGTH_SHORT).show();
    }
}
