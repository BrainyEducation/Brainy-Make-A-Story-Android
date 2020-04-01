package com.example.make_a_story_prototype.main.data.Story;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pages_table")
public class StoryPage {
    @PrimaryKey
    private int pageId;
    private int storyId;
    private int imageResource;
    private int pageNumber;
    //private List<StorySegment> segments;

    public StoryPage(int pageId, int storyId, int imageResource, int pageNumber) {
        this.pageId = pageId;
        this.storyId = storyId;
        this.imageResource = imageResource;
        this.pageNumber = pageNumber;
        //this.segments = segments;
    }

    public int getPageId() {
        return pageId;
    }

    public int getStoryId() {
        return storyId;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    //public List<StorySegment> getSegments() {
    //   return segments;
    //}
}