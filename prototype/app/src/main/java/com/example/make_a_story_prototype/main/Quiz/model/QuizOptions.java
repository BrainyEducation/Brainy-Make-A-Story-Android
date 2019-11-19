package com.example.make_a_story_prototype.main.Quiz.model;

public class QuizOptions {
    private static String correctOption = "apple";
    private static String incorrectOptions[] = {
            "able",
            "ape",
            "addle",
            "ate",
            "apply",
            "add"
    };

    public static String[] getIncorrectOptions() {
        return incorrectOptions;
    }

    public static String getCorrectOption() {
        return correctOption;
    }
}
