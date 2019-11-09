package com.example.make_a_story_prototype.main.view.wordbank;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.model.CardItem;
import com.example.make_a_story_prototype.main.vm.CardItemViewModel;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class WordCardHolder extends RecyclerView.ViewHolder {
    public interface WordCardCallback {
        void onClick(CardItem item);
    }

    private ImageView wordImage;
    private TextView wordText;
    private RelativeLayout parentLayout;
    private CardItemViewModel vm;

    public WordCardCallback callback;

    public WordCardHolder(@NonNull View itemView) {
        super(itemView);
        this.wordImage = itemView.findViewById(R.id.cardImage);
        this.wordText = itemView.findViewById(R.id.cardText);
        this.parentLayout = itemView.findViewById(R.id.parentLayout);

        parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null && vm != null) {
                    callback.onClick(vm.cardItem);
                }
            }
        });
    }

    public void setViewModel(CardItemViewModel vm) {
        this.vm = vm;

        wordImage.setImageResource(vm.cardItem.getImageResource());
        wordText.setText(vm.cardItem.getImageLabel());
        wordText.setTextColor(vm.contrastColor);
        ((CardView)itemView).setCardBackgroundColor(vm.backgroundColor);
        ((CardView)itemView).setRadius(20);

        // setting color for drawableLeft
        TextView text = itemView.findViewById(R.id.cardText);
        Drawable d = text
                .getCompoundDrawables()[0]
                .mutate();

        // TODO: take another look at this
        d.setColorFilter(new PorterDuffColorFilter(vm.contrastColor, PorterDuff.Mode.SRC_IN));
    }
}