package com.example.make_a_story_prototype.main.data.db.dao;

import com.example.make_a_story_prototype.main.data.db.entity.TextSegment;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TextSegmentDao {
    @Insert
    void insertTextSegments(TextSegment...textSegments);

}
