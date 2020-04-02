package com.example.make_a_story_prototype.main.Categories.vm;

import com.example.make_a_story_prototype.main.data.Word.Category;

public class CategoryCardItemViewModel {
    public Category category;
    public boolean isSelected;

    public CategoryCardItemViewModel(Category category) {
        this.category = category;
        this.isSelected = false;
    }
}
