package com.example.make_a_story_prototype.main.Categories.vm;

import android.content.Context;

import com.example.make_a_story_prototype.main.data.Word.Category;
import com.example.make_a_story_prototype.main.data.Word.DebugWordRepository;

import java.util.ArrayList;
import java.util.List;

public class CategoriesViewModel {

    private List<CategoryCardItemViewModel> cardList = new ArrayList<>();

    public CategoriesViewModel(Context context) {
        DebugWordRepository wordRepo = DebugWordRepository.getInstance();
        List<Category> categories = wordRepo.getCategories().blockingGet();

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
