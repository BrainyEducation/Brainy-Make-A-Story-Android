package com.example.make_a_story_prototype.main.Home.vm;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class StoryContext implements NavigationController.NavigationContext {
    private int storyId;

    public StoryContext() {
        this.storyId = -1;
    };

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
}
