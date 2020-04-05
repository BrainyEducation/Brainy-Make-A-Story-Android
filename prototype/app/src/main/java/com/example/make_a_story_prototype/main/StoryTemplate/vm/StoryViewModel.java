package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import com.example.make_a_story_prototype.main.data.Story.DebugStoryRepository;
import com.example.make_a_story_prototype.main.data.Story.StoryRepository;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.DebugStoryTemplateSelectionsRepository;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.StoryTemplateSelectionsRepository;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;

public class StoryViewModel implements Parcelable {
    private static String BLANK_PLACEHOLDER = " BLANK ";

    public interface StoryViewModelCallback {
        void onSelectedBlank(String identifier);
    }

    private StoryRepository storyRepository = DebugStoryRepository.getInstance();
    private StoryTemplateSelectionsRepository selectionsRepository = DebugStoryTemplateSelectionsRepository.getInstance();

    public StoryViewModelCallback callback;

    private Story story;
    private int storyId;
    private Map<String, BlankSelection> selections;
    private int pageNumber;

    public StoryViewModel(int storyId, int pageNumber) {
        Log.d("StoryViewModel", "create with " + storyId);
        this.storyId = storyId;
        this.pageNumber = pageNumber;

        this.story = storyRepository.getStory(storyId);
        this.selections = selectionsRepository.getSelectionsForStory(storyId);
    }

    public Map<String, BlankSelection> getSelections() {
        return selections;
    }

    public Story getStory() {
        return story;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Spannable getTextForPage(int pageNumber) {
        StoryPage currentPage = story.getPages().get(pageNumber);
        List<StorySegment> segments = currentPage.getSegments();

        SpannableStringBuilder builder = new SpannableStringBuilder();

        for (StorySegment s : segments) {
            if (s instanceof StoryText) {
                StoryText textSegment = (StoryText) s;
                builder.append(textSegment.getText());
            } else if (s instanceof StoryBlankIdentifier) {
                StoryBlankIdentifier identifier = (StoryBlankIdentifier) s;
                BlankSelection selection = selections.get(identifier.get());

                if (selection == null) {
                    builder.append(
                            BLANK_PLACEHOLDER,
                            new ClickableSpan() {
                                @Override
                                public void onClick(@NonNull View v) {
                                    onSelectedBlank(identifier.get());
                                }
                            },
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                } else {
                    builder.append(selection.getText());
                }
            }
        }

        return builder;
    }

    public void clearSelections() {
        selectionsRepository.clearSelectionsForStory(storyId);
    }

    private void onSelectedBlank(String identifier) {
        if (callback == null) {
            return;
        }

        callback.onSelectedBlank(identifier);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(storyId);
        dest.writeInt(pageNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoryViewModel> CREATOR = new Creator<StoryViewModel>() {
        @Override
        public StoryViewModel createFromParcel(Parcel in) {
            int storyId = in.readInt();
            int pageNumber = in.readInt();

            return new StoryViewModel(storyId, pageNumber);
        }

        @Override
        public StoryViewModel[] newArray(int size) {
            return new StoryViewModel[size];
        }
    };

}