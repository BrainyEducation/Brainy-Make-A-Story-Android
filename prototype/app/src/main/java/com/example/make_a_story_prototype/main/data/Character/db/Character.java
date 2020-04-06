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
    private Integer nameId;
    private Integer imageId;

    public Character(int characterId, Integer nameId, Integer imageId){
        this.characterId = characterId;
        this.nameId = nameId;
        this.imageId = imageId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getImageId() {
        return imageId;
    }
}
