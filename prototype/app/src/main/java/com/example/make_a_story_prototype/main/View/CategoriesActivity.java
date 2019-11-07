package com.example.make_a_story_prototype.main.View;

import android.os.Bundle;
import android.util.Log;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesActivity extends AppCompatActivity {

    private static final String TAG = "CategoriesActivity";

    //fields
    private ArrayList<String> categoryNames = new ArrayList<>();
    private ArrayList<String> categoryImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");
        categoryImages.add("https://i.imgur.com/EEHhpyt.png");
        categoryNames.add("Food");

        categoryImages.add("https://i.imgur.com/EEHhpyt.png");
        categoryNames.add("Food");

        categoryImages.add("https://i.imgur.com/EEHhpyt.png");
        categoryNames.add("Food");

        categoryImages.add("https://i.imgur.com/EEHhpyt.png");
        categoryNames.add("Food");

        categoryImages.add("https://i.imgur.com/EEHhpyt.png");
        categoryNames.add("Food");


        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(categoryNames, categoryImages, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
