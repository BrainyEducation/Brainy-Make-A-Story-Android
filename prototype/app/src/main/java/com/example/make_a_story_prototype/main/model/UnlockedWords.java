package com.example.make_a_story_prototype.main.model;

import java.util.ArrayList;
import java.util.List;

public class UnlockedWords {
    public static List<String> unlockedWords = new ArrayList<String>() {{
        add("apple");
        add("cheese");
    }};

    public static boolean contains(String word) {
        return unlockedWords.contains(word);
    }
}
