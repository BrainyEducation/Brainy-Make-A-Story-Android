package com.example.make_a_story_prototype.main.Characters.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.model.CharacterCardItem;
import com.example.make_a_story_prototype.main.Characters.model.Characters;
import com.example.make_a_story_prototype.main.Util.Optional;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class CharacterScreenViewModel {

    //region Types

    public class NameCardViewModel {
        public String name;

        public int contrastColor;
        public int backgroundColor;

        public NameCardViewModel(String name, int contrastColor, int backgroundColor) {
            this.name = name;
            this.contrastColor = contrastColor;
            this.backgroundColor = backgroundColor;
        }
    }

    public class ImageCardViewModel {
        public int image;

        public int contrastColor;
        public int backgroundColor;

        public ImageCardViewModel(int image, int contrastColor, int backgroundColor) {
            this.image = image;
            this.contrastColor = contrastColor;
            this.backgroundColor = backgroundColor;
        }
    }

    //endregion
    //region Private Properties

    private BehaviorSubject<List<NameCardViewModel>> _characterNames;
    private BehaviorSubject<List<ImageCardViewModel>> _characterImages;
    private BehaviorSubject<NameCardViewModel> _selectedCharacterName;
    private BehaviorSubject<ImageCardViewModel> _selectedCharacterImage;
    private BehaviorSubject<Optional<CharacterCardItem>> _selectedCharacter;

    //endregion
    //region Public Properties

    public Observable<List<NameCardViewModel>> characterNames() {
        return _characterNames;
    }
    public Observable<List<ImageCardViewModel>> characterImages() {
        return _characterImages;
    }

    public Observable<NameCardViewModel> selectedCharacterName() {
        return _selectedCharacterName;
    }
    public Observable<ImageCardViewModel> selectedCharacterImage() {
        return _selectedCharacterImage;
    }

    public Observable<Optional<CharacterCardItem>> selectedCharacter() {
        return _selectedCharacter;
    }


    //endregion
    //region Interface

    public void selectNameCard(NameCardViewModel nameCard) {
        _selectedCharacterName.onNext(nameCard);
        updateConfirmationIfNeeded();
    }

    public void selectImageCard(ImageCardViewModel imageCard) {
        _selectedCharacterImage.onNext(imageCard);
        updateConfirmationIfNeeded();
    }

    public void confirmCharacter() {
        // TODO: something
    }

    public void cancelConfirmingCharacter() {
        _selectedCharacter.onNext(new Optional(null));
    }

    //endregion
    //region Utility

    private void updateConfirmationIfNeeded() {
        NameCardViewModel nameCard = _selectedCharacterName.getValue();
        ImageCardViewModel imageCard = _selectedCharacterImage.getValue();

        if (nameCard != null && imageCard != null) {
            _selectedCharacter.onNext(new Optional(new CharacterCardItem(imageCard.image, nameCard.name)));
        }
    }

    //endregion
    //region Constructor

    // TODO: fix this
    public CharacterScreenViewModel(Context context, Characters characters) {
        int coolCardBackgroundColors[] = {
                ContextCompat.getColor(context, R.color.colorLightGreen),
                ContextCompat.getColor(context, R.color.colorLightPurple),
                ContextCompat.getColor(context, R.color.colorLightBlue),
        };

        int coolCardDetailColors[] = {
                ContextCompat.getColor(context, R.color.colorContrastGreen),
                ContextCompat.getColor(context, R.color.colorContrastPurple),
                ContextCompat.getColor(context, R.color.colorContrastBlue),
        };

        int warmCardBackgroundColors[] = {
                ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
        };

        int warmCardDetailColors[] = {
                ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
        };

        List<NameCardViewModel> characterNames = new ArrayList<>();
        String[] characterNamesRaw = characters.getCharacterNames();
        for (int i = 0; i < characterNamesRaw.length; i += 1) {
            String name = characterNamesRaw[i];

            characterNames.add(new NameCardViewModel(
                    name,
                    coolCardBackgroundColors[i % coolCardBackgroundColors.length],
                    coolCardDetailColors[i % coolCardDetailColors.length]
            ));
        }


        List<ImageCardViewModel> characterImages = new ArrayList<>();
        Integer[] characterImagesRaw = characters.getCharacterImages();
        for (int i = 0; i < characterImagesRaw.length; i += 1) {
            int image = characterImagesRaw[i];

            characterImages.add(new ImageCardViewModel(
                    image,
                    coolCardBackgroundColors[i % coolCardBackgroundColors.length],
                    coolCardDetailColors[i % coolCardDetailColors.length]
            ));
        }

        _characterNames = BehaviorSubject.createDefault(characterNames);
        _characterImages = BehaviorSubject.createDefault(characterImages);

        _selectedCharacterName = BehaviorSubject.create();
        _selectedCharacterImage = BehaviorSubject.create();
        _selectedCharacter = BehaviorSubject.create();
    }

    //endregion

}
