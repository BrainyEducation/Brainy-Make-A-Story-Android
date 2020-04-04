package com.example.make_a_story_prototype.main.data.Character;

import com.example.make_a_story_prototype.R;

import java.util.Arrays;
import java.util.List;

public class DebugCharacterRepository implements CharacterRepository {

    private static DebugCharacterRepository instance = new DebugCharacterRepository();

    public static DebugCharacterRepository getInstance() {
        return instance;
    }

    private CharacterName[] names = {
            new CharacterName("Han", R.raw.character_han),
            new CharacterName("Dev", R.raw.character_dev),
            new CharacterName("Don", R.raw.character_don),
            new CharacterName("Ted", R.raw.character_ted),
            new CharacterName("Pau", R.raw.character_pau),
            new CharacterName("Paz", R.raw.character_paz),
            new CharacterName("Jim", R.raw.character_jim),
            new CharacterName("Eli", R.raw.character_eli),
            new CharacterName("Pat", R.raw.character_pat),
            new CharacterName("Lin", R.raw.character_lin),
            new CharacterName("Kim", R.raw.character_kim),
            new CharacterName("Wen", R.raw.character_wen),
            new CharacterName("Zoe", R.raw.character_zoe),
            new CharacterName("Eva", R.raw.character_eva),
            new CharacterName("Mia", R.raw.character_mia),
            new CharacterName("Ann", R.raw.character_ann),
            new CharacterName("Uma", R.raw.character_uma),
            new CharacterName("Rio", R.raw.character_rio),
            new CharacterName("Joy", R.raw.character_joy),
            new CharacterName("Khalid", R.raw.character_khalid),
            new CharacterName("Sunil", R.raw.character_sunil),
            new CharacterName("John", R.raw.character_john),
            new CharacterName("Bob ", R.raw.character_bob),
            new CharacterName("Will", R.raw.character_will),
            new CharacterName("Mary", R.raw.character_mary),
            new CharacterName("Lily", R.raw.character_lily),
            new CharacterName("Rose", R.raw.character_rose),
            new CharacterName("Iris", R.raw.character_iris),
    };

    private Integer[] characterImages = {
            R.drawable.character_boy_1,
            R.drawable.character_boy_2,
            R.drawable.character_girl_1,
            R.drawable.character_boy_3,
            R.drawable.character_girl_2,
            R.drawable.character_boy_4,
            R.drawable.character_boy_5,
            R.drawable.character_girl_3,
            R.drawable.character_girl_4,
            R.drawable.character_boy_6,
            R.drawable.character_girl_5,
            R.drawable.character_boy_7,
            R.drawable.character_girl_6,
            R.drawable.character_boy_8,
            R.drawable.character_boy_9,
            R.drawable.character_girl_7,
            R.drawable.character_boy_10,
            R.drawable.character_boy_11,
            R.drawable.character_girl_8,
    };

    @Override
    public List<CharacterName> getCharacterNames() {
        return Arrays.asList(names);
    }

    @Override
    public List<Integer> getCharacterImages() {
        return Arrays.asList(characterImages);
    }

    @Override
    public StoryCharacter getCharacter(int characterId) {
        return null;
    }
}
