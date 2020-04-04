package com.example.make_a_story_prototype.main.StorySelection.vm;

import com.example.make_a_story_prototype.main.data.Story.model.Story;

public class StoryCardViewModel {
    private Story story;

    public StoryCardViewModel(Story story) {
        this.story = story;
    }

    public Story getStory() {
        return story;
    }
}
