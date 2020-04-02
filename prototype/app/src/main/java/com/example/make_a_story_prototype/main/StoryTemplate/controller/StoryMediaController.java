package com.example.make_a_story_prototype.main.StoryTemplate.controller;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

public class StoryMediaController implements MediaPlayer.OnCompletionListener {

    private android.media.MediaPlayer mediaPlayer;
    private Context context;
    private StoryPage page;
    private StoryViewModel vm;

    private int nextSegmentIndex;

    public StoryMediaController(Context context, StoryPage page, StoryViewModel vm) {
        this.context = context;
        this.page = page;
        this.vm = vm;
        this.nextSegmentIndex = 0;
    }

    public void play() {
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            playNextSegment();
        }
    }

    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    // go back to beginning and continue to play if playing. don't autoplay though
    public void restart() {
        nextSegmentIndex = 0;
    }

    private void playNextSegment() {
        if (nextSegmentIndex >= page.getSegments().size()) {
            return;
        }

        StorySegment nextSegment = page.getSegments().get(nextSegmentIndex);
        int nextResource = 0;

        if (nextSegment instanceof StoryText) {
            StoryText textSegment = (StoryText) nextSegment;
            nextResource = textSegment.getAudioResource();
        } else if (nextSegment instanceof StoryBlankIdentifier) {
            StoryBlankIdentifier identifier = (StoryBlankIdentifier) nextSegment;
            BlankSelection selection = vm.getSelections().get(identifier.get());

            if (selection == null) {
                nextResource = R.raw.things;
            } else {
                // TODO:
                nextResource = R.raw.animals_camel;
            }
        }

        mediaPlayer = MediaPlayer.create(context, nextResource);
        mediaPlayer.setOnCompletionListener(this);

        mediaPlayer.start();
        nextSegmentIndex += 1;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        playNextSegment();
    }
}
