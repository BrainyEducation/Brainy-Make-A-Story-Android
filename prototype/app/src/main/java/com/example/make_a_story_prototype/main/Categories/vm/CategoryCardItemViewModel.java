package com.example.make_a_story_prototype.main.Categories.vm;

import com.example.make_a_story_prototype.main.Categories.model.CategoryCardItem;

public class CategoryCardItemViewModel {
    public CategoryCardItem cardItem;

    public int backgroundColor;
    public int contrastColor;
    public boolean isSelected;

    public CategoryCardItemViewModel(CategoryCardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isSelected = false;
    }
}
