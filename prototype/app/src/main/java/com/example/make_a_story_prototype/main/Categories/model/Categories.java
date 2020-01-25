package com.example.make_a_story_prototype.main.Categories.model;

import com.example.make_a_story_prototype.R;

public class Categories {
    private String[] categories = {
            "Food",
            "Outdoors",
            "Clothes",
            "Animals",
            "House Stuff",
            "Toys",
            "Places",
            "Colors",
            "Birds",
            "Vehicles"
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

    private Integer[] categoryAudio = {
            R.raw.food,
            R.raw.outdoors,
            R.raw.clothes,
            R.raw.animals,
            R.raw.house_stuff,
            R.raw.toys,
            R.raw.places,
            R.raw.colors,
            R.raw.birds,
            R.raw.vehicles,
    };

    public String[] getCategories() {
        return categories;
    }

    public Integer[] getCategoryImages() {
        return categoryImages;
    }

    public Integer[] getCategoryAudio() {
        return categoryAudio;
    }
}
