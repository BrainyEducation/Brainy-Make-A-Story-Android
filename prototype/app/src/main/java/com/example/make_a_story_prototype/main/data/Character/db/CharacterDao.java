package com.example.make_a_story_prototype.main.data.Character.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CharacterDao {
    @Query("SELECT * FROM character_table")
    List<Character> getCharacters();

    @Query("SELECT * FROM character_table WHERE characterId = :searchId")
    Character getCharacter(int searchId);

    @Insert
    void insertCharacters(Character...characters);
}
