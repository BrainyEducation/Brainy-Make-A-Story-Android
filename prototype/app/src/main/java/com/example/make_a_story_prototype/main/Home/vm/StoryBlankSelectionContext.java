package com.example.make_a_story_prototype.main.Home.vm;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class StoryBlankSelectionContext implements NavigationController.NavigationContext {
    private int storyId;
    private String blankId;
    private int pageNumber;

    public StoryBlankSelectionContext(int storyId, String blankId, int pageNumber) {
        this.storyId = storyId;
        this.blankId = blankId;
        this.pageNumber = pageNumber;
    };

    public int getStoryId() {
        return storyId;
    }

    public String getBlankId() {
        return blankId;
    }

    public int getPageNumber() { return pageNumber; }
}
