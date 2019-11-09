package com.example.make_a_story_prototype.main.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.entity.CardItem;
import com.example.make_a_story_prototype.main.vm.CardItemViewModel;
import com.example.make_a_story_prototype.main.vm.CategoriesViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardItemRecyclerViewAdapter extends RecyclerView.Adapter<CategoryCardHolder> implements CategoryCardHolder.CategoryCardCallback {
    private Context context;
    private CategoriesViewModel vm;

    public CardItemRecyclerViewAdapter(Context context, CategoriesViewModel vm) {
        this.context = context;
        this.vm = vm;
    }

    @NonNull
    @Override
    public CategoryCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CategoryCardHolder viewHolder = new CategoryCardHolder(view);
        viewHolder.callback = this;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCardHolder holder, final int position) {
        CardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

    @Override
    public void onClick(CardItem item) {
        Toast.makeText(context, item.getImageLabel(), Toast.LENGTH_SHORT).show();

        // need to switch from quiz screen to wordbank
        Intent intent = new Intent(context, QuizActivity.class);
        context.startActivity(intent);
    }
}
