package com.example.make_a_story_prototype.main.StoryTemplate.model;

public class StoryTemplate {
    private int storyImageResource;
    private String storyTitle;

    public StoryTemplate(int storyImageResource, String storyTitle) {
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
