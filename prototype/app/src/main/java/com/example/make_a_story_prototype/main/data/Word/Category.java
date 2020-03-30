package com.example.make_a_story_prototype.main.data.Word;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words_table")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int imageResource;
    private int audioResource;

    public Category(int id, String name, int imageResource, int audioResource) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
    }

    public int getId() {
        return id;
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
