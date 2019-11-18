package com.example.make_a_story_prototype.main.vm;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.model.CategoryCardItem;
import com.example.make_a_story_prototype.main.model.WordCardItem;
import com.example.make_a_story_prototype.main.model.Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.core.content.ContextCompat;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class WordbankViewModel {
    private static List<String> unlockedWords = new ArrayList<String>() {{
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

    private static WordbankViewModel _instance;

    public static WordbankViewModel instance(Context context) {
        if (_instance == null) {
            _instance = new WordbankViewModel(context);
        }

        return _instance;
    }

    public static WordbankViewModel instance() {
        return _instance;
    }

    private Map<String, Integer> colors = new HashMap<>();
    private List<WordCardItemViewModel> cardList = new ArrayList<>();

    public BehaviorSubject<List<WordCardItemViewModel>> _cardList = BehaviorSubject.createDefault(cardList);

    private WordbankViewModel(Context context) {
        colors.put("locked background", ContextCompat.getColor(context, R.color.colorLockedBackground));
        colors.put("locked contrast", ContextCompat.getColor(context, R.color.colorLockedContrast));
        colors.put("unlocked background", ContextCompat.getColor(context, R.color.colorWordBackground));
        colors.put("unlocked contrast", ContextCompat.getColor(context, R.color.colorWordContrast));

        updateCardList();
    }

    // make observable
    public List<WordCardItemViewModel> getCardList() {
        return cardList;
    }

    public Observable<List<WordCardItemViewModel>> getCardListObservable() {
        return _cardList;
    }

    public void unlockWord(String word) {
        unlockedWords.add(word);

        updateCardList();
    }

    private void updateCardList() {
        cardList.clear();

        Words words = new Words();
        List<String> wordNames = Arrays.asList(words.getWords());
        List<Integer> wordImages = Arrays.asList(words.getWordImages());

        for (int i = 0; i < 10; i++) {
            String backgroundKey;
            String contrastKey;

            if (unlockedWords.contains(wordNames.get(i).toLowerCase())) {
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
                            colors.get(contrastKey), unlockedWords.contains(wordName.toLowerCase())
                    )
            );
        }

        _cardList.onNext(cardList);
    }
}
