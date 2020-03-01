package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import androidx.annotation.NonNull;

public class StoryBlank {
    class ImageLocation {
        float x;
        float y;
        float width;
        float height;
        float rotation;
    }

    StoryBlankIdentifier identifier;
    ImageLocation imageLocation;

    public StoryBlank(StoryBlankIdentifier identifier) {
        this(identifier, null);
    }

    public StoryBlank(StoryBlankIdentifier identifier, ImageLocation imageLocation) {
        this.identifier = identifier;
        this.imageLocation = imageLocation;
    }

    @NonNull
    @Override
    public String toString() {
        return " BLANK ";
    }
}
