package com.example.make_a_story_prototype.main.Categories.model;

public class CategoryCardItem {
    private int imageResource;
    private int imageAudio;
    private String imageLabel;

    public CategoryCardItem(int imageAudio, int imageResource, String imageLabel) {
        this.imageAudio = imageAudio;
        this.imageResource = imageResource;
        this.imageLabel = imageLabel;
    }

    public int getImageAudio() { return imageAudio; }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageLabel() {
        return imageLabel;
    }
}
