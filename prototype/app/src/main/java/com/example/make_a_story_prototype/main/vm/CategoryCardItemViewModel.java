package com.example.make_a_story_prototype.main.vm;

import com.example.make_a_story_prototype.main.model.CategoryCardItem;

public class CategoryCardItemViewModel {
    public CategoryCardItem cardItem;

    public int backgroundColor;
    public int contrastColor;

    public CategoryCardItemViewModel(CategoryCardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
    }
}
