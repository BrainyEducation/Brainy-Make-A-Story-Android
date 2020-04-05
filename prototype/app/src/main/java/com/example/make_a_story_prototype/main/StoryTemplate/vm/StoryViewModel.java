package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.make_a_story_prototype.main.data.Story.DebugStoryRepository;
import com.example.make_a_story_prototype.main.data.Story.StoryRepository;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.DebugStoryTemplateSelectionsRepository;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.StoryTemplateSelectionsRepository;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import java.util.Map;

public class StoryViewModel implements Parcelable {
    private StoryRepository storyRepository = DebugStoryRepository.getInstance();
    private StoryTemplateSelectionsRepository selectionsRepository = DebugStoryTemplateSelectionsRepository.getInstance();

    private Story story;
    private int storyId;
    private Map<String, BlankSelection> selections;
    private Map<String, ImageLocation> imageLocationsForPage;

    public StoryViewModel(int storyId) {
        Log.d("StoryViewModel", "create with " + storyId);
        this.storyId = storyId;

        this.story = storyRepository.getStory(storyId);
        this.selections = selectionsRepository.getSelectionsForStory(storyId);
    }

    public Map<String, BlankSelection> getSelections() {
        return selections;
    }


    // TODO
    public ImageLocation getImageLocationForSelection(int page, String storyBlankId) {
        imageLocationsForPage = story.getPages().get(page).getImageLocations();

        ImageLocation location = imageLocationsForPage.get(storyBlankId);

        if (location != null) {
            Log.d("TAG", "getImageLocationForSelection --> storyBlankId = " + storyBlankId + " && location w/ id != null? " + location.getLocationId());
            return location;
        }
        else {
            Log.d("TAG", "getImageLocationForSelection: null location --- for storyBlankId " + storyBlankId);
            return null;
        }
    }

    public Story getStory() {
        return story;
    }

    public void clearSelections() {
        selectionsRepository.clearSelectionsForStory(storyId);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(storyId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoryViewModel> CREATOR = new Creator<StoryViewModel>() {
        @Override
        public StoryViewModel createFromParcel(Parcel in) {
            return new StoryViewModel(in.readInt());
        }

        @Override
        public StoryViewModel[] newArray(int size) {
            return new StoryViewModel[size];
        }
    };

}