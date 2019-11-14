package com.example.make_a_story_prototype.main.view.wordbank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.model.WordCardItem;
import com.example.make_a_story_prototype.main.view.quiz.QuizActivity;
import com.example.make_a_story_prototype.main.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.vm.WordbankViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class WordbankItemRecyclerViewAdapter extends RecyclerView.Adapter<WordCardHolder> implements WordCardHolder.WordCardCallback {
    private Context context;
    private WordbankViewModel vm;

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
    public void onClick(WordCardItemViewModel vm) {
        if (vm.isUnlocked) {
            Toast.makeText(context, vm.cardItem.getImageLabel() + " is already unlocked", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, QuizActivity.class);
            intent.putExtra("source", vm.cardItem.getImageLabel());
            context.startActivity(intent);
        }
    }
}
