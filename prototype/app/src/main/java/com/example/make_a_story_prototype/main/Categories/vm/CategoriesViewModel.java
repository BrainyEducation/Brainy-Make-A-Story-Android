package com.example.make_a_story_prototype.main.Categories.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.data.Word.DebugWordRepository;
import com.example.make_a_story_prototype.main.data.Word.Category;


import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;

public class CategoriesViewModel {

    private List<CategoryCardItemViewModel> cardList = new ArrayList<>();

    public CategoriesViewModel(Context context) {
        DebugWordRepository wordRepo = DebugWordRepository.getInstance();
        List<Category> categories = wordRepo.getCategories().blockingGet();
//        List<Category> categories = wordRepo.getCategories().subscribe(category -> {
//            categories.add(category);
//        });

        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);

            cardList.add(
                    new CategoryCardItemViewModel(category)
            );
        }
    }

    public List<CategoryCardItemViewModel> getCardList() {
        return cardList;
    }
}
