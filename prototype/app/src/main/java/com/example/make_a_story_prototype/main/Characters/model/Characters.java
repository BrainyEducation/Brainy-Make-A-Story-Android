package com.example.make_a_story_prototype.main.Characters.model;

import com.example.make_a_story_prototype.R;

public class Characters {
    private String[] characterNames = {
            "Ali",
            "Han",
            "Dev",
            "Don",
            "Duc",
            "Ted",
            "Pau",
            "Paz",
            "Ron",
            "Kim",
            "Jim",
            "Eli",
            "Peg",
            "Lin",
            "Wen",
            "Luz",
            "Zoe",
            "Eva",
            "Mia",
            "Uma",
            "Rio",
            "Joy"
    };

    private Integer[] characterImages = {
            R.drawable.ic_apple,
            R.drawable.ic_apple,
            R.drawable.ic_apple,
            R.drawable.ic_apple,
            R.drawable.ic_house,
            R.drawable.ic_soccer,
            R.drawable.ic_dice,
            R.drawable.ic_colors,
            R.drawable.ic_rain,
            R.drawable.ic_bus,
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

    public String[] getCharacterNames() {
        return characterNames;
    }

    public Integer[] getCharacterImages() {
        return characterImages;
    }
}
