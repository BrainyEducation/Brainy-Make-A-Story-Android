package com.example.make_a_story_prototype.main.Quiz.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;

import java.util.Objects;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class CharacterGuideActivity extends AppCompatActivity {

    String messageType = "";

    @Override protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_guide);

        Resources res = getResources();
        String [] goodJobMsg = res.getStringArray(R.array.goodJobMessages);
        String [] tryAgainMsg = res.getStringArray(R.array.tryAgainMessages);

        Random rand = new Random();

        TextView charTextMessage = (TextView) findViewById(R.id.charTextMsg);
        messageType = getIntent().getStringExtra("msgType");
        if (Objects.equals(messageType, "goodJob")) {
            charTextMessage.setText(goodJobMsg[rand.nextInt(goodJobMsg.length + 1)]);
            Log.d("debug", "set text to good job");
        } else {
            charTextMessage.setText(tryAgainMsg[rand.nextInt(goodJobMsg.length + 1)]);
            Log.d("debug", "set text to try again");
        }
        display();
    }

    private void display() {
        int duration = 2000;

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(this,   HomeActivity.class);
            CharacterGuideActivity.this.startActivity(intent);
            overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            CharacterGuideActivity.this.finish();
        }, duration);
    }
}
