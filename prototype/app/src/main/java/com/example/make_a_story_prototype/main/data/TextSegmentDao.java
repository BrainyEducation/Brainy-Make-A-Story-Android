package com.example.make_a_story_prototype.main.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TextSegmentDao {

    @Insert
    void insert(TextSegment textSegment);

    @Query("SELECT * FROM text_segments_table")
    List<TextSegment> getAllTextSegments();

    @Query("SELECT * FROM text_segments_table WHERE storyName=:story AND pageNumber=:page")
    List<TextSegment> getAllTextSegmentsForPage(String story, int page);
}
