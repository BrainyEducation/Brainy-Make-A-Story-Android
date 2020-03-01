package com.example.make_a_story_prototype.main.StoryTemplate.model;

import java.util.ArrayList;
import java.util.List;

public class StoryRepository {

    public List<Story> getStories() {
        List<Story> stories = new ArrayList<>();
        stories.add(StoryPageSampleData.sampleStory());

        return stories;
    }

}
