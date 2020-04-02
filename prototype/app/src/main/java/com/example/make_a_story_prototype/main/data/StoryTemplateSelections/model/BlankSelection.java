package com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model;

public class BlankSelection {
    private String text;
    private int imageResource;
    private int audioResource;

    public BlankSelection(String text, int imageResource, int audioResource) {
        this.text = text;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
    }

    public String getText() {
        return text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getAudioResource() {
        return audioResource;
    }

}