package com.example.make_a_story_prototype.main.Characters.view.NameCards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.view.NameCards.CharacterNameCardHolder.CharacterNameCallback;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel.NameCardViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterNamesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterNameCardHolder> implements CharacterNameCallback {
    private CharacterScreenViewModel vm;
    private List<NameCardViewModel> cardVms;
    private NameCardViewModel selectedCardVm;

    public CharacterNamesRecyclerViewAdapter(CharacterScreenViewModel vm) {
        this.vm = vm;

        vm.characterNames().subscribe(cardVms -> {
            this.cardVms = cardVms;
            notifyDataSetChanged();
        });

        vm.selectedCharacterName().subscribe(selectedCardVm -> {
            this.selectedCardVm = selectedCardVm;
            notifyDataSetChanged();
        });
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
        NameCardViewModel currentCard = cardVms.get(position);
        if (currentCard == selectedCardVm) {
            // TODO:
        } else {
            // TODO:
        }
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return cardVms.size();
    }

    @Override
    public void nameTappedOn(NameCardViewModel vm) {
        this.vm.selectNameCard(vm);
    }
}
