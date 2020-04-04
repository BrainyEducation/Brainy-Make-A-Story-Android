package com.example.make_a_story_prototype.main.Characters.vm;

import android.content.Context;

import com.example.make_a_story_prototype.main.Characters.model.Characters;
import com.example.make_a_story_prototype.main.Util.Optional;
import com.example.make_a_story_prototype.main.data.Character.CharacterName;
import com.example.make_a_story_prototype.main.data.Character.CharacterRepository;
import com.example.make_a_story_prototype.main.data.Character.DebugCharacterRepository;
import com.example.make_a_story_prototype.main.data.Character.StoryCharacter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class CharacterScreenViewModel {

    //region Types

    public class NameCardViewModel {
        public CharacterName name;

        public NameCardViewModel (CharacterName name) {
            this.name = name;
        }
    }

    public class ImageCardViewModel {
        public int image;

        public ImageCardViewModel(int image) {
            this.image = image;
        }
    }

    public class CharacterViewModel {
        public StoryCharacter character;

        public CharacterViewModel(StoryCharacter character) {
            this.character = character;
        }
    }

    //endregion
    //region Private Properties

    private BehaviorSubject<List<NameCardViewModel>> _characterNames;
    private BehaviorSubject<List<ImageCardViewModel>> _characterImages;
    private BehaviorSubject<NameCardViewModel> _selectedCharacterName;
    private BehaviorSubject<ImageCardViewModel> _selectedCharacterImage;
    private BehaviorSubject<Optional<CharacterViewModel>> _selectedCharacter;

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
            StoryCharacter character = new StoryCharacter(nameCard.name, imageCard.image);
            _selectedCharacter.onNext(new Optional(new CharacterViewModel(character)));
        }
    }

    //endregion
    //region Constructor

    CharacterRepository characterRepository = DebugCharacterRepository.getInstance();

    // TODO: fix this
    public CharacterScreenViewModel(Context context, Characters characters) {
        List<NameCardViewModel> characterNameVms = new ArrayList<>();
        List<CharacterName> characterNames = characterRepository.getCharacterNames();
        for (int i = 0; i < characterNames.size(); i++) {
            CharacterName name = characterNames.get(i);

            characterNameVms.add(new NameCardViewModel(name));
        }


        List<ImageCardViewModel> characterImageVms = new ArrayList<>();
        List<Integer> characterImages = characterRepository.getCharacterImages();
        for (int i = 0; i < characterImages.size(); i += 1) {
            int image = characterImages.get(i);

            characterImageVms.add(new ImageCardViewModel(image));
        }

        _characterNames = BehaviorSubject.createDefault(characterNameVms);
        _characterImages = BehaviorSubject.createDefault(characterImageVms);

        _selectedCharacterName = BehaviorSubject.create();
        _selectedCharacterImage = BehaviorSubject.create();
        _selectedCharacter = BehaviorSubject.create();
    }

    //endregion

}
