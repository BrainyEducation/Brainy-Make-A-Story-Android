package com.example.make_a_story_prototype.main.StorySelection.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoryItemRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Media.AudioPlayer;
import com.example.make_a_story_prototype.main.StorySelection.vm.StoryCardViewModel;
import com.example.make_a_story_prototype.main.StorySelection.vm.StorySelectionViewModel;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class StorySelectionRecyclerViewAdapter extends RecyclerView.Adapter<StoryHolder> implements StoryHolder.StoryCardCallback {
    @Override
    public void cardTappedOn(StoryCardViewModel vm) {
        if (vm == null) {
            Log.d("recyclerViewAdapter", "cardTappedOn --> vm is null");
        }

        handler.selectStoryCard(vm);

    }

    public interface StoryAdapterHandler {
        void selectStoryCard(StoryCardViewModel vm);
    }

    public StorySelectionRecyclerViewAdapter.StoryAdapterHandler handler;

    private Context context;
    private StorySelectionViewModel vm;
    private List<StoryCardViewModel> cardVms;

        private TextView cardTitle;

        StorySelectionRecyclerViewAdapter(Context context, StorySelectionViewModel vm) {
            this.vm = vm;
            this.cardVms = vm.getCardList();
            this.context = context;
        }

        @Override
        public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_card_item, parent, false);
            StoryHolder holder = new StoryHolder(view);
            holder.callback = this;
            return holder;
        }

        @Override
        public void onBindViewHolder(StoryHolder holder, int position) {
            StoryCardViewModel currentCard = cardVms.get(position);
            int backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary);
            int textColor = ContextCompat.getColor(context, R.color.colorWhite);
            int strokeColor = ContextCompat.getColor(context, R.color.colorPrimaryDark);


            holder.setViewModel(currentCard, backgroundColor, strokeColor, textColor);

            this.vm = vm;
        }

        @Override
        public int getItemCount() {
            return cardVms.size();
        }
}