package com.example.make_a_story_prototype.main.data;

import com.example.make_a_story_prototype.main.data.Word.Word;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);

    @Query("DELETE FROM words_table")
    void deleteAllWords();

    @Query("SELECT * FROM words_table")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * FROM words_table WHERE category=:category")
    LiveData<List<Word>> getAllWordsInCategory(String category);
}
