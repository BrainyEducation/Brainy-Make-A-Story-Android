package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.TemplateViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StoryTemplateActivity extends AppCompatActivity {

    private TemplateViewModel vm;
    private ImageView storyImage;
    private String storyTitle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_template);

        View view = findViewById(R.id.constraint_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        storyTitle = getIntent().getStringExtra("source");
        TextView screenTitle = toolbar.findViewById(R.id.toolbar_title);
        screenTitle.setText(storyTitle);
        vm = new TemplateViewModel(storyTitle);


        storyImage = findViewById(R.id.story_image);
        storyImage.setImageResource(vm.getStoryImage());

        Toolbar controlsbar = findViewById(R.id.controls_bar);
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
}


