package com.example.make_a_story_prototype.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Util.themeStatusBar(this, false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        scheduleLaunchScreen();
    }


    private void scheduleLaunchScreen() {
        int duration = 1500;

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(this,   HomeActivity.class);
            LaunchActivity.this.startActivity(intent);

            LaunchActivity.this.finish();
        }, duration);
    }
}
