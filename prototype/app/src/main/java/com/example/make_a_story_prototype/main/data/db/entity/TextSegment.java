package com.example.make_a_story_prototype.main.data.db.entity;

import com.example.make_a_story_prototype.main.data.db.entity.StoryPage;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_segments_table",
        foreignKeys = @ForeignKey(entity = StoryPage.class,
            parentColumns = "textId", childColumns = "pageId"))
public class TextSegment {

    @PrimaryKey(autoGenerate = true)
    private int textId;
    private int pageId;
    private String text;
    private int audioResource;

    public TextSegment(int textId, int pageId, String text, int audioResource) {
        this.textId = textId;
        this.pageId = pageId;
        this.text = text;
        this.audioResource = audioResource;
    }

    public int getTextId() {
        return textId;
    }

    public int getPageId() { return pageId; }

    public String getText() {
        return text;
    }

    public int getAudioResource() {
        return audioResource;
    }
}

