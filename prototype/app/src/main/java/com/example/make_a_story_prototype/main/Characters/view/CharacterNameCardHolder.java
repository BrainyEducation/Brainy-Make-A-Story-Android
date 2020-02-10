package com.example.make_a_story_prototype.main.Characters.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterCardItemViewModel;
import com.example.make_a_story_prototype.main.Util;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterNameCardHolder extends RecyclerView.ViewHolder{
    private TextView characterName;
    private RelativeLayout parentLayout;
    private CharacterCardItemViewModel vm;

    public CharacterNameCardHolder(@NonNull View itemView) {
        super(itemView);
        this.characterName = itemView.findViewById(R.id.characterName);
        this.parentLayout = itemView.findViewById(R.id.parentLayout);
    }

    public void setViewModel(CharacterCardItemViewModel vm) {
        this.vm = vm;

        characterName.setText(vm.cardItem.getImageLabel());

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, vm.backgroundColor);

        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, vm.contrastColor);
        cardView.setRadius(23);
    }
}
