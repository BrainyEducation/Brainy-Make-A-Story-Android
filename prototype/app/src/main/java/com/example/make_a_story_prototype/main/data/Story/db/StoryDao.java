package com.example.make_a_story_prototype.main.data.Story.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface StoryDao {
    //returns all stories
    @Query("SELECT * FROM story_table")
    List<Story> getStories();

    //returns a specific story by id
//    @Query("SELECT * FROM story_table WHERE storyId = searchId")
//    Story getStory(int searchId);
}
