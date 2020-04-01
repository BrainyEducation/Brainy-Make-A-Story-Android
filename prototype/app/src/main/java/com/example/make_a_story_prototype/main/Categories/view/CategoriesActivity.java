package com.example.make_a_story_prototype.main.Categories.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Categories.model.CategoryCardItem;
import com.example.make_a_story_prototype.main.Categories.vm.CategoriesViewModel;
import com.example.make_a_story_prototype.main.Categories.vm.CategoryCardItemViewModel;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesActivity extends AppCompatActivity implements CategoryItemRecyclerViewAdapter.CategoryAdapterHandler {
    private RecyclerView.LayoutManager rvLayoutManager;
    private CategoriesViewModel viewModel;
    private String source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        source = getIntent().getStringExtra("source");

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText("Categories");

        viewModel = new CategoriesViewModel(this);
        initRecyclerView();
    }

    // storybook icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.storybook_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.finish();
                return true;
            case R.id.storybook:
                Toast.makeText(this, "Todo: storybook button", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter recyclerViewAdapter =
                new CategoryItemRecyclerViewAdapter(this, viewModel);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ((CategoryItemRecyclerViewAdapter) recyclerViewAdapter).handler = this;
    }

    @Override
    public void selectCategoryCard(CategoryCardItemViewModel vm) {
        CategoryCardItem item = vm.cardItem;

        Intent intent = new Intent(this, WordbankActivity.class);
        intent.putExtra("category", item.getImageLabel().replaceAll(" ", ""));
        Log.d("tag", "selectCategoryCard intent extra category: " + item.getImageLabel());
        intent.putExtra("source", source);
        this.startActivity(intent);
        
    }

}
