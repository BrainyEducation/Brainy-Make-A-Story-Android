package com.example.make_a_story_prototype.main.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<CardItem> cardList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<CardItem> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        int backgroundColors[] = {
                ContextCompat.getColor(context, R.color.colorLightRed),
                ContextCompat.getColor(context, R.color.colorLightOrange),
                ContextCompat.getColor(context, R.color.colorLightGreen),
                ContextCompat.getColor(context, R.color.colorLightPurple),
                ContextCompat.getColor(context, R.color.colorLightBlue),
        };

        int detailColors[] = {
                ContextCompat.getColor(context, R.color.colorContrastRed),
                ContextCompat.getColor(context, R.color.colorContrastOrange),
                ContextCompat.getColor(context, R.color.colorContrastGreen),
                ContextCompat.getColor(context, R.color.colorContrastPurple),
                ContextCompat.getColor(context, R.color.colorContrastBlue),
        };


        CardItem currentCard = cardList.get(position);
        holder.category.setImageResource(currentCard.getImageResource());
        holder.categoryName.setText(currentCard.getImageLabel());
        holder.categoryName.setTextColor(detailColors[position % detailColors.length]);
        holder.itemView.setBackgroundColor(backgroundColors[position % backgroundColors.length]);


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + cardList.get(position));
                Toast.makeText(context, cardList.get(position).getImageLabel(), Toast.LENGTH_SHORT).show();
                openWordBankActivity();
            }
        });
    }

    // need to fix
    private void openWordBankActivity() {
        Intent intent = new Intent(context, QuizActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView category;
        TextView categoryName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.category = itemView.findViewById(R.id.categoryImage);
            this.categoryName = itemView.findViewById(R.id.categoryText);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
