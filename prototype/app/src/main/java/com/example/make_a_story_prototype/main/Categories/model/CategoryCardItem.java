package com.example.make_a_story_prototype.main.Categories.model;

public class CategoryCardItem {
    private int imageResource;
    private String imageLabel;

    public CategoryCardItem(int imageResource, String imageLabel) {
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
