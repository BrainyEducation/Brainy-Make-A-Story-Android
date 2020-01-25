package com.example.make_a_story_prototype.main.Wordbank.model;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    private List<Integer> wordImages = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public List<Integer> getWordImages() {
        return wordImages;
    }

    public void addWord(String word){
        words.add(word);
    }

    public void addWordImage(int wordImage){
        wordImages.add(wordImage);
    }
}
