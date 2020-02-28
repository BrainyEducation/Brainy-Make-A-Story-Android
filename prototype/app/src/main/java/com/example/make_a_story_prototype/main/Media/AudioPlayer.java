package com.example.make_a_story_prototype.main.Media;

import android.app.Application;

public final class AudioPlayer extends Application {

    static android.media.MediaPlayer instance;

    public static android.media.MediaPlayer getInstance() {
        if (instance == null) {
            instance = new android.media.MediaPlayer();

        }

        return instance;
    }
}
