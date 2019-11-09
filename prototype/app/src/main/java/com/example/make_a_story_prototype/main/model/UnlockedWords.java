package com.example.make_a_story_prototype.main.model;

import java.util.ArrayList;
import java.util.List;

public class UnlockedWords {
    public static List<String> unlockedWords = new ArrayList<String>() {{
        add("juice");
        add("bread");
        add("banana");
        add("bread");
        add("cheese");
        add("cake");
        add("carrot");
        add("sandwich");
        add("egg");
        add("jam");
    }};

    public static boolean contains(String word) {
        return unlockedWords.contains(word);
    }
}
