package com.example.make_a_story_prototype.main.views;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.view.CategoryItemRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
* Class for Home page activities, including redirection to word bank and story screen.
*/
public class HomePage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private CategoriesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    /**
     * goes to the word bank screen
     * @param v view
     */
    public void wordBankButtonOnClick(View v) {
        setContentView(R.layout.activity_categories);
        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this);
        Util.addBackArrow(this);

        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText("Categories");

        viewModel = new CategoriesViewModel(this);
        initRecyclerView();
    }

    /**
     * goes to the story page screen
     * @param v view
     */
    public void storyPageButtonOnClick(View v) {
        Toast.makeText(this, "Todo: story page button", Toast.LENGTH_SHORT).show();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new CategoryItemRecyclerViewAdapter(this, viewModel);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

}
