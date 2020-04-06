package com.example.make_a_story_prototype.main.data.Story;

import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.Story.test_data.Data_SantasMixedUpHelperElf;
import com.example.make_a_story_prototype.main.data.Story.test_data.Data_TheSpaceAlien;
import com.example.make_a_story_prototype.main.data.Story.test_data.Data_TheSpecialInvention;
import com.example.make_a_story_prototype.main.data.Story.test_data.Data_TheWackyCostumeParty;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DebugStoryRepository implements StoryRepository {

    private static DebugStoryRepository instance = new DebugStoryRepository();

    public static DebugStoryRepository getInstance() {
        return instance;
    }

    private Story[] sampleStories = {
            Data_TheSpecialInvention.sampleStory(),
            Data_TheSpaceAlien.sampleStory(),
            Data_TheWackyCostumeParty.sampleStory(),
            Data_SantasMixedUpHelperElf.sampleStory(),
    };

    @Override
    public List<Story> getStories() {
        return Arrays.asList(sampleStories);
    }

    @Override
    public Story getStory(int storyId) {
        for (Story story : sampleStories) {
            if (story.getStoryId() == storyId) {
                return story;
            }
        }
        return null;
    }
}
