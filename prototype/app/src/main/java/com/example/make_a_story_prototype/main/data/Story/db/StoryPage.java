package com.example.make_a_story_prototype.main.data.Story.db;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "pages_table",
        foreignKeys = @ForeignKey(entity = Story.class,
                parentColumns = "pageId", childColumns = "storyId"))

public class StoryPage {

    @PrimaryKey
    private int pageId;
    private int imageResource;

    public StoryPage(int pageId, int storyId, int imageResource, int pageNumber) {
        this.pageId = pageId;
        this.imageResource = imageResource;
    }

    public int getPageId() {
        return pageId;
    }

    public int getImageResource() {
        return imageResource;
    }

}