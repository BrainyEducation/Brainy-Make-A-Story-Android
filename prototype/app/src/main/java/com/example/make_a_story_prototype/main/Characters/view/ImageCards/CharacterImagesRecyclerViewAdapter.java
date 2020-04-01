package com.example.make_a_story_prototype.main.Characters.view.ImageCards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel.ImageCardViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterImagesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterImageCardHolder> implements CharacterImageCardHolder.CharacterImageCallback {
    private final CharacterScreenViewModel vm;
    private List<ImageCardViewModel> cardVms;

    public CharacterImagesRecyclerViewAdapter(CharacterScreenViewModel vm) {
        this.vm = vm;

        vm.characterImages().subscribe(cardVms -> {
            this.cardVms = cardVms;
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public CharacterImageCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card_item, parent, false);
        CharacterImageCardHolder viewHolder = new CharacterImageCardHolder(view);
        viewHolder.callback = this;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterImageCardHolder holder, final int position) {
        ImageCardViewModel currentCard = cardVms.get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return cardVms.size();
    }

    @Override
    public void imageTappedOn(ImageCardViewModel vm) {
        this.vm.selectImageCard(vm);
    }
}
