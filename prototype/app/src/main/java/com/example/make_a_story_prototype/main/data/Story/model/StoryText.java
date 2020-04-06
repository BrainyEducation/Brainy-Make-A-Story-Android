package com.example.make_a_story_prototype.main.data.Story.model;

public class StoryText implements StorySegment {
    private String text;
    private int audioResource;

    public StoryText(String text, int audioResource) {

        this.text = text;
        this.audioResource = audioResource;
    }

    public String getText() {
        return text;
    }

    public int getAudioResource() {
        return audioResource;
    }
}