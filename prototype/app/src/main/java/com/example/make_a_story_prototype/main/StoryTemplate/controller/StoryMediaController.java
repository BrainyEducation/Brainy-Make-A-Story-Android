package com.example.make_a_story_prototype.main.StoryTemplate.controller;

import com.example.make_a_story_prototype.main.Media.AudioPlayer;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;

public class StoryMediaController {

    private static android.media.MediaPlayer mediaPlayer = AudioPlayer.getInstance();

    public StoryMediaController(StoryPage page) {
        mediaPlayer = AudioPlayer.getInstance();
    }

    public void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    // go back to beginning and continue to play if playing. don't autoplay though
    public void restart() {

    }

}
