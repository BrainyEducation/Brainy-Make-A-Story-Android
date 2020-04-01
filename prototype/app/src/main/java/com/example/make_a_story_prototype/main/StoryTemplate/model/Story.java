package com.example.make_a_story_prototype.main.StoryTemplate.model;

import java.util.List;
import java.util.Map;

public class Story {
    private final String title;
    private final List<StoryPage> pages;
    private final Map<String, StoryBlank> blanks;

    public Story(String title, List<StoryPage> pages, Map<String, StoryBlank> blanks) {
        this.title = title;
        this.pages = pages;
        this.blanks = blanks;
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
