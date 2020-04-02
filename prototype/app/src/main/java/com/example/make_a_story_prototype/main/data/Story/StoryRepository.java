package com.example.make_a_story_prototype.main.data.Story;

import com.example.make_a_story_prototype.main.data.Story.model.Story;

import java.util.List;

public interface StoryRepository {

    List<Story> getStories();
    Story getStory(int storyId);

}
