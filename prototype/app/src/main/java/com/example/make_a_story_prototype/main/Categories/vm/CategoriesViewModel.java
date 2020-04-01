package com.example.make_a_story_prototype.main.Categories.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.model.Categories;
import com.example.make_a_story_prototype.main.Categories.model.CategoryCardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.core.content.ContextCompat;

public class CategoriesViewModel {

    private final List<CategoryCardItemViewModel> cardList = new ArrayList<>();

    public CategoriesViewModel(Context context) {
        int[] BackgroundColors = {ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
                ContextCompat.getColor(context, R.color.colorLightGreen),
                ContextCompat.getColor(context, R.color.colorLightPurple),
                ContextCompat.getColor(context, R.color.colorLightBlue),};

        int[] DetailColors = {ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
                ContextCompat.getColor(context, R.color.colorContrastGreen),
                ContextCompat.getColor(context, R.color.colorContrastPurple),
                ContextCompat.getColor(context, R.color.colorContrastBlue),};

        Categories categories = new Categories();
        List<String> categoryNames = Arrays.asList(categories.getCategories());
        List<Integer> categoryImages = Arrays.asList(categories.getCategoryImages());
        List<Integer> categoryAudio = Arrays.asList(categories.getCategoryAudio());

        for (int i = 0; i < categoryNames.size(); i++) {
            cardList.add(
                    new CategoryCardItemViewModel(
                            new CategoryCardItem(categoryAudio.get(i), categoryImages.get(i), categoryNames.get(i)),
                            BackgroundColors[i % BackgroundColors.length],
                            DetailColors[i % DetailColors.length]
                    )
            );
        }
    }

    public List<CategoryCardItemViewModel> getCardList() {
        return cardList;
    }
}
