package com.example.make_a_story_prototype.main.Wordbank.model;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    private List<Integer> wordImages = new ArrayList<>();

    private List<Integer> wordsAudio = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public List<Integer> getWordImages() {
        return wordImages;
    }

    public List<Integer> getWordAudio() {
        return wordsAudio;
    }

    public void addWord(String word){
        words.add(word);
    }

    public void addWordImage(int wordImage){
        wordImages.add(wordImage);
    }

    public void addWordAudio(int wordAudio) {
        wordsAudio.add(wordAudio);
    }

}
