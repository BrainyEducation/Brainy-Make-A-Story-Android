package com.example.make_a_story_prototype.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.views.HomePage;
import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        scheduleLaunchScreen();
    }


    private void scheduleLaunchScreen() {
        int duration = 1500;

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(this,   HomePage.class);
            LaunchActivity.this.startActivity(intent);

            LaunchActivity.this.finish();
        }, duration);
    }
}
