package com.example.make_a_story_prototype.main.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_name_table")
public class CharacterName {

    @PrimaryKey(autoGenerate = true)
    private int nameId;
    private String name;
    private int audioResource;

    public CharacterName(int nameId, String name, int audioResource) {
        this.nameId = nameId;
        this.name = name;
        this.audioResource = audioResource;
    }

    public int getNameId() { return nameId; }

    public String getName() {
        return name;
    }

    public int getAudioResource() {
        return audioResource;
    }
}
