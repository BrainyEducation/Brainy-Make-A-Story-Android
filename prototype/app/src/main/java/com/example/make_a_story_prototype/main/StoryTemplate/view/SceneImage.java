package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.data.Story.model.ImageLocation;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class SceneImage extends CoordinatorLayout {

    private ImageView background;

    private StoryViewModel vm;
    private int pageNumber;

    private static int sceneWidth;
    private static int sceneHeight;


    public SceneImage(@NonNull Context context) {
        this(context, null);
    }

    public SceneImage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SceneImage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        background = new ImageView(context);
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        background.setLayoutParams(lp);
        addView(background);

        if (isInEditMode()) {
            background.setImageResource(R.drawable.story_space_alien_1);
        }
    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        // the height will be set at this point
        // 1.469
        sceneWidth = getMeasuredWidth();
        sceneHeight = getMeasuredHeight();
        Log.d("TAG", "onWindowFocusChanged: [" + sceneWidth + ", " + sceneHeight + "]");

    }


    public void setViewModel(StoryViewModel vm, int pageNumber) {
        this.vm = vm;
        this.pageNumber = pageNumber;

        updateImages();
    }


    private void updateImages() {
        if (vm == null) {
            return;
        }

        removeAllViews();
        addView(background);

        StoryPage page = vm.getStory().getPages().get(pageNumber);
        background.setImageResource(page.getImageResource());

        Map<String, ImageLocation> locations = page.getImageLocations();
        Map<String, BlankSelection> selections = vm.getSelections();
        for (Map.Entry<String, ImageLocation> entry : locations.entrySet()) {
            ImageLocation location = entry.getValue();
            BlankSelection selection = selections.get(location.getLocationId());

            if (selection != null) {
                addBlankSelection(selection, location);
            }
        }
    }

    private void addBlankSelection(BlankSelection selection, ImageLocation location) {
        ImageView img = new ImageView(getContext());

        img.setImageResource(selection.getImageResource());
        float x = sceneWidth * (location.getX() * .01f);
        float y = sceneHeight * (location.getY() * .01f);

        Log.d("tag", "measuredWidth: " + getMeasuredWidth());

        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        img.setX(x);
        img.setY(y);

        addView(img, lp);

        img.getLayoutParams().height = location.getHeight();
        img.getLayoutParams().width = location.getWidth();
    }

}
