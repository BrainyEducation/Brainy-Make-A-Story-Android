package com.example.make_a_story_prototype.main.vm;

import com.example.make_a_story_prototype.main.model.CardItem;

public class CardItemViewModel {
    public CardItem cardItem;

    public int backgroundColor;
    public int contrastColor;

    public CardItemViewModel(CardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
    }
}
