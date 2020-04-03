package com.example.make_a_story_prototype.main.StorySelection.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoryCardHolder;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.StorySelection.vm.StoryCardViewModel;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.data.Story.model.Story;
import com.example.make_a_story_prototype.main.data.Word.Category;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class StoryHolder extends RecyclerView.ViewHolder {
    public interface StoryCardCallback {
        void cardTappedOn(StoryCardViewModel vm);
    }

    private Context context;
    private ImageView storyImage;
    private TextView storyName;
    private RelativeLayout parentLayout;
    private StoryCardViewModel vm;

    public StoryHolder.StoryCardCallback callback;

    public StoryHolder(@NonNull View itemView) {
        super(itemView);

        this.context = itemView.getContext();
        this.storyImage = itemView.findViewById(R.id.cardImage);
        this.storyName = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parent_layout);

        parentLayout.setOnClickListener(v -> {
            if (callback != null && vm != null) {
                callback.cardTappedOn(vm);
            } else if (vm == null) {
                Log.d("TAG", "StoryHolder --> vm is null");
            } else {
                Log.d("TAG", "StoryHolder --> callback is null");
            }
        });
    }

    public void setViewModel(StoryCardViewModel vm, int backgroundColor, int strokeColor, int textColor) {
        this.vm = vm;

        Story story = vm.getStory();

        storyImage.setImageResource(story.getImageResource());
        storyName.setText(story.getTitle());
        storyName.setTextColor(textColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, backgroundColor);

        CardView storyCardView = itemView.findViewById(R.id.card_view);

        Drawable cardBorder = storyCardView.getBackground();
        Util.changeDrawableColor(cardBorder, strokeColor);
        storyCardView.setRadius(23);

        CardView imageCardView = itemView.findViewById(R.id.image_holder);
        Drawable imageBorder = imageCardView.getBackground();
        Util.changeDrawableColor(imageBorder, strokeColor);
        imageCardView.setRadius(23);
    }
}