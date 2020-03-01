package com.example.make_a_story_prototype.main.Wordbank.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Quiz.view.QuizActivity;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordbankItemRecyclerViewAdapter extends RecyclerView.Adapter<WordCardHolder> implements WordCardHolder.WordCardCallback {

    public interface WordbankAdapterHandler {
        void selectWordCard(WordCardItemViewModel vm);
    }

    private Context context;
    private WordbankViewModel vm;

    public WordbankAdapterHandler handler;

    public WordbankItemRecyclerViewAdapter(Context context, WordbankViewModel vm) {
        this.context = context;
        this.vm = vm;
    }

    @NonNull
    @Override
    public WordCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        WordCardHolder viewHolder = new WordCardHolder(view);
        viewHolder.callback = this;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordCardHolder holder, final int position) {
        WordCardItemViewModel currentCard = vm.getCardList().get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return vm.getCardList().size();
    }

    @Override
    public void showConfirmationButtons(WordCardItemViewModel vm) {
        for (WordCardItemViewModel cardVm : this.vm.getCardList()) {
            cardVm.isSelected = false;
        }

        vm.isSelected = true;

        notifyDataSetChanged();
    }

    @Override
    public void hideConfirmationButtons(WordCardItemViewModel vm) {
        vm.isSelected = false;
        notifyDataSetChanged();
    }

    @Override
    public void confirmSelection(WordCardItemViewModel vm) {
        if (handler == null) {
            return;
        }

        handler.selectWordCard(vm);
    }
}
