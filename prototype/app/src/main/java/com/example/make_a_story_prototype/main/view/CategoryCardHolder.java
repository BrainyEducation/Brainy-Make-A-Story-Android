package com.example.make_a_story_prototype.main.view;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.entity.CardItem;
import com.example.make_a_story_prototype.main.vm.CardItemViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryCardHolder extends RecyclerView.ViewHolder {
    public interface CategoryCardCallback {
        void onClick(CardItem item);
    }

    private ImageView category;
    private TextView categoryName;
    private RelativeLayout parentLayout;
    private CardItemViewModel vm;

    public CategoryCardCallback callback;

    public CategoryCardHolder(@NonNull View itemView) {
        super(itemView);
        this.category = itemView.findViewById(R.id.categoryImage);
        this.categoryName = itemView.findViewById(R.id.categoryText);
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

        category.setImageResource(vm.cardItem.getImageResource());
        categoryName.setText(vm.cardItem.getImageLabel());
        categoryName.setTextColor(vm.contrastColor);
        itemView.setBackgroundColor(vm.backgroundColor);

        // setting color for drawableLeft
        TextView text = itemView.findViewById(R.id.categoryText);
        Drawable d = text
                .getCompoundDrawables()[0]
                .mutate();

        // TODO: does this really work????
        d.setColorFilter(new PorterDuffColorFilter(vm.contrastColor, PorterDuff.Mode.SRC_IN));
    }
}