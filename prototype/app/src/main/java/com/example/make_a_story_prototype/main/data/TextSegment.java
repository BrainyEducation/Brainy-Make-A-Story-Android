package com.example.make_a_story_prototype.main.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_segments_table")
public class TextSegment {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private String storyName;
    private int pageNumber;

    public TextSegment(String storyName, int pageNumber, String text) {
        this.storyName = storyName;
        this.pageNumber = pageNumber;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStoryName() {
        return storyName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getText() {
        return text;
    }

}

