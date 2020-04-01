package com.example.make_a_story_prototype.main.data.Story;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_locations_table")
public class ImageLocation {

    @PrimaryKey
    private int locationId;
    private float x;
    private float y;
    private float width;
    private float height;
    private float rotation;

    public ImageLocation(int locationId, float x, float y, float width, float height, float rotation) {
        this.locationId = locationId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }

    public int getLocationId() {
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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
