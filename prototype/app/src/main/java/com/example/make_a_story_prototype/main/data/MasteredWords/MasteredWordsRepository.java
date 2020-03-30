package com.example.make_a_story_prototype.main.data.MasteredWords;

import com.example.make_a_story_prototype.main.data.Word.Word;

public interface MasteredWordsRepository {

    boolean isMastered(Word word);

    void setMastered(Word word);

}
