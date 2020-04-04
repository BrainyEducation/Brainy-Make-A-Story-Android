package com.example.make_a_story_prototype.main.data.StoryTemplateSelections;

import com.example.make_a_story_prototype.main.data.Story.model.StoryBlank;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.ImageLocation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugStoryTemplateSelectionsRepository implements StoryTemplateSelectionsRepository {

    private static DebugStoryTemplateSelectionsRepository instance = new DebugStoryTemplateSelectionsRepository();

    public static DebugStoryTemplateSelectionsRepository getInstance() {
        return instance;
    }

    private Map<Integer, Map<String, BlankSelection>> selections;

    private Map<Integer, Map<StoryBlank, BlankSelection>> blanks;

    private DebugStoryTemplateSelectionsRepository() {
        selections = new HashMap<>();
    }

    @Override
    public Map<String, BlankSelection> getSelectionsForStory(int storyId) {
        Map<String, BlankSelection> storySelections = selections.get(storyId);
        if (storySelections == null) {
            storySelections = new HashMap<>();
            setSelectionsForStory(storyId, storySelections);
        }

        return storySelections;
    }

    @Override
    public void setSelectionsForStory(int storyId, Map<String, BlankSelection> selections) {
        this.selections.put(storyId, selections);
    }

    @Override
    public void setSelectionForStory(int storyId, String identifier, BlankSelection selection) {
        Map<String, BlankSelection> storySelections = getSelectionsForStory(storyId);
        storySelections.put(identifier, selection);
    }

    @Override
    public void clearSelectionsForStory(int storyId) {
        selections.remove(storyId);
    }
}

//    @Override
//    public List<ImageLocation> getImageLocations() {
//        return Arrays.asList(imageLocations);
//    }
//
//    @Override
//    public ImageLocation getImageLocation(int id) {
//        for (ImageLocation location : imageLocations) {
//            if (location.getLocationId() == id) {
//                return location;
//            }
//        }
//        return null;
//    }

