package com.example.make_a_story_prototype.main.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.make_a_story_prototype.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> categoryNames = new ArrayList<>();
    private ArrayList<String> categoryImages = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> categoryNames, ArrayList<String> categoryImages, Context context) {
        this.categoryNames = categoryNames;
        this.categoryImages = categoryImages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(context)
                .asBitmap()
                .load(categoryImages.get(position))
                .into(holder.category);

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


        holder.categoryName.setTextColor(detailColors[position % detailColors.length]);
        holder.itemView.setBackgroundColor(backgroundColors[position % backgroundColors.length]);
        holder.categoryName.setText(categoryNames.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + categoryNames.get(position));
                Toast.makeText(context, categoryNames.get(position), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView category;
        TextView categoryName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            category = itemView.findViewById(R.id.categoryView);
            categoryName = itemView.findViewById(R.id.category_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}