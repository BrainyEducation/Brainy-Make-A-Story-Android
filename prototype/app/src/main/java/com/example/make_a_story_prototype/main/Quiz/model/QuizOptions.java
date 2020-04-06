package com.example.make_a_story_prototype.main.Quiz.model;

import android.util.Log;

import com.example.make_a_story_prototype.main.data.Word.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizOptions {
    private static Word correctOption;
    private static Word incorrectOptions[];



    public static Word[] getIncorrectOptions() {
        return incorrectOptions;
    }

    public static Word getCorrectOption() {
        return correctOption;
    }

    public static void setCorrectOption(Word newCorrectOption) {
        correctOption = newCorrectOption;
        Log.d("tag", "setCorrectOption: " + correctOption);
    }

    public static void setWordList(Word[] wordList) {
        List<Word> possibleIncorrects = new ArrayList<Word>();

        for (Word word: wordList) {
            if(word.getId() != correctOption.getId() && word.getWord().charAt(0) == correctOption.getWord().charAt(0)) {
                possibleIncorrects.add(word);
            }
        }
        Log.d("tag", "porssibleIncorrects size: " + possibleIncorrects.size());
        Log.d("tag", "wordList size: " + wordList.length);

        while(possibleIncorrects.size() < 5) {
            Word word = wordList[new Random().nextInt(wordList.length)];
            if(word.getId() != correctOption.getId() && !possibleIncorrects.contains(word)){
                possibleIncorrects.add(word);
            }
        }

        incorrectOptions =  possibleIncorrects.toArray(new Word[possibleIncorrects.size()]);
    }
}

