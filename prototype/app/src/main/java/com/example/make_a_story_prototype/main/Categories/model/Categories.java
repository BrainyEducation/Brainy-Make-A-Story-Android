package com.example.make_a_story_prototype.main.Categories.model;

import com.example.make_a_story_prototype.R;

public class Categories {
    private String[] categories = {
            "Food",
            "Nature",
            "Clothing",
            "Animals",
            "Home",
            "Sports",
            "Numbers",
            "Colors",
            "Weather",
            "School"
    };

    private Integer[] categoryImages = {
            R.drawable.ic_apple,
            R.drawable.ic_tree,
            R.drawable.ic_pullover,
            R.drawable.ic_cow,
            R.drawable.ic_house,
            R.drawable.ic_soccer,
            R.drawable.ic_dice,
            R.drawable.ic_colors,
            R.drawable.ic_rain,
            R.drawable.ic_bus
    };

    public String[] getCategories() {
        return categories;
    }

    public Integer[] getCategoryImages() {
        return categoryImages;
    }
}
