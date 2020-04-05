package com.example.make_a_story_prototype.main.data.Story.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class ImageLocation {

    private String locationId;
    private float x;
    private float y;
    private int width;
    private int height;
    private int rotation;

    public ImageLocation(String locationId, float x, float y, int width, int height, int rotation) {
        this.locationId = locationId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }

    public String getLocationId() {
        return locationId;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
