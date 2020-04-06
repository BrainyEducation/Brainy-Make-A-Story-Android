package com.example.make_a_story_prototype.main.data.Word.db;

import com.example.make_a_story_prototype.main.data.Word.Category;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "words_table",
        foreignKeys = @ForeignKey(entity = Category.class,
                parentColumns = "wordId", childColumns = "categoryId"))
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int wordId;
    private int categoryId;
    private String name;
    private int imageResource;
    private int audioResource;
    private boolean lockedStatus;

    public Word(int wordId, int categoryId, String name, int imageResource, int audioResource, boolean lockedStatus) {
        this.wordId = wordId;
        this.categoryId = categoryId;
        this.name = name;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
        this.lockedStatus = lockedStatus;
    }

    public int getWordId() {
        return wordId;
    }

    public int getCategoryId() { return categoryId; }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getAudioResource() {
        return audioResource;
    }

    public boolean getLockedStatus() {
        return lockedStatus;
    }

}
