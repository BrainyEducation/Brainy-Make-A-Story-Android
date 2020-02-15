package com.example.make_a_story_prototype.main.Quiz.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.CharacterGuideActivity;
import com.example.make_a_story_prototype.main.Quiz.vm.QuizViewModel;
import com.example.make_a_story_prototype.main.Quiz.vm.QuizWordViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;

public class QuizActivity extends AppCompatActivity implements QuizViewModel.Callback {

    private QuizViewModel vm;

    private View rootView;
    private ImageView[] stars;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    private ImageView quizImage;
    private QuizWordViewModel quizWordVM;
    private List<Button> buttons = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent = getIntent();
        String wordBeingQuizzed = intent.getStringExtra("source");


        View view = findViewById(R.id.constraint_layout);
        rootView = view.getRootView();

        rootView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText("Learn");

        stars = new ImageView[]{
                findViewById(R.id.star1),
                findViewById(R.id.star2),
                findViewById(R.id.star3)
        };

        buttonOption1 = findViewById(R.id.option1);
        buttonOption2 = findViewById(R.id.option2);
        buttonOption3 = findViewById(R.id.option3);
        buttonOption4 = findViewById(R.id.option4);

        // button listener
        buttonOption1.setOnClickListener(clickListenerForOption(0));
        buttonOption2.setOnClickListener(clickListenerForOption(1));
        buttonOption3.setOnClickListener(clickListenerForOption(2));
        buttonOption4.setOnClickListener(clickListenerForOption(3));

        buttons.add(buttonOption1);
        buttons.add(buttonOption2);
        buttons.add(buttonOption3);
        buttons.add(buttonOption4);

        Resources res = getResources();
        String [] wordList = res.getStringArray(R.array.WordList);
        setViewModel(new QuizViewModel(wordBeingQuizzed,wordList));
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

    private void setViewModel(QuizViewModel vm) {
        this.vm = vm;

        vm.callback = this;

        Observable.combineLatest(
                vm.getCorrectAnswerCount(),
                vm.getMaxAnswerCount(),
                (current, max) -> new Pair<>(current, max))
                .subscribe(value -> {
                    updateStars(value.first, value.second);
                });

        vm.getCorrectAnswerCount().subscribe();

        vm.getOptions().subscribe((String[] options) -> {
            for (int i = 0; i < 4; i++) {
                buttons.get(i).setText(options[i]);
            }
        });
    }

    private View.OnClickListener clickListenerForOption(int option) {
        return v -> vm.onSelectedAnswer(option);
    }

    @Override
    public void onComplete() {
        Log.d("debug", "display complete");
        displayCharGuide("goodJob");
    }

    private void updateStars(int correctAnswerCount, int maxCorrectCount) {
        for (int i = 0; i < stars.length; i++) {
            ImageView star = stars[i];

            int backgroundColor;
            if (i < correctAnswerCount) {
                backgroundColor = getResources().getColor(R.color.colorGold);
                Log.d("debug", "display good job");
//                displayCharGuide("goodJob");
            } else if (i < maxCorrectCount) {
                Log.d("debug", "display try again");
//                displayCharGuide("tryAgain");
                backgroundColor = getResources().getColor(R.color.colorSilver);
            } else {
                backgroundColor = getResources().getColor(R.color.colorDarkGray);
            }

            Drawable d = star.getDrawable();
            Util.changeDrawableColor(d, backgroundColor);
        }
    }

    private void displayCharGuide(String messageType) {
        Log.d("debug", "entering display intent");
        Intent intent = new Intent(this,   CharacterGuideActivity.class);
        intent.putExtra("msgType", messageType);
        QuizActivity.this.startActivity(intent);
    }
}
