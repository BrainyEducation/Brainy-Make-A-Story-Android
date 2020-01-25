package com.example.make_a_story_prototype.main.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoriesActivity;
import com.example.make_a_story_prototype.main.Categories.view.CategoryItemRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Util;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
* Class for Home page activities, including redirection to word bank and story screen.
*/
public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    /**
     * goes to the word bank screen
     * @param v view
     */
    public void wordBankButtonOnClick(View v) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        this.startActivity(intent);
    }

    /**
     * goes to the story page screen
     * @param v view
     */
    public void storyPageButtonOnClick(View v) {
        Toast.makeText(this, "Todo: story page button", Toast.LENGTH_SHORT).show();
    }
}
