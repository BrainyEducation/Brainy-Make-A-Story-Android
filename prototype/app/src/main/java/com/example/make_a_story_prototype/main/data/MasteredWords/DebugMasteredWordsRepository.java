package com.example.make_a_story_prototype.main.data.MasteredWords;

import com.example.make_a_story_prototype.main.data.Word.Word;

import java.util.HashSet;
import java.util.Set;

public class DebugMasteredWordsRepository implements MasteredWordsRepository {

    private static DebugMasteredWordsRepository instance;

    public static DebugMasteredWordsRepository getInstance() {
        return instance;
    }

    private Set<Word> masteredWords = new HashSet<>();

    @Override
    public boolean isMastered(Word word) {
        return masteredWords.contains(word);
    }

    @Override
    public void setMastered(Word word) {
        masteredWords.add(word);
    }


}
