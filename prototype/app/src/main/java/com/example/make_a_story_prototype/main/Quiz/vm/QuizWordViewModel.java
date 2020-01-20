package com.example.make_a_story_prototype.main.Quiz.vm;

import com.example.make_a_story_prototype.R;

import java.util.HashMap;
import java.util.Map;

public class QuizWordViewModel {
    private static Map<String, Integer> quizImages = new HashMap<String, Integer>() {{
                put("apple", R.drawable.ic_apple);
                put("juice", R.drawable.ic_juice);
                put("bread", R.drawable.ic_bread);
                put("banana", R.drawable.ic_banana);
                put("cheese", R.drawable.ic_cheese);
                put("cake", R.drawable.ic_cake);
                put("carrot", R.drawable.ic_carrot);
                put("sandwich", R.drawable.ic_sandwich);
                put("egg", R.drawable.ic_egg);
                put("jam", R.drawable.ic_jam);
    }};

    public int getDrawable(String key) {
        return quizImages.get(key);
    }
}
