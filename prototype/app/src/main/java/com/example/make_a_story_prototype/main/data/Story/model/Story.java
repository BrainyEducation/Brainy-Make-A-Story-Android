package com.example.make_a_story_prototype.main.data.Story.model;

import java.util.List;
import java.util.Map;

public class Story {
    private int storyId;
    private String title;
    private List<StoryPage> pages;
    private Map<String, StoryBlank> blanks;

    public Story(int storyId, String title, List<StoryPage> pages, Map<String, StoryBlank> blanks) {
        this.storyId = storyId;
        this.title = title;
        this.pages = pages;
        this.blanks = blanks;
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

    public Map<String, StoryBlank> getBlanks() {
        return blanks;
    }
}
