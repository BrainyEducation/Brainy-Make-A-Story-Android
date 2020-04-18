package com.example.make_a_story_prototype.main.data.Story.db;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface BlankDao {
    @Insert
    void insertBlanks(Blank...blanks);
}
