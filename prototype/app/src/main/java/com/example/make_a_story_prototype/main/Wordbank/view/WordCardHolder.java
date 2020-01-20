package com.example.make_a_story_prototype.main.Wordbank.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.View.GONE;
import static com.example.make_a_story_prototype.main.Util.changeDrawableColor;
import static com.example.make_a_story_prototype.main.Util.setDrawableToGrayscale;

public class WordCardHolder extends RecyclerView.ViewHolder {
    public interface WordCardCallback {
        void showConfirmationButtons(WordCardItemViewModel vm);

        void hideConfirmationButtons(WordCardItemViewModel vm);

        void confirmSelection(WordCardItemViewModel vm);

    }

    private ImageView wordImage;
    private TextView wordText;
    private RelativeLayout parentLayout;
    private WordCardItemViewModel vm;
    private Button confirmButton;
    private Button cancelButton;

    public WordCardCallback callback;

    public WordCardHolder(@NonNull View itemView) {
        super(itemView);
        this.wordImage = itemView.findViewById(R.id.cardImage);
        this.wordText = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parentLayout);
        this.confirmButton = itemView.findViewById(R.id.confirmButton);
        this.cancelButton = itemView.findViewById(R.id.cancelButton);

        parentLayout.setOnClickListener(v -> {
            if (callback != null && vm != null) {
                callback.showConfirmationButtons(vm);
            }
        });

        confirmButton.setOnClickListener(v -> {
            if (callback != null && vm != null) {
                callback.confirmSelection(vm);
            }
        });

        cancelButton.setOnClickListener(v -> {
            if (callback == null && vm != null) {
                return;
            }

            callback.hideConfirmationButtons(vm);
        });
    }


    public WordCardItemViewModel getViewModel() {
        return vm;
    }

    public void setViewModel(WordCardItemViewModel vm) {
        this.vm = vm;

        wordImage.setImageResource(vm.cardItem.getImageResource());
        wordText.setText(vm.cardItem.getImageLabel());
        wordText.setTextColor(vm.contrastColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, vm.backgroundColor);

        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, vm.contrastColor);
        cardView.setRadius(23);

        ViewGroup buttons = itemView.findViewById(R.id.confirmation_buttons);

        if (vm.isSelected) {
            buttons.setVisibility(View.VISIBLE);
        } else {
            buttons.setVisibility(GONE);
        }

        if (!vm.isUnlocked) {
            Drawable cardImage = wordImage.getDrawable();
            setDrawableToGrayscale(cardImage);
        }

        // setting color for drawableLeft
        TextView text = itemView.findViewById(R.id.cardText);
        Drawable drawableSpeaker = text
                .getCompoundDrawables()[0];
        changeDrawableColor(drawableSpeaker, vm.contrastColor);
    }
}