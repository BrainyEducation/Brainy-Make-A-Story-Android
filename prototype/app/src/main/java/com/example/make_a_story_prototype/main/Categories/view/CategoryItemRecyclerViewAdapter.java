package com.example.make_a_story_prototype.main.Categories.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Media.AudioPlayer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryItemRecyclerViewAdapter extends RecyclerView.Adapter<CategoryCardHolder> implements CategoryCardHolder.CategoryCardCallback {

    public interface CategoryAdapterHandler {
        void selectCategoryCard(CategoryCardItemViewModel vm);
    }

    private Context context;
    private CategoriesViewModel vm;
    private static android.media.MediaPlayer mediaPlayer = AudioPlayer.getInstance();

    public CategoryAdapterHandler handler;


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
            mediaPlayer = android.media.MediaPlayer.create(context, vm.category.getAudioResource());
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
        if (handler == null) {
            Log.d("tag", "confirmSelection -- handler is null");
            return;
        }
        handler.selectCategoryCard(vm);
    }
}
