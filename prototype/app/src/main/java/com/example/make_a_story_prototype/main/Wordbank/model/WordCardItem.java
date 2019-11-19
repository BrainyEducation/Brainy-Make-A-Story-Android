package com.example.make_a_story_prototype.main.Wordbank.model;

public class WordCardItem {
    private int imageResource;
    private String imageLabel;

    public WordCardItem(int imageResource, String imageLabel) {
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
