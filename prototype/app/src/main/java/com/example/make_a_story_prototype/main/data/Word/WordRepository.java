package com.example.make_a_story_prototype.main.data.Word;

import java.util.List;

import io.reactivex.Single;

public interface WordRepository {

    Single<List<Category>> getCategories();
    Single<List<Word>> getWordsForCategory(Category category);
    Single<Category> getCategory(int id);

    Single<Word> getWord(int id);
    Single<List<Word>> getWords();
}
