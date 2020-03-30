package com.example.make_a_story_prototype.main.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "blanks_table")
public class Blank {
    @PrimaryKey
    @NonNull
    private String identifier;
    private String contents;
    //private String imageLocationID;
    // boolean for word or character blank
    private boolean word;

    public Blank(String identifier, boolean word) {
        this.identifier = identifier;
        this.word = word;
        //this.imageLocationID = imageLocationID;
        this.contents = null;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getContents() {
        return contents;
    }

    public boolean isWord() {
        return word;
    }

    //public String getImageLocationID() { return imageLocationID; }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

    //public void setImageLocationID(String imageLocationID) { this.imageLocationID = imageLocationID; }
}