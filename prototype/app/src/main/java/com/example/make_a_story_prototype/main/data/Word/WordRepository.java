package com.example.make_a_story_prototype.main.data.Word;

import java.util.List;

public interface WordRepository {

    List<Category> getCategories();
    List<Word> getWordsForCategory(Category category);
    Category getCategory(int id);

    Word getWord(int id);
    Word[] getWords();
}
