package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.StoryTemplate.controller.StoryMediaController;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;

import androidx.constraintlayout.widget.ConstraintLayout;

public class StoryPageView extends ConstraintLayout implements ObservableScrollView.ScrollViewListener {

    private StoryViewModel vm;
    private int pageNumber;

    private StoryMediaController mediaController;
    private TextView storyTextView;
    private ObservableScrollView scrollView = null;
    private ProgressBar progressBar;
    private SceneImage sceneImage;

    public StoryPageView(Context context) {
        this(context, null);
    }

    public StoryPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StoryPageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        sceneImage = findViewById(R.id.scene_image);
        storyTextView = findViewById(R.id.story_text);
        progressBar = findViewById(R.id.progress_bar);
        scrollView = findViewById(R.id.story_scroll);
        scrollView.setScrollViewListener(this);

        ImageView playButton = findViewById(R.id.play_button);
        ImageView pauseButton = findViewById(R.id.pause_button);
        ImageView replayButton = findViewById(R.id.replay_button);

        playButton.setOnClickListener(this::onPlayTapped);
        pauseButton.setOnClickListener(this::onPauseTapped);
        replayButton.setOnClickListener(this::onReplayTapped);
    }

    public void setViewModel(StoryViewModel vm, int pageNumber) {
        this.vm = vm;
        this.pageNumber = pageNumber;

        sceneImage.setViewModel(vm, pageNumber);
        mediaController = new StoryMediaController(
                getContext(),
                vm.getStory().getPages().get(pageNumber),
                vm
        );

        update();

        requestLayout();
    }

    public void pause() {
        if (mediaController == null) {
            return;
        }

        mediaController.pause();
    }

    private void update() {
        if (vm == null) {
            return;
        }

        Spannable text = vm.getTextForPage(pageNumber);

        storyTextView.setMovementMethod(LinkMovementMethod.getInstance());
        storyTextView.setText(text);
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int prevX, int prevY) {
        float percentScrolled = (float) ((y / 3000.0) * 100);
        progressBar.setProgress(Math.min((int) percentScrolled, 100));
    }

    public void onPauseTapped(View v) {
        mediaController.pause();
    }

    public void onPlayTapped(View v) {
        mediaController.play();
    }

    public void onReplayTapped(View v) {
        mediaController.restart();
    }
}
