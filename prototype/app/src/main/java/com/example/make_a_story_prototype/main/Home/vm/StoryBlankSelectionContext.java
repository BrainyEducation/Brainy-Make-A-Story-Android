package com.example.make_a_story_prototype.main.Home.vm;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class StoryBlankSelectionContext implements NavigationController.NavigationContext {
    private int storyId;
    private String blankId;
    private int pageNumber;
    private int audioIndex;

    public StoryBlankSelectionContext(int storyId, String blankId, int pageNumber, int audioIndex) {
        this.storyId = storyId;
        this.blankId = blankId;
        this.pageNumber = pageNumber;
        this.audioIndex = audioIndex;
    };

    public int getStoryId() {
        return storyId;
    }

    public String getBlankId() {
        return blankId;
    }

    public int getPageNumber() { return pageNumber; }

    public int getAudioIndex() { return audioIndex; }
}
