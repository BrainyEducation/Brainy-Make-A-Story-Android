package com.example.make_a_story_prototype.main.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.entity.QuizAnswers;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private QuizAnswers incorrectQuizAnswers = new QuizAnswers();
    private int correctAnswersCount = 0;

    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        buttonOption1 = (Button) findViewById(R.id.choice1);
        buttonOption2 = (Button) findViewById(R.id.choice2);
        buttonOption3 = (Button) findViewById(R.id.choice3);
        buttonOption4 = (Button) findViewById(R.id.choice4);

        // button listener
        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);
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
            case R.id.choice1:
                Toast.makeText(this,"Option 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.choice2:
                Toast.makeText(this,"Option 2 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.choice3:
                Toast.makeText(this,"Option 3 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.choice4:
                Toast.makeText(this,"Option 4 clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
