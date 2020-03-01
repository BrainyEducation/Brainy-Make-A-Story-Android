package com.example.make_a_story_prototype.main.StoryTemplate.model;

import com.example.make_a_story_prototype.R;

import java.util.HashMap;
import java.util.Map;

public class Stories {
    private Map<String, Integer> stories = new HashMap<>();

    public Stories () {
        stories.put("The Special Invention", R.drawable.story_special_invention);
        stories.put("The Wacky Costume Party", R.drawable.story_wacky_costume_party);
        stories.put("Santa's Mixed-up Helper Elf", R.drawable.story_santas_elf);
        stories.put("The Space Alien", R.drawable.story_space_alien_5);
    }

    public int getStoryImage(String title) {
        return stories.get(title);
    }
}
