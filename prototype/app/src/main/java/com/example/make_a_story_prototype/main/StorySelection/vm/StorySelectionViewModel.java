package com.example.make_a_story_prototype.main.StorySelection.vm;

import android.content.Context;

import com.example.make_a_story_prototype.main.data.Story.DebugStoryRepository;
import com.example.make_a_story_prototype.main.data.Story.StoryRepository;
import com.example.make_a_story_prototype.main.data.Story.model.Story;

import java.util.ArrayList;
import java.util.List;

public class StorySelectionViewModel {
    private StoryRepository storyRepository = DebugStoryRepository.getInstance();
    private List<StoryCardViewModel> cardList = new ArrayList<>();


    public StorySelectionViewModel(Context context) {
        List<Story> stories = storyRepository.getStories();

        for (int i = 0; i < stories.size(); i++) {
            Story story = stories.get(i);

            cardList.add(new StoryCardViewModel(story));
        }
    }

    public List<StoryCardViewModel> getCardList() {
        return cardList;
    }
}
