package com.example.make_a_story_prototype.main.Quiz.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Home.view.HomeActivity;
import com.example.make_a_story_prototype.main.Home.vm.StoryBlankSelectionContext;
import com.example.make_a_story_prototype.main.Navigation.NavigationController;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;

import java.util.Objects;
import java.util.Random;

public class CharacterGuideActivity extends BaseActivity {

    String messageType = "";
    int categoryId;

    @Override protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.partialfade_in, R.anim.partialfade_out);
        setContentView(R.layout.activity_character_guide);

        categoryId = getIntent().getIntExtra("category", 0);


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

            NavigationController.NavigationContext context = getNavigationContext();

            if (context instanceof StoryBlankSelectionContext) {
                StoryBlankSelectionContext storyBlankSelectionContext = (StoryBlankSelectionContext)context;

                Intent intent = new Intent(this,   WordbankActivity.class);
                intent.putExtra("category", categoryId);
                CharacterGuideActivity.this.startActivity(intent);
            } else {
                Intent intent = new Intent(this, HomeActivity.class);
                CharacterGuideActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                CharacterGuideActivity.this.finish();
            }
        }, duration);
    }
}
