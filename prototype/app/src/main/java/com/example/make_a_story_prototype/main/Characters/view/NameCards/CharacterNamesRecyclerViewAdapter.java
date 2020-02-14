package com.example.make_a_story_prototype.main.Characters.view.NameCards;

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

public class CharacterNamesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterNameCardHolder> implements CharacterNameCardHolder.CharacterNameCallback {
    private Context context;
    private CharacterViewModel vm;

    public CharacterNamesRecyclerViewAdapter(Context context, CharacterViewModel vm) {
        this.context = context;
        this.vm = vm;
    }

    @NonNull
    @Override
    public CharacterNameCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_card_item, parent, false);
        CharacterNameCardHolder viewHolder = new CharacterNameCardHolder(view);
        viewHolder.callback = this;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterNameCardHolder holder, final int position) {
        CharacterCardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

    @Override
    public void nameTappedOn(CharacterCardItemViewModel vm) {
        for (CharacterCardItemViewModel cardVm : this.vm.getCardList()) {
            cardVm.isSelected = false;
        }

        vm.isSelected = true;
        Log.d("TAG", vm.cardItem.getImageLabel() + "tapped");

    }
}
