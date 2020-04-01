package com.example.make_a_story_prototype.main.data;

import com.example.make_a_story_prototype.main.data.Story.Blank;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

@Dao
public interface BlankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBlank(Blank blank);

    @Update
    void update(Blank blank);

    @Delete
    void delete(Blank blank);

//    @Query("SELECT * FROM blanks_table WHERE storyID = :storyID")
//    List<Blank> getAllBlanksFromStory(String storyID);

}

