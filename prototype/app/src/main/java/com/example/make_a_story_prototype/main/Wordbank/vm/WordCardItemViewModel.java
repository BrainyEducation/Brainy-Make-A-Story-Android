package com.example.make_a_story_prototype.main.Wordbank.vm;

import com.example.make_a_story_prototype.main.Wordbank.model.WordCardItem;

public class WordCardItemViewModel {
    public final WordCardItem cardItem;

    public final int backgroundColor;
    public final int contrastColor;
    public final boolean isUnlocked;
    public boolean isSelected;

    public WordCardItemViewModel(WordCardItem cardItem, int backgroundColor, int contrastColor, boolean isUnlocked) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isUnlocked = isUnlocked;
        this.isSelected = false;
    }
}
