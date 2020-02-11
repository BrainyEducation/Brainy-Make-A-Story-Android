package com.example.make_a_story_prototype.main.Characters.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.view.ImageCards.CharacterImagesRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Characters.view.NameCards.CharacterNamesRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterViewModel;
import com.example.make_a_story_prototype.main.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterActivity extends AppCompatActivity {
    private RecyclerView nameRecyclerView;
    private RecyclerView imageRecyclerView;
    private RecyclerView.Adapter namesRecyclerViewAdapter;
    private RecyclerView.Adapter imagesRecyclerViewAdapter;
    private CharacterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Friends");

        viewModel = new CharacterViewModel(this);
        initNameRecyclerView();
        initImageRecyclerView();
    }

    // storybook icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.icon_menu, menu);
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

    private void initNameRecyclerView() {
        nameRecyclerView = findViewById(R.id.character_name_recycler_view);
        nameRecyclerView.setHasFixedSize(true);
        namesRecyclerViewAdapter = new CharacterNamesRecyclerViewAdapter(this, viewModel);
        nameRecyclerView.setAdapter(namesRecyclerViewAdapter);
        nameRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void initImageRecyclerView() {
        imageRecyclerView = findViewById(R.id.character_image_recycler_view);
        imageRecyclerView.setHasFixedSize(true);
        imagesRecyclerViewAdapter = new CharacterImagesRecyclerViewAdapter(this, viewModel);
        imageRecyclerView.setAdapter(imagesRecyclerViewAdapter);
        imageRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }
}
