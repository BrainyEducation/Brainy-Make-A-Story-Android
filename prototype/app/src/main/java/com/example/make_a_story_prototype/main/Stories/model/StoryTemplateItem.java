package com.example.make_a_story_prototype.main.Stories.model;

public class StoryTemplateItem {
    private int storyImageResource;
    private String storyTitle;

    public StoryTemplateItem(int storyImageResource, String storyTitle) {
        this.storyImageResource = storyImageResource;
        this.storyTitle = storyTitle;
    }

    public int storyImageResource() {
        return storyImageResource;
    }

    public String storyTitle() {
        return storyTitle;
    }
}

