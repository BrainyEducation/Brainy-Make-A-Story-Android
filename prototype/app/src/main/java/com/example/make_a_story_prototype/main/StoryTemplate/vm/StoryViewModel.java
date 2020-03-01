package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import com.example.make_a_story_prototype.main.StoryTemplate.model.Story;

import java.util.HashMap;
import java.util.Map;

public class StoryViewModel {
    public static class BlankSelection {
        private String text;
        private int imageResource;

        public BlankSelection(String text, int imageResource) {
            this.text = text;
            this.imageResource = imageResource;
        }

        public String getText() {
            return text;
        }

        public int getImageResource() {
            return imageResource;
        }
    }

    private Story story;
    private Map<String, BlankSelection> selections;

    public Story getStory() {
        return story;
    }

    public StoryViewModel(Story story) {
        this.story = story;
        this.selections = new HashMap<>();
    }

    public Map<String, BlankSelection> getSelections() {
        return selections;
    }

    public void setSelection(String blankIdentifier, BlankSelection selection) {
        selections.put(blankIdentifier, selection);
        // fire observable
    }
}