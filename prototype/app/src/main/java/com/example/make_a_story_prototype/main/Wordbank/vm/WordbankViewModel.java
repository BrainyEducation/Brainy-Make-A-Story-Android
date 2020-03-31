package com.example.make_a_story_prototype.main.Wordbank.vm;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.make_a_story_prototype.main.data.MasteredWords.DebugMasteredWordsRepository;
import com.example.make_a_story_prototype.main.data.MasteredWords.MasteredWordsRepository;
import com.example.make_a_story_prototype.main.data.Word.Category;
import com.example.make_a_story_prototype.main.data.Word.DebugWordRepository;
import com.example.make_a_story_prototype.main.data.Word.Word;
import com.example.make_a_story_prototype.main.data.Word.WordRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class WordbankViewModel implements Parcelable {

    private int categoryId;
    private Category category;
    private List<WordCardItemViewModel> cardList = new ArrayList<>();

    public BehaviorSubject<List<WordCardItemViewModel>> _cardList = BehaviorSubject.createDefault(cardList);
    public List<WordCardItemViewModel> getCardList() {
        return cardList;
    }
    public Observable<List<WordCardItemViewModel>> getCardListObservable() {
        return _cardList;
    }

    private WordRepository wordRepo = DebugWordRepository.getInstance();
    private MasteredWordsRepository masteredWordsRepository = DebugMasteredWordsRepository.getInstance();

    public WordbankViewModel(int categoryId) {
        this.categoryId = categoryId;
        this.category = wordRepo.getCategory(categoryId);

        updateCardList();
    }

    public Category getCategory() {
        return category;
    }

    public void unlockWord(int wordId) {
        masteredWordsRepository.setMastered(wordId);
        updateCardList();
    }

    private void updateCardList() {
        cardList.clear();
        if (category == null) {
            return;
        }

        List<Word> words = wordRepo.getWordsForCategory(category);

        for (Word word : words) {
            boolean isUnlocked = masteredWordsRepository.isMastered(word.getId());
            cardList.add(new WordCardItemViewModel(word, isUnlocked));
        }

        _cardList.onNext(cardList);
    }

    public static final Creator<WordbankViewModel> CREATOR = new Creator<WordbankViewModel>() {
        @Override
        public WordbankViewModel createFromParcel(Parcel in) {
            int categoryId = in.readInt();
            return new WordbankViewModel(categoryId);
        }

        @Override
        public WordbankViewModel[] newArray(int size) {
            return new WordbankViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(categoryId);
    }
}
