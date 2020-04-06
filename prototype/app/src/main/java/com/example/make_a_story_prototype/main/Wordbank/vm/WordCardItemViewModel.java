package com.example.make_a_story_prototype.main.Wordbank.vm;

import com.example.make_a_story_prototype.main.data.Word.Word;

public class WordCardItemViewModel {
    public Word word;
    public boolean isUnlocked;
    public boolean isSelected;

    public WordCardItemViewModel(Word word, boolean isUnlocked) {
        this.word = word;
        this.isUnlocked = isUnlocked;
        this.isSelected = false;
    }
}
