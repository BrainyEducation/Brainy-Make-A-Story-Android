package com.example.make_a_story_prototype.main.Util;

public class Optional<T> {
    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}