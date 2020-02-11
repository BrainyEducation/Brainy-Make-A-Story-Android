package com.example.make_a_story_prototype.main.Characters.view.ImageCards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterCardItemViewModel;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterImagesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterImageCardHolder> {
    private Context context;
    private CharacterViewModel vm;

    public CharacterImagesRecyclerViewAdapter(Context context, CharacterViewModel vm) {
        this.context = context;
        this.vm = vm;
    }

    @NonNull
    @Override
    public CharacterImageCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card_item, parent, false);
        CharacterImageCardHolder viewHolder = new CharacterImageCardHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterImageCardHolder holder, final int position) {
        CharacterCardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

}
