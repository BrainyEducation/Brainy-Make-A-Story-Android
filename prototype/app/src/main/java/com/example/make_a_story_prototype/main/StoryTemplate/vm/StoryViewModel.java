package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.make_a_story_prototype.main.StoryTemplate.model.Story;

import java.util.HashMap;
import java.util.Map;

import androidx.lifecycle.AndroidViewModel;

public class StoryViewModel extends AndroidViewModel {

    public static class BlankSelection implements Parcelable {
        private String text;
        private int imageResource;

        public BlankSelection(String text, int imageResource) {
            this.text = text;
            this.imageResource = imageResource;
        }

        public String getText() {
            return text;
        }

        public int getImageResource() {
            return imageResource;
        }

        protected BlankSelection(Parcel in) {
            text = in.readString();
            imageResource = in.readInt();
        }

        public static final Creator<BlankSelection> CREATOR = new Creator<BlankSelection>() {
            @Override
            public BlankSelection createFromParcel(Parcel in) {
                return new BlankSelection(in);
            }

            @Override
            public BlankSelection[] newArray(int size) {
                return new BlankSelection[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(text);
            dest.writeInt(imageResource);
        }
    }

    private Story story;
    private Map<String, BlankSelection> selections;

    public Story getStory() {
        return story;
    }

    public StoryViewModel(Application application, Story story) {
        super(application);
        this.story = story;
        this.selections = new HashMap<>();
    }

    public Map<String, BlankSelection> getSelections() {
        return selections;
    }

    public void setSelection(String blankIdentifier, BlankSelection selection) {
        selections.put(blankIdentifier, selection);
        // fire observable
    }

    public void clearSelections() {
        selections = new HashMap<String, BlankSelection>();
    }

}