package com.example.make_a_story_prototype.main.data.Character;

public class CharacterName {
    private String name;
    private int audioResource;

    public CharacterName(String name, int audioResource) {
        this.name = name;
        this.audioResource = audioResource;
    }

    public String getName() {
        return name;
    }

    public int getAudioResource() {
        return audioResource;
    }
}
