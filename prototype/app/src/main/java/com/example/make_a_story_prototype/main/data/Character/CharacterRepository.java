package com.example.make_a_story_prototype.main.data.Character;

import java.util.List;

public interface CharacterRepository {
    List<CharacterName> getCharacterNames();
    List<Integer> getCharacterImages();
    StoryCharacter getCharacter(int characterId);
}
