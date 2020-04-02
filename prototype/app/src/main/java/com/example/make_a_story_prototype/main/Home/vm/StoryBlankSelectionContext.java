package com.example.make_a_story_prototype.main.Home.vm;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class StoryBlankSelectionContext implements NavigationController.NavigationContext {
    private int storyId;
    private String blankId;

    public StoryBlankSelectionContext(int storyId, String blankId) {
        this.storyId = storyId;
        this.blankId = blankId;
    };

    public int getStoryId() {
        return storyId;
    }

    public String getBlankId() {
        return blankId;
    }
}
