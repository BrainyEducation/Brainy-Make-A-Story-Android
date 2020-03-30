package com.example.make_a_story_prototype.main.Quiz.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizOptions {
    private static String correctOption = "apple";
    private static String incorrectOptions[] = {
            "able",
            "ape",
            "addle",
            "ate",
            "apply",
            "add"
    };



    public static String[] getIncorrectOptions() {
        return incorrectOptions;
    }

    public static String getCorrectOption() {
        return correctOption;
    }

    public static void setCorrectOption(String newCorrectOption) {
        correctOption = newCorrectOption;
        Log.d("tag", "setCorrectOption: " + correctOption);
    }

    public static void setWordList(String[] wordList) {
        List<String> possibleIncorrects = new ArrayList<String>();

        for (String word: wordList) {
            if(!word.equals(correctOption) && word.charAt(0) == correctOption.charAt(0)) {
                possibleIncorrects.add(word);
            }
        }
        Log.d("tag", "porssibleIncorrects size: " + possibleIncorrects.size());
        Log.d("tag", "wordList size: " + wordList.length);

        while(possibleIncorrects.size() < 5) {
            String word = wordList[new Random().nextInt(wordList.length)];
            if(!word.equals(correctOption) && !possibleIncorrects.contains(word)){
                possibleIncorrects.add(word);
            }
        }

        incorrectOptions =  possibleIncorrects.toArray(new String[possibleIncorrects.size()]);
    }
}

