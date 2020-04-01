package com.example.make_a_story_prototype.main.StorySelection.vm;

import com.example.make_a_story_prototype.main.data.Story.DebugStoryRepository;
import com.example.make_a_story_prototype.main.data.Story.StoryRepository;
import com.example.make_a_story_prototype.main.data.Story.model.Story;

import java.util.List;

public class StorySelectionViewModel {
    private List<Story> stories;
    private StoryRepository storyRepository = DebugStoryRepository.getInstance();

    public StorySelectionViewModel() {
        stories = storyRepository.getStories();
    }

    public List<Story> getStories() {
        return stories;
    }

    public Story getStory(int storyId) {
        return storyRepository.getStory(storyId);
    }
}
