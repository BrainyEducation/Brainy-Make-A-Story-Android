package com.example.make_a_story_prototype.main.StoryTemplate.model;

import java.util.List;

public class StoryPage {
    private final int imageResource;
    private final List<StorySegment> segments;

    public StoryPage(int imageResource, List<StorySegment> segments) {
        this.imageResource = imageResource;
        this.segments = segments;
    }

    public int getImageResource() {
        return imageResource;
    }

    public List<StorySegment> getSegments() {
        return segments;
    }
}
