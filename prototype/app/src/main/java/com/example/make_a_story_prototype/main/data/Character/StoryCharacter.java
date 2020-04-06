package com.example.make_a_story_prototype.main.data.Character;

public class StoryCharacter {
    private CharacterName name;
    private int imageResource;

    public StoryCharacter(CharacterName name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public CharacterName getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
