package com.example.make_a_story_prototype.main.Characters.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Characters.model.CharacterCardItem;
import com.example.make_a_story_prototype.main.Characters.model.Characters;
import com.example.make_a_story_prototype.main.Characters.view.ImageCards.CharacterImagesRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Characters.view.NameCards.CharacterNamesRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterActivity extends AppCompatActivity {
    private RecyclerView nameRecyclerView;
    private RecyclerView imageRecyclerView;
    private RecyclerView.Adapter namesRecyclerViewAdapter;
    private RecyclerView.Adapter imagesRecyclerViewAdapter;
    private CharacterScreenViewModel viewModel;

    private View confirmationDialog;

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

        viewModel = new CharacterScreenViewModel(this, new Characters());
        initNameRecyclerView();
        initImageRecyclerView();

        confirmationDialog = findViewById(R.id.confirmation_dialog);
        findViewById(R.id.confirm_button).setOnClickListener(button -> {
            viewModel.confirmCharacter();
        });
        findViewById(R.id.cancel_button).setOnClickListener(button -> {
            viewModel.cancelConfirmingCharacter();
        });

        // TODO: setup onclicks and such for confirmation dialog
        viewModel.selectedCharacter().subscribe(wrappedCharacter -> {
            CharacterCardItem character = wrappedCharacter.getValue();
            if (character == null) {
                confirmationDialog.setVisibility(View.GONE);
                return;
            }

            // TODO: configure image and labels
            TextView selectedName = confirmationDialog.findViewById(R.id.name_selected).findViewById(R.id.character_name);
            selectedName.setText(character.getImageLabel());
            View nameCard = confirmationDialog.findViewById(R.id.name_selected);
            View imageCard = confirmationDialog.findViewById(R.id.image_selected);


            Drawable nameBackground = nameCard.findViewById(R.id.parent_layout).getBackground();
            Util.changeDrawableColor(nameBackground, Color.parseColor("#FFEBEE"));

            ImageView selectedImage = confirmationDialog.findViewById(R.id.image_selected).findViewById(R.id.characterImage);
            selectedImage.setImageResource(character.getImageResource());

            Drawable imageBackground = imageCard.findViewById(R.id.parent_layout).getBackground();
            Util.changeDrawableColor(imageBackground, Color.parseColor("#E2F5FD"));
            confirmationDialog.setVisibility(View.VISIBLE);
        });
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
        namesRecyclerViewAdapter = new CharacterNamesRecyclerViewAdapter(viewModel);
        nameRecyclerView.setAdapter(namesRecyclerViewAdapter);
        nameRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void initImageRecyclerView() {
        imageRecyclerView = findViewById(R.id.character_image_recycler_view);
        imageRecyclerView.setHasFixedSize(true);
        imagesRecyclerViewAdapter = new CharacterImagesRecyclerViewAdapter(viewModel);
        imageRecyclerView.setAdapter(imagesRecyclerViewAdapter);
        imageRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }
}
