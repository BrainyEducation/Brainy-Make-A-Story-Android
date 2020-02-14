package com.example.make_a_story_prototype.main.Characters.view.ImageCards;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterCardItemViewModel;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterImagesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterImageCardHolder> implements CharacterImageCardHolder.CharacterImageCallback {
    private CharacterViewModel vm;
    private Context context;

    public CharacterImagesRecyclerViewAdapter(Context context, CharacterViewModel vm) {
        this.vm = vm;
        this.context = context;
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
        CharacterCardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

    @Override
    public void imageTappedOn(CharacterCardItemViewModel vm) {

        for (CharacterCardItemViewModel cardVm : this.vm.getCardList()) {
            cardVm.isSelected = false;
        }

        vm.isSelected = true;
        Log.d("TAG", "Character image tapped");
    }
}
