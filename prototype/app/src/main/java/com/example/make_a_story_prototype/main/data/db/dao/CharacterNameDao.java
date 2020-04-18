package com.example.make_a_story_prototype.main.data.db.dao;

import com.example.make_a_story_prototype.main.data.db.entity.CharacterName;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CharacterNameDao {
    @Query("SELECT * FROM character_name_table")
    List<CharacterName> getCharacterNames();

    @Insert
    void insertCharacterNames(CharacterName...characterNames);
}
