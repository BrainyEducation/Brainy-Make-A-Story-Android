package com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model;

public class BlankSelection {
    private String text;
    private int imageResource;

    public BlankSelection(String text, int imageResource) {
        this.text = text;
        this.imageResource = imageResource;
    }

    public String getText() {
        return text;
    }

    public int getImageResource() {
        return imageResource;
    }

}