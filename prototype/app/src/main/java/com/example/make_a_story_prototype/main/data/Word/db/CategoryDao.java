package com.example.make_a_story_prototype.main.data.Word.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories_table")
    List<Category> getCategories();

    @Query("SELECT * FROM categories_table WHERE categoryId = :searchId")
    Category getCategory(int searchId);

    @Insert
    void insertCategories(Category...categories);
}
