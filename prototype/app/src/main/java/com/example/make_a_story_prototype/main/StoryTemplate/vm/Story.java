package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import java.util.List;
import java.util.Map;

public class Story {
    private List<StoryPage> pages;
    private Map<String, StoryBlank> blanks;

    public Story(List<StoryPage> pages, Map<String, StoryBlank> blanks) {
        this.pages = pages;
        this.blanks = blanks;
    }

    public List<StoryPage> getPages() {
        return pages;
    }

    public Map<String, StoryBlank> getBlanks() {
        return blanks;
    }
}
