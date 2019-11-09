package com.example.make_a_story_prototype.main.view.quiz;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util;
import com.example.make_a_story_prototype.main.model.QuizOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private QuizOptions incorrectQuizOptions = new QuizOptions();
    private int correctAnswersCount = 0;

    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    List<Button> buttons = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // All of toolbar setup needs to be moved out to a base class
        View view = findViewById(R.id.constraint_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this);
        Util.addBackArrow(this);

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Learn");

        buttonOption1 = (Button) findViewById(R.id.option1);
        buttonOption2 = (Button) findViewById(R.id.option2);
        buttonOption3 = (Button) findViewById(R.id.option3);
        buttonOption4 = (Button) findViewById(R.id.option4);

        // button listener
        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);

        buttons.add(buttonOption1);
        buttons.add(buttonOption2);
        buttons.add(buttonOption3);
        buttons.add(buttonOption4);

        fillButtons();
    }

    // storybook icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.icon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.finish();
                return true;
            case R.id.storybook:
                Toast.makeText(this, "Todo: storybook button", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fillButtons() {
        String[] answerOptions = incorrectQuizOptions.getIncorrectOptions();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            // get random index of answer option
            int j = random.nextInt(answerOptions.length);
            buttons.get(i).setText(answerOptions[j]);
        }

        int indexOfCorrectOption = random.nextInt(4);
        buttons.get(indexOfCorrectOption).setText(QuizOptions.getCorrectOption());
    }

    private void updateCorrectAnswersCount(boolean isCorrect) {
        if (isCorrect) {
            correctAnswersCount++;
        } else {
            correctAnswersCount = 0;
        }

        if (correctAnswersCount == 3) {
            // go to quiz completion popup
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.option1:
                Toast.makeText(this,"Option 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                Toast.makeText(this,"Option 2 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option3:
                Toast.makeText(this,"Option 3 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option4:
                Toast.makeText(this,"Option 4 clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
