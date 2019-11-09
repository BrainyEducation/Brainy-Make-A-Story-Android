package com.example.make_a_story_prototype.main.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.entity.CardItem;
import com.example.make_a_story_prototype.main.entity.Categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.core.content.ContextCompat;

public class CategoriesViewModel {

    private ArrayList<CardItemViewModel> cardList = new ArrayList<>();

    public CategoriesViewModel(Context context) {
        int BackgroundColors[] = {
                ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
                ContextCompat.getColor(context, R.color.colorLightGreen),
                ContextCompat.getColor(context, R.color.colorLightPurple),
                ContextCompat.getColor(context, R.color.colorLightBlue),
        };

        int DetailColors[] = {
                ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
                ContextCompat.getColor(context, R.color.colorContrastGreen),
                ContextCompat.getColor(context, R.color.colorContrastPurple),
                ContextCompat.getColor(context, R.color.colorContrastBlue),
        };

        Categories categories = new Categories();
        List<String> categoryNames = Arrays.asList(categories.getCategories());
        List<Integer> categoryImages = Arrays.asList(categories.getCategoryImages());

        for (int i = 0; i < 10; i++) {
            cardList.add(
                    new CardItemViewModel(
                            new CardItem(categoryImages.get(i), categoryNames.get(i)),
                            BackgroundColors[i % BackgroundColors.length],
                            DetailColors[i % DetailColors.length]
                    )
            );
        }
    }

    public ArrayList<CardItemViewModel> getCardList() {
        return cardList;
    }
}
