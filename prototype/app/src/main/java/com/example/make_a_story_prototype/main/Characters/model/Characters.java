package com.example.make_a_story_prototype.main.Characters.model;

import com.example.make_a_story_prototype.R;

public class Characters {
    private final String[] characterNames = {
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

    private final Integer[] characterImages = {
            R.drawable.ic_kids_01,
            R.drawable.ic_kids_02,
            R.drawable.ic_kids_03,
            R.drawable.ic_kids_01,
            R.drawable.ic_kids_02,
            R.drawable.ic_kids_03,
            R.drawable.ic_kids_01,
            R.drawable.ic_kids_02,
            R.drawable.ic_kids_03,
            R.drawable.ic_kids_01,
            R.drawable.ic_kids_02,
            R.drawable.ic_kids_03,
    };

    public String[] getCharacterNames() {
        return characterNames;
    }

    public Integer[] getCharacterImages() {
        return characterImages;
    }
}
