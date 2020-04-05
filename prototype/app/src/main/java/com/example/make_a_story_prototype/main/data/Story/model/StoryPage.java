package com.example.make_a_story_prototype.main.data.Story.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryPage {
    private int imageResource;
    private List<StorySegment> segments;
    private Map<String, ImageLocation> imageLocations;

    public StoryPage(int imageResource, List<StorySegment> segments) {
        this(imageResource, segments, null);
    }

    public StoryPage(int imageResource, List<StorySegment> segments, Map<String, ImageLocation> imageLocations) {
        this.imageResource = imageResource;
        this.segments = segments;

        if (imageLocations != null) {
            this.imageLocations = imageLocations;
        } else {
            this.imageLocations = new HashMap<>();
        }
    }

    public int getImageResource() {
        return imageResource;
    }

    public List<StorySegment> getSegments() {
        return segments;
    }

    public Map<String, ImageLocation> getImageLocations() { return imageLocations; }
}
