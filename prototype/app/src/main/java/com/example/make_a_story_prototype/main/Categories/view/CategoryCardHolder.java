package com.example.make_a_story_prototype.main.Categories.view;

import android.content.Context;
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
import com.example.make_a_story_prototype.main.data.Word.Category;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryCardHolder extends RecyclerView.ViewHolder {
    public interface CategoryCardCallback {
        void cardTappedOn(CategoryCardItemViewModel vm);
        void hideConfirmationButtons(CategoryCardItemViewModel vm);
        void confirmSelection(CategoryCardItemViewModel vm);
    }

    private Context context;
    private ImageView categoryImage;
    private TextView categoryText;
    private RelativeLayout parentLayout;
    private CategoryCardItemViewModel vm;
    private Button confirmButton;
    private Button cancelButton;

    public CategoryCardCallback callback;

    public CategoryCardHolder(@NonNull View itemView) {
        super(itemView);

        this.context = itemView.getContext();
        this.categoryImage = itemView.findViewById(R.id.cardImage);
        this.categoryText = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parent_layout);
        this.confirmButton = itemView.findViewById(R.id.confirmButton);
        this.cancelButton = itemView.findViewById(R.id.cancelButton);

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

            callback.hideConfirmationButtons(vm);
        });
    }

    public void setViewModel(CategoryCardItemViewModel vm, int backgroundColor, int contrastColor) {
        this.vm = vm;

        Category category = vm.category;

        categoryImage.setImageResource(category.getImageResource());
        categoryText.setText(category.getName());
        categoryText.setTextColor(contrastColor);

        Drawable imageBackground = parentLayout.getBackground();
        Util.changeDrawableColor(imageBackground, backgroundColor);


        CardView cardView = itemView.findViewById(R.id.card_view);
        Drawable imageBorder = cardView.getBackground();
        Util.changeDrawableColor(imageBorder, contrastColor);
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
        d.setColorFilter(new PorterDuffColorFilter(contrastColor, PorterDuff.Mode.SRC_IN));
    }

    public void setColors(int backgroundColor, int contrastColor) {

    }

}