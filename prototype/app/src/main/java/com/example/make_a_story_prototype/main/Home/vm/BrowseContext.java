package com.example.make_a_story_prototype.main.Home.vm;

import com.example.make_a_story_prototype.main.Navigation.NavigationController;

public class BrowseContext implements NavigationController.NavigationContext {

    public QuizContext activeQuiz;
    public StoryBlankSelectionContext activeStory;
}
