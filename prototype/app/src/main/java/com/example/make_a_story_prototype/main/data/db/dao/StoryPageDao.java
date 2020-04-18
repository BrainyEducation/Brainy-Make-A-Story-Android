package com.example.make_a_story_prototype.main.data.db.dao;

import com.example.make_a_story_prototype.main.data.db.entity.StoryPage;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface StoryPageDao {
    @Insert
    void insertStoryPages(StoryPage...storyPages);
}
