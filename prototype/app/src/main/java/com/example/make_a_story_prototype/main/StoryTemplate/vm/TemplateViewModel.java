package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import com.example.make_a_story_prototype.main.StoryTemplate.model.Stories;

public class TemplateViewModel {
    private int storyImage;
    private String storyTitle;
    private Stories stories;

    public TemplateViewModel(String storyTitle) {
        Stories stories = new Stories();
        this.storyTitle = storyTitle;
        storyImage = stories.getStoryImage(storyTitle);
    }

    public int getStoryImage() {
        return storyImage;
    }
}
