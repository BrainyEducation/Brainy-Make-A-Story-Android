package com.example.make_a_story_prototype.main.data.Story.db;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_segments_table",
        foreignKeys = @ForeignKey(entity = StoryPage.class,
        parentColumns = "textId", childColumns = "pageId"))
public class TextSegment {

    @PrimaryKey(autoGenerate = false)
    private int textId;
    private String text;
    private int audioResource;

    public TextSegment(int textId, String text, int audioResource) {
        this.textId = textId;
        this.text = text;
        this.audioResource = audioResource;
    }

    public int getTextId() {
        return textId;
    }

    public String getText() {
        return text;
    }

    public int getAudioResource() {
        return audioResource;
    }
}

