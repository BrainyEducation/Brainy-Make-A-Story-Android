package com.example.make_a_story_prototype.main.data.MasteredWords;

import io.reactivex.Single;

public interface MasteredWordsRepository {

    Single<Boolean> isMastered(int wordId);

    void setMastered(int wordId);

}
