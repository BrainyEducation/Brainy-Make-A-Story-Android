package com.example.make_a_story_prototype.main.Util;

public class Optional<T> {
    private T value;

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}