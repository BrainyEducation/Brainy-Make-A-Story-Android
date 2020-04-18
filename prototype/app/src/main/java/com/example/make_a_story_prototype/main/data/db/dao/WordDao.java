package com.example.make_a_story_prototype.main.data.db.dao;

import com.example.make_a_story_prototype.main.data.db.entity.Word;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WordDao {
    @Query("SELECT * FROM words_table")
    List<Word> getWords();

    @Query("SELECT * FROM words_table WHERE wordId = :searchId")
    Word getWord(int searchId);

    @Query("SELECT * FROM words_table WHERE categoryId = :searchId")
    List<Word> getWordsForCategory(int searchId);

    @Insert
    void insertWords(Word...words);
}
