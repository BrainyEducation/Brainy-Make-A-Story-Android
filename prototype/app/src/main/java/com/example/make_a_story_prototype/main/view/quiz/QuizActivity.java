package com.example.make_a_story_prototype.main.view.quiz;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util;
import com.example.make_a_story_prototype.main.model.QuizOptions;
import com.example.make_a_story_prototype.main.vm.QuizViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class QuizActivity extends AppCompatActivity implements QuizViewModel.Callback {

    private QuizViewModel vm;

    private View rootView;
    private ImageView[] stars;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    private List<Button> buttons = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View view = findViewById(R.id.constraint_layout);
        rootView = view.getRootView();

        rootView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this);
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

        setViewModel(new QuizViewModel());
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

        vm.getCorrectAnswerCount().subscribe(this::updateStars);

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
        Toast.makeText(this, "Congrats! You've learned a word!", Toast.LENGTH_SHORT).show();

//        Snackbar.make(rootView, "Congrats! You've learned a word!", Snackbar.LENGTH_SHORT)
//                .show();
    }

    private void updateStars(int correctAnswerCount) {
        for (int i = 0; i < stars.length; i++) {
            ImageView star = stars[i];

            int backgroundColor;
            if (i < correctAnswerCount) {
                backgroundColor = getResources().getColor(R.color.colorGold);
            } else {
                backgroundColor = getResources().getColor(R.color.colorDarkGray);
            }

            Drawable d = star
                    .getDrawable()
                    .mutate();

            // TODO: take another look at this
            d.setColorFilter(new PorterDuffColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN));
        }
    }
}
