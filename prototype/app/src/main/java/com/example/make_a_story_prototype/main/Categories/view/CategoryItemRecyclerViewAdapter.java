package com.example.make_a_story_prototype.main.Categories.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.model.CategoryCardItem;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Media.AudioPlayer;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryItemRecyclerViewAdapter extends RecyclerView.Adapter<CategoryCardHolder> implements CategoryCardHolder.CategoryCardCallback {
    private Context context;
    private CategoriesViewModel vm;
    private static android.media.MediaPlayer mediaPlayer = AudioPlayer.getInstance();


    public CategoryItemRecyclerViewAdapter(Context context, CategoriesViewModel vm) {
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
        CategoryCardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

    @Override
    public void cardTappedOn(CategoryCardItemViewModel vm) {
        for (CategoryCardItemViewModel cardVm : this.vm.getCardList()) {
            cardVm.isSelected = false;
        }

        vm.isSelected = true;
        notifyDataSetChanged();

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer = android.media.MediaPlayer.create(context, vm.cardItem.getImageAudio());
            mediaPlayer.start();
        }
    }

    @Override
    public void hideConfirmationButtons(CategoryCardItemViewModel vm) {
        vm.isSelected = false;
        notifyDataSetChanged();
    }

    @Override
    public void confirmSelection(CategoryCardItemViewModel vm) {
        CategoryCardItem item = vm.cardItem;

        if (item.getImageLabel().toLowerCase().equals("food")) {
            Intent intent = new Intent(context, WordbankActivity.class);
            intent.putExtra("source", item.getImageLabel());
            context.startActivity(intent);
        } else {
            Toast.makeText(context, (item.getImageLabel() + " isn't currently available"), Toast.LENGTH_SHORT).show();
        }
    }
}
