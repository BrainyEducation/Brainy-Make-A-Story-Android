package com.example.make_a_story_prototype.main.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories_table")
public class Category {

    @PrimaryKey
    private int categoryId;
    private String name;
    private int imageResource;
    private int audioResource;

    public Category(int categoryId, String name, int imageResource, int audioResource) {
        this.categoryId = categoryId;
        this.name = name;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
    }

    public int getId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getAudioResource() {
        return audioResource;
    }
}
