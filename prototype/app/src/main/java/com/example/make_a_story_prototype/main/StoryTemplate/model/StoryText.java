package com.example.make_a_story_prototype.main.StoryTemplate.model;

import androidx.annotation.NonNull;

public class StoryText implements StorySegment {
    String text;
    // audio file

    public StoryText(String text) {
        this.text = text;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
    }
}