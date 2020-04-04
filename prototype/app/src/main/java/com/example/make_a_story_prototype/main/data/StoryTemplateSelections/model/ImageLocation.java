package com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class ImageLocation {

    private int locationId;
    private double x;
    private double y;
    private double width;
    private double height;
    private double rotation;

    public ImageLocation(int locationId, double x, double y, double width, double height, double rotation) {
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

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
