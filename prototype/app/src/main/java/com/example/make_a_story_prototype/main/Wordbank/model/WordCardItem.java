package com.example.make_a_story_prototype.main.Wordbank.model;

public class WordCardItem {
    private int imageResource;
    private String imageLabel;
    private int audioResource;

    public WordCardItem(int imageResource, String imageLabel, int audioResource) {
        this.imageResource = imageResource;
        this.imageLabel = imageLabel;
        this.audioResource = audioResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageLabel() {
        return imageLabel;
    }

    public int getAudioResource() {
        return audioResource;
    }
}
