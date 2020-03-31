package com.example.make_a_story_prototype.main.Wordbank.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.data.MasteredWords.DebugMasteredWordsRepository;
import com.example.make_a_story_prototype.main.data.Word.Word;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.View.GONE;
import static com.example.make_a_story_prototype.main.Util.Util.changeDrawableColor;
import static com.example.make_a_story_prototype.main.Util.Util.setDrawableToGrayscale;

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

    private Context context;

    public WordCardCallback callback;

    public WordCardHolder(@NonNull View itemView) {
        super(itemView);

        this.context = itemView.getContext();
        this.wordImage = itemView.findViewById(R.id.cardImage);
        this.wordText = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parent_layout);
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

        int lockedBackgroundColor = context.getResources().getColor(R.color.colorLockedBackground);
        int unlockedBackgroundColor = context.getResources().getColor(R.color.colorWordBackground);
        int lockedContrastColor = context.getResources().getColor(R.color.colorLockedContrast);
        int unlockedContrastColor = context.getResources().getColor(R.color.colorWordContrast);

        DebugMasteredWordsRepository masteredWordsRepo = DebugMasteredWordsRepository.getInstance();

        boolean isMastered = masteredWordsRepo.isMastered(vm.word.getId());
        int backgroundColor =  isMastered ? unlockedBackgroundColor : lockedBackgroundColor;
        int contrastColor = isMastered ? unlockedContrastColor : lockedContrastColor;

        wordImage.setImageResource(vm.word.getImageResource());
        wordText.setText(vm.word.getWord());
        wordText.setTextColor(contrastColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, backgroundColor);

        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, contrastColor);
        cardView.setRadius(23);

        ViewGroup buttons = itemView.findViewById(R.id.confirmation_buttons);

        if (vm.isSelected) {
            buttons.setVisibility(View.VISIBLE);
        } else {
            buttons.setVisibility(GONE);
        }

        if (!isMastered) {
            Drawable cardImage = wordImage.getDrawable();
            setDrawableToGrayscale(cardImage);
        }

        // setting color for drawableLeft
        TextView text = itemView.findViewById(R.id.cardText);
        Drawable drawableSpeaker = text
                .getCompoundDrawables()[0];
        changeDrawableColor(drawableSpeaker, contrastColor);
    }
}