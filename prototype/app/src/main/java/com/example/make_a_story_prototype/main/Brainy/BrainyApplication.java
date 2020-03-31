package com.example.make_a_story_prototype.main.Brainy;

import android.app.Application;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;
import com.example.make_a_story_prototype.main.data.MasteredWords.DebugMasteredWordsRepository;

import java.io.IOException;

public class BrainyApplication extends Application {

    public NavigationController navigationController;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            DebugMasteredWordsRepository.initialize(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        navigationController = new NavigationController();
    }
}
