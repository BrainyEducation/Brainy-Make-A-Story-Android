package com.example.make_a_story_prototype.main.Wordbank.vm

import android.os.Parcel
import android.os.Parcelable
import com.example.make_a_story_prototype.main.data.MasteredWords.DebugMasteredWordsRepository
import com.example.make_a_story_prototype.main.data.MasteredWords.MasteredWordsRepository
import com.example.make_a_story_prototype.main.data.Word.Category
import com.example.make_a_story_prototype.main.data.Word.DebugWordRepository
import com.example.make_a_story_prototype.main.data.Word.WordRepository
import io.reactivex.Single

class WordbankViewModel(private val categoryId: Int) : Parcelable {
    private val wordRepository: WordRepository = DebugWordRepository.getInstance()
    private val masteredWordsRepository: MasteredWordsRepository = DebugMasteredWordsRepository.getInstance()

    fun getCategory(): Single<Category> {
        return wordRepository.getCategory(categoryId)
    }

    fun getCardList(): Single<List<WordCardItemViewModel>> {
        return getCategory()
                .flatMap { category -> wordRepository.getWordsForCategory(category) }
                .map { words ->
                    words.map {
                        masteredWordsRepository.isMastered(it.id)
                                .map { isUnlocked ->
                                    WordCardItemViewModel(it, isUnlocked)
                                }
                    }
                }
                .flatMap { wordVms ->
                    Single.concat(wordVms)
                            .toList()
                }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(categoryId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WordbankViewModel> {
        override fun createFromParcel(parcel: Parcel): WordbankViewModel {
            return WordbankViewModel(parcel.readInt())
        }

        override fun newArray(size: Int): Array<WordbankViewModel?> {
            return arrayOfNulls(size)
        }
    }

}