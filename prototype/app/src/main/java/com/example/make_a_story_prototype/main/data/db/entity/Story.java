package com.example.make_a_story_prototype.main.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity(tableName = "story_table")
public class Story {

    @PrimaryKey
    private int storyId;
    private String title;
    private int imageResource;

    public Story(int storyId, String title, int imageResource) {
        this.storyId = storyId;
        this.title = title;
        this.imageResource = imageResource;
    }

    public int getStoryId() {
        return storyId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

}
