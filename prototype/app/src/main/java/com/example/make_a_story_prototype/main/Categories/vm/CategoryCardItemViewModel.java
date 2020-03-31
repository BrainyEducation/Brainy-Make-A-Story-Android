package com.example.make_a_story_prototype.main.Categories.vm;

import com.example.make_a_story_prototype.main.data.Word.Category;

public class CategoryCardItemViewModel {
    public Category category;

    public int backgroundColor;
    public int contrastColor;
    public boolean isSelected;

    public CategoryCardItemViewModel(Category category, int backgroundColor, int contrastColor) {
        this.category = category;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isSelected = false;
    }
}
