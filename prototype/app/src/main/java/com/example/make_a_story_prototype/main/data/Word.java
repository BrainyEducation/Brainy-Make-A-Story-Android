package com.example.make_a_story_prototype.main.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String word;
    private String category;
    private boolean locked;

    public Word(String word, String category) {
        this.word = word;
        this.category = category;
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

    public String getCategory() { return category; }

    public boolean isLocked() {
        return locked;
    }
}
