package com.example.make_a_story_prototype.main.Characters.view.NameCards;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Characters.view.NameCards.CharacterNameCardHolder.CharacterNameCallback;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel.NameCardViewModel;
import com.example.make_a_story_prototype.main.Media.AudioPlayer;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterNamesRecyclerViewAdapter extends RecyclerView.Adapter<CharacterNameCardHolder> implements CharacterNameCallback {
    private CharacterScreenViewModel vm;
    private List<NameCardViewModel> cardVms;
    private NameCardViewModel selectedCardVm;
    private Context context;
    private MediaPlayer mediaPlayer = AudioPlayer.getInstance();

    public CharacterNamesRecyclerViewAdapter(Context context, CharacterScreenViewModel vm) {
        this.vm = vm;
        this.context = context;

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

        int[] warmCardBackgroundColors = {
                ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
        };

        int[] warmCardDetailColors = {
                ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
        };

        holder.setViewModel(currentCard, warmCardDetailColors[position % warmCardDetailColors.length],
                warmCardBackgroundColors[position % warmCardBackgroundColors.length]);
    }

    @Override
    public int getItemCount() {
        return cardVms.size();
    }

    @Override
    public void nameTappedOn(NameCardViewModel vm) {

        this.vm.selectNameCard(vm);

//        for (CategoryCardItemViewModel cardVm : this.vm.getCardList()) {
//            cardVm.isSelected = false;
//        }
//
//        vm.isSelected = true;
//        notifyDataSetChanged();
//
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer = android.media.MediaPlayer.create(context, vm.name.getAudioResource());
            mediaPlayer.start();
        }

    }
}
