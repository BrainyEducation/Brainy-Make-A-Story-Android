package com.example.make_a_story_prototype.main.data.MasteredWords;

import com.example.make_a_story_prototype.main.data.Word.Word;

import io.reactivex.Single;

public interface MasteredWordsRepository {

    Boolean isMastered(int wordId);

    void setMastered(int wordId);

}
