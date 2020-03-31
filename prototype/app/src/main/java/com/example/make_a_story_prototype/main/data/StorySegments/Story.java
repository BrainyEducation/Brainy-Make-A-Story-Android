package com.example.make_a_story_prototype.main.data.StorySegments;

import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryPage;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "story_table")
public class Story {

    @PrimaryKey
    int storyId;
    String storyName;

    public Story(int storyId, String storyName) {
        this.storyId = storyId;
        this.storyName = storyName;
    }

}
