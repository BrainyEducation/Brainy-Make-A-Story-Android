package com.example.make_a_story_prototype.main.Wordbank.vm;

import android.content.Context;
import android.content.res.Resources;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Wordbank.model.WordCardItem;
import com.example.make_a_story_prototype.main.Wordbank.model.Words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class WordbankViewModel {

    private static List<String> unlockedWords = new ArrayList<String>() {{}};

    private String category;

    private Resources resources;
    private String packageName;
    private File unlockedWordsFile;

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

        resources = context.getResources();
        packageName = context.getPackageName();
        unlockedWordsFile = context.getFileStreamPath("unlockedWords.csv");
        if(unlockedWordsFile.exists()) {
            try {
                FileInputStream in = context.openFileInput("unlockedWords.csv");
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line;

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] unlockedWordsArray = line.split(",");
                    for (String word: unlockedWordsArray) {
                        unlockedWords.add(word);
                    }

                    if(unlockedWords.size() == 0) {
                        unlockedWords.add("apple");
                    }
                }

                inputStreamReader.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        } else {
            try {
                String content = "apple";
                String filePath = context.getFilesDir().getPath().toString() + "/unlockedWords.csv";
                unlockedWordsFile = new File( filePath);
                if (!unlockedWordsFile.exists()) {
                    unlockedWordsFile.createNewFile();
                }

                FileWriter fw = new FileWriter(unlockedWordsFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


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

        try {

            StringBuilder csvBuilder = new StringBuilder();
            for(String unlockedWord : unlockedWords){
                csvBuilder.append(unlockedWord);
                csvBuilder.append(",");
            }
            String content = csvBuilder.toString();
            content = content.substring(0, content.length() - 1);

            //if (!unlockedWordsFile.exists()) {
            //    unlockedWordsFile.createNewFile();
            //}

            FileWriter fw = new FileWriter(unlockedWordsFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        updateCardList();
    }

    public void setCategory(String activityCategory){
        category = activityCategory;

        updateCardList();
    }

    private void updateCardList() {
        cardList.clear();
        if(category == null) {
            return;
        }

        Words words = new Words();
        String identifierName = category + "Words";
        String [] categoryWords = resources.getStringArray(
                resources.getIdentifier(identifierName,"array",packageName));
        for (String word:categoryWords) {
            words.addWord(word);
            String pictureName = category + "_" + word;
            words.addWordImage(resources.getIdentifier(pictureName.toLowerCase(),"drawable",packageName));
            words.addWordAudio(resources.getIdentifier(pictureName.toLowerCase(), "raw", packageName));
        }
        List<String> wordNames = words.getWords();
        List<Integer> wordImages = words.getWordImages();
        List<Integer> wordAudios = words.getWordAudio();

        for (int i = 0; i < wordNames.size(); i++) {
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
                            new WordCardItem(wordImages.get(i), wordName, wordAudios.get(i)),
                            colors.get(backgroundKey),
                            colors.get(contrastKey), unlockedWords.contains(wordName.toLowerCase())
                    )
            );
        }

        _cardList.onNext(cardList);
    }
}
