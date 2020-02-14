package com.example.make_a_story_prototype.main.Characters.vm;

import com.example.make_a_story_prototype.main.Characters.model.CharacterCardItem;

public class CharacterCardItemViewModel {
    public CharacterCardItem cardItem;

    public int backgroundColor;
    public int contrastColor;
    public boolean isSelected;

    public CharacterCardItemViewModel(CharacterCardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isSelected = false;
    }
}
