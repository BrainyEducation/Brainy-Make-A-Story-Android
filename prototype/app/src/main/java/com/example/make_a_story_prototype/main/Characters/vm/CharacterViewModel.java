package com.example.make_a_story_prototype.main.Characters.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.model.CharacterCardItem;
import com.example.make_a_story_prototype.main.Characters.model.Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.core.content.ContextCompat;

public class CharacterViewModel {
    private List<CharacterCardItemViewModel> cardList = new ArrayList<>();

    public CharacterViewModel(Context context) {
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

        Characters characters = new Characters();
        List<String> characterNames = Arrays.asList(characters.getCharacterNames());
        List<Integer> characterImages = Arrays.asList(characters.getCharacterImages());

        for (int i = 0; i < 10; i++) {
            cardList.add(
                    new CharacterCardItemViewModel(
                            new CharacterCardItem(characterImages.get(i), characterNames.get(i)),
                            BackgroundColors[i % BackgroundColors.length],
                            DetailColors[i % DetailColors.length]
                    )
            );
        }
    }

    public List<CharacterCardItemViewModel> getCardList() {
        return cardList;
    }

}
