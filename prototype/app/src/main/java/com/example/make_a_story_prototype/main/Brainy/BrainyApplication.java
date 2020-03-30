package com.example.make_a_story_prototype.main.Brainy;

import android.app.Application;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class BrainyApplication extends Application {

    public NavigationController navigationController;

    @Override
    public void onCreate() {
        super.onCreate();

        navigationController = new NavigationController();
    }
}
