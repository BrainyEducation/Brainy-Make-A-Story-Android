package com.example.make_a_story_prototype.main.data.Story.model;

import java.util.List;
import java.util.Map;

public class Story {
    private int storyId;
    private String title;
    private List<StoryPage> pages;
    private int imageResource;

    public Story(int storyId, String title, List<StoryPage> pages, int imageResource) {
        this.storyId = storyId;
        this.title = title;
        this.pages = pages;
        this.imageResource = imageResource;
    }

    public int getStoryId() {
        return storyId;
    }

    public String getTitle() {
        return title;
    }

    public List<StoryPage> getPages() {
        return pages;
    }

    public int getImageResource() {
        return imageResource;
    }
}
