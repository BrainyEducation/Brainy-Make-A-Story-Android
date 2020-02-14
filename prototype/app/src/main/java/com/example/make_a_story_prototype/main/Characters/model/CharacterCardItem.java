package com.example.make_a_story_prototype.main.Characters.model;

public class CharacterCardItem {
    private int imageResource;
    private String imageLabel;

    public CharacterCardItem(int imageResource, String imageLabel) {
        this.imageResource = imageResource;
        this.imageLabel = imageLabel;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageLabel() {
        return imageLabel;
    }
}
