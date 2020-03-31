package com.example.make_a_story_prototype.main.data.StorySegments;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_segments_table")
public class TextSegment {

    @PrimaryKey(autoGenerate = false)
    private int id;
    private String text;
    private int storyId;
    private int pageNumber;

    public TextSegment(int storyId, int pageNumber, String text) {
        this.storyId = storyId;
        this.pageNumber = pageNumber;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getStoryId() {
        return storyId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getText() {
        return text;
    }

}

