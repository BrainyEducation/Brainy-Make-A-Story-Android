package com.example.make_a_story_prototype.main.StoryTemplate.model;

class StoryBlank {
    class ImageLocation {
        float x;
        float y;
        float width;
        float height;
        float rotation;
    }

    private final String identifier;
    private final ImageLocation imageLocation;

    public StoryBlank(String identifier) {
        this(identifier, null);
    }

    private StoryBlank(String identifier, ImageLocation imageLocation) {
        this.identifier = identifier;
        this.imageLocation = imageLocation;
    }

}
