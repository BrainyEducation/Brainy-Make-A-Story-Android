package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import android.app.Application;

import com.example.make_a_story_prototype.main.StoryTemplate.model.Story;

import androidx.annotation.NonNull;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class StoryViewModelFactory extends AbstractSavedStateViewModelFactory implements ViewModelProvider.Factory {
    private final Story story;
    private final Application application;

    public StoryViewModelFactory(Application application, Story story) {
        this.application = application;
        this.story = story;
    }

//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(StoryViewModel.class)) {
//            return (T) new StoryViewModel(application, story);
//        }
//        throw new IllegalArgumentException("Unknown ViewModel");
//    }

    @NonNull
    @Override
    protected <T extends ViewModel> T create(@NonNull String key, @NonNull Class<T> modelClass, @NonNull SavedStateHandle handle) {
        return null;
    }
}
