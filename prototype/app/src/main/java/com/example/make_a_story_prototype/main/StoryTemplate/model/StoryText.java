package com.example.make_a_story_prototype.main.StoryTemplate.model;

public class StoryText implements StorySegment {
    private final String text;
    // audio file

    public StoryText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}