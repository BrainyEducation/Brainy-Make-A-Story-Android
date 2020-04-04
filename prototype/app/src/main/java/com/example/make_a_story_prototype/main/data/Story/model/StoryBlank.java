package com.example.make_a_story_prototype.main.data.Story.model;

import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.ImageLocation;

public class StoryBlank {
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
