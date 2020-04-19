package com.example.make_a_story_prototype.main.Characters.model;

class CharacterCardItem {
    private final int imageResource;
    private final String imageLabel;

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
