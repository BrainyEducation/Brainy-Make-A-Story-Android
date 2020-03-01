package com.example.make_a_story_prototype.main.StoryTemplate.vm;

public class StoryTextViewModel {
    private Story story;

    public StoryTextViewModel() {
        story = StoryPageSampleData.sampleStory();
    }

    public Story getStory() { return story; }

}