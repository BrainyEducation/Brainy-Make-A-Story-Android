package com.example.make_a_story_prototype.main.data.Character.db;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "character_table",
        foreignKeys = {
                @ForeignKey(entity = CharacterName.class,
                    parentColumns = "characterId", childColumns = "nameId"),
                @ForeignKey(entity = CharacterImage.class,
                        parentColumns = "characterId", childColumns = "imageId")
                })
public class Character {

    private int characterId;

    public Character(int characterId){
        this.characterId = characterId;
    }

    public int getCharacterId() {
        return characterId;
    }
}
