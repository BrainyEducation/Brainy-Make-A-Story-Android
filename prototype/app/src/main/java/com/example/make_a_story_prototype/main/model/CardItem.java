package com.example.make_a_story_prototype.main.model;

public class CardItem {
    private int imageResource;
    private String imageLabel;

    public CardItem(int imageResource, String imageLabel) {
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
