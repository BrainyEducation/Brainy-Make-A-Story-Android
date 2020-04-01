package com.example.make_a_story_prototype.main.Characters.view.NameCards;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel.NameCardViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterNameCardHolder extends RecyclerView.ViewHolder {

    public interface CharacterNameCallback {
        void nameTappedOn(NameCardViewModel vm);
    }

    public CharacterNameCallback callback;

    private final TextView characterName;
    private final RelativeLayout parentLayout;
    private NameCardViewModel vm;

    public CharacterNameCardHolder(@NonNull View itemView) {
        super(itemView);
        this.characterName = itemView.findViewById(R.id.character_name);
        this.parentLayout = itemView.findViewById(R.id.parent_layout);

        parentLayout.setOnClickListener(v -> {
            if (callback != null && vm != null ) {
                callback.nameTappedOn(vm);
            }
        });
    }

    public void setViewModel(NameCardViewModel vm) {
        this.vm = vm;

        characterName.setText(vm.name);
        characterName.setTextColor(vm.contrastColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, vm.backgroundColor);

        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, vm.contrastColor);
        cardView.setRadius(23);

        ImageView speakerIcon = itemView.findViewById(R.id.speaker_icon);

        Drawable speakerDrawable = DrawableCompat.wrap(speakerIcon.getDrawable());
        Util.changeDrawableColor(speakerDrawable, vm.contrastColor);
    }
}
