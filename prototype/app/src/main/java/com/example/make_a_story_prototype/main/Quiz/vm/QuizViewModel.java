package com.example.make_a_story_prototype.main.Quiz.vm;

import com.example.make_a_story_prototype.main.Quiz.model.QuizOptions;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;

import java.util.Random;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import static java.lang.Math.max;

public class QuizViewModel {

    public interface Callback {
        void onComplete();
    }

    public Callback callback;

    private BehaviorSubject<String[]> options = BehaviorSubject.create();
    private BehaviorSubject<Integer> correctAnswersCount = BehaviorSubject.createDefault(0);
    private BehaviorSubject<Integer> maxCorrectAnswersCount = BehaviorSubject.createDefault(0);

    private int correctOptionIndex;

    public QuizViewModel() {
        shuffle();
    }

    private void shuffle() {
        String[] nextOptions = new String[4];
        String[] availableIncorrectOptions = QuizOptions.getIncorrectOptions();

        Random random = new Random();

        // get random index of answer option
        int incorrectStartIndex = random.nextInt(availableIncorrectOptions.length);
        for (int i = 0; i < 4; i++) {
            String incorrectOption = availableIncorrectOptions[
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

    public Observable<String[]> getOptions() {
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
            WordbankViewModel.instance().unlockWord(QuizOptions.getCorrectOption().toLowerCase());

            callback.onComplete();
        }
    }

    private void onIncorrectAnswer() {
        correctAnswersCount.onNext(0);
    }


}
