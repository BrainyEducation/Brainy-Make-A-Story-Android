package com.example.make_a_story_prototype.main.Wordbank.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Media.AudioPlayer;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordbankItemRecyclerViewAdapter extends RecyclerView.Adapter<WordCardHolder> implements WordCardHolder.WordCardCallback {

    public interface WordbankAdapterHandler {
        void selectWordCard(WordCardItemViewModel vm);
    }

    private static android.media.MediaPlayer mediaPlayer = AudioPlayer.getInstance();

    private Context context;
    private WordbankViewModel vm;
    private List<WordCardItemViewModel> cardVms;

    public WordbankAdapterHandler handler;

    public WordbankItemRecyclerViewAdapter(Context context, WordbankViewModel vm) {
        this.context = context;
        this.vm = vm;
        this.cardVms = new ArrayList<>();

        vm.getCardList().subscribe(cardsVms -> {
            this.cardVms = cardsVms;
            notifyDataSetChanged();
        });
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
        WordCardItemViewModel currentCard = cardVms.get(position);
        holder.setViewModel(currentCard);
    }

    @Override
    public int getItemCount() {
        return cardVms.size();
    }

    @Override
    public void showConfirmationButtons(WordCardItemViewModel vm) {
        for (WordCardItemViewModel cardVm : cardVms) {
            cardVm.isSelected = false;
        }

        vm.isSelected = true;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            mediaPlayer = android.media.MediaPlayer.create(context, vm.word.getAudioResource());
            mediaPlayer.start();
        }
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
