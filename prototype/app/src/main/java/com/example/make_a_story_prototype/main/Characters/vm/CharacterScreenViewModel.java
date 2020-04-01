package com.example.make_a_story_prototype.main.Characters.vm;

import android.content.Context;

import com.example.make_a_story_prototype.R;
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
        public final String name;

        public final int contrastColor;
        public final int backgroundColor;

        NameCardViewModel(String name, int contrastColor, int backgroundColor) {
            this.name = name;
            this.contrastColor = contrastColor;
            this.backgroundColor = backgroundColor;
        }
    }

    public class ImageCardViewModel {
        public final int image;

        public final int contrastColor;
        public final int backgroundColor;

        ImageCardViewModel(int image, int contrastColor, int backgroundColor) {
            this.image = image;
            this.contrastColor = contrastColor;
            this.backgroundColor = backgroundColor;
        }
    }

    public class CharacterViewModel {
        public final String name;
        public final int image;

        public final int nameContrastColor;
        public final int nameBackgroundColor;


        public final int imageContrastColor;
        public final int imageBackgroundColor;

        CharacterViewModel(String name, int image, int nameContrastColor, int nameBackgroundColor,
                int imageContrastColor, int imageBackgroundColor) {
            this.name = name;
            this.image = image;

            this.nameContrastColor = nameContrastColor;
            this.nameBackgroundColor = nameBackgroundColor;
            this.imageContrastColor = imageContrastColor;
            this.imageBackgroundColor = imageBackgroundColor;
        }
    }

    //endregion
    //region Private Properties

    private final BehaviorSubject<List<NameCardViewModel>> _characterNames;
    private final BehaviorSubject<List<ImageCardViewModel>> _characterImages;
    private final BehaviorSubject<NameCardViewModel> _selectedCharacterName;
    private final BehaviorSubject<ImageCardViewModel> _selectedCharacterImage;
    private final BehaviorSubject<Optional<CharacterViewModel>> _selectedCharacter;

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

    public Observable<Optional<CharacterViewModel>> selectedCharacter() {
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
            _selectedCharacter.onNext(new Optional(new CharacterViewModel(nameCard.name, imageCard.image, nameCard.contrastColor, nameCard.backgroundColor, imageCard.contrastColor, imageCard.backgroundColor)));
        }
    }

    //endregion
    //region Constructor

    // TODO: fix this
    public CharacterScreenViewModel(Context context, Characters characters) {
        int[] coolCardBackgroundColors = {
                ContextCompat.getColor(context, R.color.colorLightGreen),
                ContextCompat.getColor(context, R.color.colorLightPurple),
                ContextCompat.getColor(context, R.color.colorLightBlue),
        };

        int[] coolCardDetailColors = {
                ContextCompat.getColor(context, R.color.colorContrastGreen),
                ContextCompat.getColor(context, R.color.colorContrastPurple),
                ContextCompat.getColor(context, R.color.colorContrastBlue),
        };

        int[] warmCardBackgroundColors = {
                ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
        };

        int[] warmCardDetailColors = {
                ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
        };

        List<NameCardViewModel> characterNames = new ArrayList<>();
        String[] characterNamesRaw = characters.getCharacterNames();
        for (int i = 0; i < characterNamesRaw.length; i += 1) {
            String name = characterNamesRaw[i];

            characterNames.add(new NameCardViewModel(
                    name,
                    warmCardDetailColors[i % warmCardDetailColors.length],
                    warmCardBackgroundColors[i % warmCardBackgroundColors.length]
            ));
        }


        List<ImageCardViewModel> characterImages = new ArrayList<>();
        Integer[] characterImagesRaw = characters.getCharacterImages();
        for (int i = 0; i < characterImagesRaw.length; i += 1) {
            int image = characterImagesRaw[i];

            characterImages.add(new ImageCardViewModel(
                    image,
                    coolCardDetailColors[i % coolCardDetailColors.length],
                    coolCardBackgroundColors[i % coolCardBackgroundColors.length]
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
