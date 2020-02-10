package com.example.make_a_story_prototype.main.Characters.vm;

import com.example.make_a_story_prototype.main.Characters.model.CharacterCardItem;

public class NameCardItemViewModel {
    public CharacterCardItem cardItem;

    public int backgroundColor;
    public int contrastColor;
    public boolean isSelected;

    public NameCardItemViewModel(CharacterCardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isSelected = false;
    }
}
