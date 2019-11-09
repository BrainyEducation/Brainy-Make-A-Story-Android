package com.example.make_a_story_prototype.main.model;

import com.example.make_a_story_prototype.R;

public class Words {
    private String[] words = {
            "Apple",
            "Juice",
            "Bread",
            "Banana",
            "Cheese",
            "Cake",
            "Carrot",
            "Sandwich",
            "Egg",
            "Jame"
    };

    private Integer[] wordImages = {
            R.drawable.ic_apple,
            R.drawable.ic_juice,
            R.drawable.ic_bread,
            R.drawable.ic_banana,
            R.drawable.ic_cheese,
            R.drawable.ic_cake,
            R.drawable.ic_carrot,
            R.drawable.ic_sandwich,
            R.drawable.ic_egg,
            R.drawable.ic_jam,
    };

    public String[] getWords() {
        return words;
    }

    public Integer[] getWordImages() {
        return wordImages;
    }
}
