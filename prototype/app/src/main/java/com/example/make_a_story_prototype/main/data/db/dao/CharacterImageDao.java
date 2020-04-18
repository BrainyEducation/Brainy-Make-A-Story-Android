package com.example.make_a_story_prototype.main.data.db.dao;

import com.example.make_a_story_prototype.main.data.db.entity.CharacterImage;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CharacterImageDao {
    @Query("SELECT * FROM character_image_table")
    List<CharacterImage> getCharacterImages();

    @Insert
    void insertCharacterImages(CharacterImage...characterImages);
}
