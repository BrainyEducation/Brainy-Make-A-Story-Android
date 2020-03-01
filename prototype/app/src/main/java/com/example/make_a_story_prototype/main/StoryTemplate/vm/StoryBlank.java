package com.example.make_a_story_prototype.main.StoryTemplate.vm;

public class StoryBlank {
    class ImageLocation {
        float x;
        float y;
        float width;
        float height;
        float rotation;
    }

    String identifier;
    ImageLocation imageLocation;

    public StoryBlank(String identifier) {
        this(identifier, null);
    }

    public StoryBlank(String identifier, ImageLocation imageLocation) {
        this.identifier = identifier;
        this.imageLocation = imageLocation;
    }

}
