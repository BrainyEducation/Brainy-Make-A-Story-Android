package com.example.make_a_story_prototype.main.Categories.view;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryCardHolder extends RecyclerView.ViewHolder {
    public interface CategoryCardCallback {
        void cardTappedOn(CategoryCardItemViewModel vm);
        void hideConfirmationButtons(CategoryCardItemViewModel vm);
        void confirmSelection(CategoryCardItemViewModel vm);
    }

    private final ImageView categoryImage;
    private final TextView categoryText;
    private final RelativeLayout parentLayout;
    private CategoryCardItemViewModel vm;

    public CategoryCardCallback callback;

    public CategoryCardHolder(@NonNull View itemView) {
        super(itemView);
        this.categoryImage = itemView.findViewById(R.id.cardImage);
        this.categoryText = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parent_layout);
        Button confirmButton = itemView.findViewById(R.id.confirmButton);
        Button cancelButton = itemView.findViewById(R.id.cancelButton);

        parentLayout.setOnClickListener(v -> {
            if (callback != null && vm != null) {
                callback.cardTappedOn(vm);
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

            Objects.requireNonNull(callback).hideConfirmationButtons(vm);
        });
    }

    public void setViewModel(CategoryCardItemViewModel vm) {
        this.vm = vm;

        categoryImage.setImageResource(vm.cardItem.getImageResource());
        categoryText.setText(vm.cardItem.getImageLabel());
        categoryText.setTextColor(vm.contrastColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, vm.backgroundColor);


        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, vm.contrastColor);
        cardView.setRadius(23);

        // setting color for drawableLeft
        TextView text = itemView.findViewById(R.id.cardText);
        Drawable d = text
                .getCompoundDrawables()[0]
                .mutate();

        ViewGroup buttons = itemView.findViewById(R.id.confirmation_buttons);
        if (vm.isSelected) {
            buttons.setVisibility(View.VISIBLE);
        } else {
            buttons.setVisibility(View.GONE);
        }

        // TODO: take another look at this
        d.setColorFilter(new PorterDuffColorFilter(vm.contrastColor, PorterDuff.Mode.SRC_IN));
    }
}