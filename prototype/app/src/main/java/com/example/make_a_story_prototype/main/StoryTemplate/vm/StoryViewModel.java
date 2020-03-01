package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import com.example.make_a_story_prototype.main.StoryTemplate.model.Story;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryBlankIdentifier;

import java.util.HashMap;
import java.util.Map;

public class StoryViewModel {
    class BlankSelection {
        String text;
        int image;
    }

    private Story story;
    private Map<StoryBlankIdentifier, BlankSelection> selections;

    public Story getStory() {
        return story;
    }

    public StoryViewModel(Story story) {
        this.story = story;
        this.selections = new HashMap<>();
    }

    public void setSelection(StoryBlankIdentifier blankIdentifier, BlankSelection selection) {
        selections.put(blankIdentifier, selection);
        // fire observable
    }
}