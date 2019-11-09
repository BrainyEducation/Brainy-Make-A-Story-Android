package com.example.make_a_story_prototype.main.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.model.CategoryCardItem;
import com.example.make_a_story_prototype.main.model.UnlockedWords;
import com.example.make_a_story_prototype.main.model.WordCardItem;
import com.example.make_a_story_prototype.main.model.Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.core.content.ContextCompat;

public class WordbankViewModel {
    private List<WordCardItemViewModel> cardList = new ArrayList<>();

    public WordbankViewModel(Context context) {
        Map<String, Integer> colors = new HashMap<>();
        colors.put("locked background", ContextCompat.getColor(context, R.color.colorLockedBackground));
        colors.put("locked contrast", ContextCompat.getColor(context, R.color.colorLockedContrast));
        colors.put("unlocked background", ContextCompat.getColor(context, R.color.colorWordBackground));
        colors.put("unlocked contrast", ContextCompat.getColor(context, R.color.colorWordContrast));

        Words words = new Words();
        List<String> wordNames = Arrays.asList(words.getWords());
        List<Integer> wordImages = Arrays.asList(words.getWordImages());

        for (int i = 0; i < 10; i++) {
            String backgroundKey;
            String contrastKey;

            if (UnlockedWords.contains(wordNames.get(i).toLowerCase())) {
                backgroundKey = "unlocked background";
                contrastKey = "unlocked contrast";
            } else {
                backgroundKey = "locked background";
                contrastKey = "locked contrast";
            }
            String wordName = wordNames.get(i);
            cardList.add(
                    new WordCardItemViewModel(
                            new WordCardItem(wordImages.get(i), wordName),
                            colors.get(backgroundKey),
                            colors.get(contrastKey), UnlockedWords.contains(wordName.toLowerCase())
                    )
            );
        }
    }

    public List<WordCardItemViewModel> getCardList() {
        return cardList;
    }
}
