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

    private final Context context;
    private final CategoriesViewModel vm;
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

        int BackgroundColors[] = {
                context.getResources().getColor(R.color.colorLightRed),
                context.getResources().getColor(R.color.colorLightOrange),
                context.getResources().getColor(R.color.colorLightGreen),
                context.getResources().getColor(R.color.colorLightPurple),
                context.getResources().getColor(R.color.colorLightBlue),
        };

        int DetailColors[] = {
                context.getResources().getColor(R.color.colorContrastRed),
                context.getResources().getColor(R.color.colorContrastOrange),
                context.getResources().getColor(R.color.colorContrastGreen),
                context.getResources().getColor(R.color.colorContrastPurple),
                context.getResources().getColor(R.color.colorContrastBlue),
        };

        holder.setViewModel(currentCard, BackgroundColors[position % BackgroundColors.length], DetailColors[position % DetailColors.length]);
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

        handler.selectCategoryCard(vm);

    }
}
