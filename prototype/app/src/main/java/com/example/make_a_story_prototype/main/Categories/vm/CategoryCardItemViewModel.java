package com.example.make_a_story_prototype.main.Categories.vm;

import com.example.make_a_story_prototype.main.Categories.model.CategoryCardItem;

public class CategoryCardItemViewModel {
    public final CategoryCardItem cardItem;

    public final int backgroundColor;
    public final int contrastColor;
    public boolean isSelected;

    public CategoryCardItemViewModel(CategoryCardItem cardItem, int backgroundColor, int contrastColor) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isSelected = false;
    }
}
