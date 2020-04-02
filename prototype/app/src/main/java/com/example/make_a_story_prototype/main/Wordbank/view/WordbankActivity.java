package com.example.make_a_story_prototype.main.Wordbank.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Home.vm.StoryBlankSelectionContext;
import com.example.make_a_story_prototype.main.Navigation.NavigationController;
import com.example.make_a_story_prototype.main.Quiz.view.QuizActivity;
import com.example.make_a_story_prototype.main.StoryTemplate.view.StoryTemplateActivity;
import com.example.make_a_story_prototype.main.Util.BaseActivity;
import com.example.make_a_story_prototype.main.Util.Util;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordbankViewModel;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.DebugStoryTemplateSelectionsRepository;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WordbankActivity extends BaseActivity implements WordbankItemRecyclerViewAdapter.WordbankAdapterHandler {
    private static String MY_VM_KEY = WordbankActivity.class.getName() + ":VM_KEY";

    private RecyclerView recyclerView;
    private WordbankItemRecyclerViewAdapter recyclerViewAdapter;
    private WordbankViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Log.d("tag", "onCreate: VMKEY: " + MY_VM_KEY);

        if (savedInstanceState == null) {
            int categoryId = getIntent().getIntExtra("category", 0);
            vm = new WordbankViewModel(categoryId);
        } else {
            vm = savedInstanceState.getParcelable(MY_VM_KEY);
        }
        // TODO: or crash

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(vm.getCategory().blockingGet().getName());

        initRecyclerView();

        recyclerViewAdapter = new WordbankItemRecyclerViewAdapter(this, vm);
        recyclerViewAdapter.handler = this;
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putParcelable(MY_VM_KEY, vm);
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
        NavigationController.NavigationContext context = getNavigationContext();

        if (context instanceof StoryBlankSelectionContext) {
            StoryBlankSelectionContext storyBlankSelectionContext = (StoryBlankSelectionContext) context;

            if (vm.isUnlocked) {
                Log.d("TAG", "tapped unlocked word card from story");

                DebugStoryTemplateSelectionsRepository.getInstance().setSelectionForStory(
                        storyBlankSelectionContext.getStoryId(),
                        storyBlankSelectionContext.getBlankId(),
                        new BlankSelection(
                                vm.word.getWord(),
                                vm.word.getImageResource(),
                                vm.word.getAudioResource()
                        ));

                StoryTemplateActivity.start(this, storyBlankSelectionContext.getStoryId());
            } else {
                startQuiz(vm);
            }
        } else {
            if (vm.isUnlocked) {
                Log.d("tag", "tapped unlocked word card from home");
                Toast.makeText(this, "Let's review what you've learned!", Toast.LENGTH_SHORT).show();
            }
            startQuiz(vm);
        }
    }

    private void startQuiz(WordCardItemViewModel vm) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("word", vm.word.getId());
        this.startActivity(intent);
    }
}

