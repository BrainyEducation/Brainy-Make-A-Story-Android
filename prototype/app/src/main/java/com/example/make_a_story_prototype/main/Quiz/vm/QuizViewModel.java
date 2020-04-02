package com.example.make_a_story_prototype.main.Quiz.vm;

import com.example.make_a_story_prototype.main.Quiz.model.QuizOptions;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;
import com.example.make_a_story_prototype.main.data.MasteredWords.DebugMasteredWordsRepository;
import com.example.make_a_story_prototype.main.data.MasteredWords.MasteredWordsRepository;
import com.example.make_a_story_prototype.main.data.Word.DebugWordRepository;
import com.example.make_a_story_prototype.main.data.Word.Word;
import com.example.make_a_story_prototype.main.data.Word.WordRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import static java.lang.Math.max;

public class QuizViewModel {

    public interface Callback {
        void onComplete();
    }

    private WordRepository wordRepository = DebugWordRepository.getInstance();
    private MasteredWordsRepository masteredWordsRepository = DebugMasteredWordsRepository.getInstance();

    public Callback callback;

    private BehaviorSubject<Word[]> options = BehaviorSubject.create();
    private BehaviorSubject<Integer> correctAnswersCount = BehaviorSubject.createDefault(0);
    private BehaviorSubject<Integer> maxCorrectAnswersCount = BehaviorSubject.createDefault(0);

    private int correctOptionIndex;

    private Word wordBeingQuizzed;

    public QuizViewModel(Word quizword, List<Word> wordList) {
        wordBeingQuizzed = quizword;
        QuizOptions.setCorrectOption(quizword);
        QuizOptions.setWordList((Word[]) wordList.toArray());
        shuffle();
    }

    private void shuffle() {
        Word[] nextOptions = new Word[4];
        Word[] availableIncorrectOptions = QuizOptions.getIncorrectOptions();

        Random random = new Random();

        // get random index of answer option
        int incorrectStartIndex = random.nextInt(availableIncorrectOptions.length);
        for (int i = 0; i < 4; i++) {
            Word incorrectOption = availableIncorrectOptions[
                    (incorrectStartIndex + i) % availableIncorrectOptions.length
                    ];

            nextOptions[i] = incorrectOption;
            if (i == 3) {
                correctOptionIndex = random.nextInt(4);
                nextOptions[correctOptionIndex] = QuizOptions.getCorrectOption();
            }
        }

        options.onNext(nextOptions);
    }

    // Observables

    public Observable<Word[]> getOptions() {
        return options;
    }

    public Observable<Integer> getCorrectAnswerCount() {
        return correctAnswersCount;
    }

    public Observable<Integer> getMaxAnswerCount() {
        return maxCorrectAnswersCount;
    }

    // Actions

    public void onSelectedAnswer(int option) {
        if (option == correctOptionIndex) {
            onCorrectAnswer();
        } else {
            onIncorrectAnswer();
        }

        shuffle();
    }

    // Utils

    private void onCorrectAnswer() {
        correctAnswersCount.onNext(correctAnswersCount.getValue() + 1);

        maxCorrectAnswersCount.onNext(max(
                maxCorrectAnswersCount.getValue(),
                correctAnswersCount.getValue()
        ));

        if (correctAnswersCount.getValue() == 3) {
            masteredWordsRepository.setMastered(QuizOptions.getCorrectOption().getId());
            callback.onComplete();
        }
    }

    private void onIncorrectAnswer() {
        correctAnswersCount.onNext(0);
    }

}
