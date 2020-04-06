package com.example.make_a_story_prototype.main.data.Story.db;

import com.example.make_a_story_prototype.main.data.Character.db.Character;
import com.example.make_a_story_prototype.main.data.Word.db.Word;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "blanks_table",
        foreignKeys = { @ForeignKey(entity = StoryPage.class,
                            parentColumns = "blankId", childColumns = "pageId"),
                        @ForeignKey(entity = Word.class,
                            parentColumns = "blankId", childColumns = "wordId"),
                        @ForeignKey(entity = Character.class,
                                parentColumns = "blankId", childColumns = "characterId")})
public class Blank {

    @PrimaryKey
    @NonNull
    private String blankId;
    private float x;
    private float y;
    private int width;
    private int height;
    private int rotation;
    // boolean for word or character blank
    private boolean word;

    public Blank(String blankId, float x, float y, int width, int height, int rotation, boolean word) {
        this.blankId = blankId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.word = word;
    }

    @NonNull
    public String getBlankId() {
        return blankId;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isWord() {
        return word;
    }
}