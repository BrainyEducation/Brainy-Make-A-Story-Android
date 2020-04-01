package com.example.make_a_story_prototype.main.StoryTemplate.model;

public class StoryBlankIdentifier implements StorySegment {
    private final String identifier;

    public String get() {
        return identifier;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    public StoryBlankIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
