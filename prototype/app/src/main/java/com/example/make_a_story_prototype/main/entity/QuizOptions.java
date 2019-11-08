package com.example.make_a_story_prototype.main.entity;

public class QuizOptions {
    private static String correctOption = "apple";
    private String incorrectOptions[] = {
            "able",
            "ape",
            "addle",
            "ate",
            "apply",
            "add"
    };

    public String[] getIncorrectOptions() {
        return incorrectOptions;
    }

    public static String getCorrectOption() {
        return correctOption;
    }
}
