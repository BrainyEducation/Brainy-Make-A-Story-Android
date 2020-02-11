package com.example.make_a_story_prototype.main.Characters.view.ImageCards;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterCardItemViewModel;
import com.example.make_a_story_prototype.main.Util;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CharacterImageCardHolder extends RecyclerView.ViewHolder{

    private ImageView characterImage;
    private RelativeLayout parentLayout;
    private CharacterCardItemViewModel vm;

    public CharacterImageCardHolder(@NonNull View itemView) {
        super(itemView);
        this.characterImage = itemView.findViewById(R.id.characterImage);
        this.parentLayout = itemView.findViewById(R.id.parentLayout);
    }

    public void setViewModel(CharacterCardItemViewModel vm) {
        this.vm = vm;

        // null?
        characterImage.setImageResource(vm.cardItem.getImageResource());

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, vm.backgroundColor);

        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, vm.contrastColor);
        cardView.setRadius(23);
    }
}
