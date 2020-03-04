package com.example.make_a_story_prototype.main.Wordbank.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Quiz.view.QuizActivity;
import com.example.make_a_story_prototype.main.StoryTemplate.view.StoryTemplateActivity;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.make_a_story_prototype.main.StoryTemplate.view.StoryTemplateActivity.BlankSelectionIntentKey;

public class WordbankActivity extends AppCompatActivity implements WordbankItemRecyclerViewAdapter.WordbankAdapterHandler {
    private String category;
    private RecyclerView recyclerView;
    private WordbankItemRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private WordbankViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        String category = getIntent().getStringExtra("source");

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(category);

        viewModel = WordbankViewModel.instance(this);
        viewModel.setCategory(category);

        initRecyclerView();

        viewModel.getCardListObservable().subscribe((list) -> {
            recyclerViewAdapter = new WordbankItemRecyclerViewAdapter(this, viewModel);
            recyclerViewAdapter.handler = this;

            recyclerView.setAdapter(recyclerViewAdapter);
        });
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
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void selectWordCard(WordCardItemViewModel vm) {
        if (vm.isUnlocked) {
            Intent intent = new Intent(this, StoryTemplateActivity.class);
            intent.putExtra(BlankSelectionIntentKey,  new StoryViewModel.BlankSelection(
                    vm.cardItem.getImageLabel(),
                    vm.cardItem.getImageResource()
            ));

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("source", vm.cardItem.getImageLabel());
            intent.putExtra("audio", vm.cardItem.getAudioResource());
            intent.putExtra("image", vm.cardItem.getImageResource());
            this.startActivity(intent);
        }
    }
}

