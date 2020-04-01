package com.example.make_a_story_prototype.main.data;

import com.example.make_a_story_prototype.main.data.Story.db.TextSegment;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TextSegmentDao {

    @Insert
    void insert(TextSegment textSegment);

    @Query("SELECT * FROM text_segments_table")
    List<TextSegment> getAllTextSegments();
}
