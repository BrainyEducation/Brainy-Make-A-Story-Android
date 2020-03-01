package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import java.util.List;

public class Story {
    private List<StoryPage> pages;
    private List<StoryBlank> blanks;

    public Story(List<StoryPage> pages, List<StoryBlank> blanks) {
        this.pages = pages;
        this.blanks = blanks;
    }

    public List<StoryPage> getPages() {
        return pages;
    }

    public List<StoryBlank> getBlanks() {
        return blanks;
    }
}
