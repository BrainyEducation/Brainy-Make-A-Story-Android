package com.example.make_a_story_prototype.main.data.Story;

import java.util.List;

public interface StoryRepository {

    List<TextSegment> getTextSegmentsForStoryPage(int storyId, int pageNumber);
    Story[] getStories();
    List<StoryPage> getStoryPages(int storyId);
    StoryPage getStoryPage(int storyId, int pageNumber);
    Story getStory(int storyId);

}
