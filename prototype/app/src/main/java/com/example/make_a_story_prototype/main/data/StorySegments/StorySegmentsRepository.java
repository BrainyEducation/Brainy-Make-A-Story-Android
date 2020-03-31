package com.example.make_a_story_prototype.main.data.StorySegments;

import java.util.List;

public interface StorySegmentsRepository {

    List<TextSegment> getTextSegmentsForStoryPage(int storyId, int pageNumber);
    Story[] getStories();
    Story getStory(int storyId);
}
