package com.example.make_a_story_prototype.main.data.Character.db;

import androidx.room.Entity;

@Entity(tableName = "character_image_table")
public class CharacterImage {

    private int imageId;
    private int imageResource;

    public CharacterImage(int imageId, int imageResource) {
        this.imageId = imageId;
        this.imageResource = imageResource;
    }

    public int getImageId() { return imageId; }

    public int getImageResource() {
        return imageResource;
    }
}