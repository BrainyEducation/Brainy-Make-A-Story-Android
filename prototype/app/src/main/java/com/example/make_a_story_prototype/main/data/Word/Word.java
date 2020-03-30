package com.example.make_a_story_prototype.main.data.Word;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String word;
    private Category category;
    private int imageResource;
    private int audioResource;
    private boolean locked;

    public Word(int id, String word, Category category, int imageResource, int audioResource) {
        this.id = id;
        this.word = word;
        this.category = category;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
        this.locked = true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public Category getCategory() { return category; }

    public boolean isLocked() {
        return locked;
    }
}
