package com.example.make_a_story_prototype.main.Characters.view;

import android.annotation.SuppressLint;
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
import com.example.make_a_story_prototype.main.Characters.vm.CharacterScreenViewModel.CharacterViewModel;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterActivity extends AppCompatActivity {
    private RecyclerView nameRecyclerView;
    private RecyclerView imageRecyclerView;
    private RecyclerView.Adapter namesRecyclerViewAdapter;
    private RecyclerView.Adapter imagesRecyclerViewAdapter;
    private CharacterScreenViewModel viewModel;

    private View confirmationDialog;
    private View blurredBackground;

    @SuppressLint("CheckResult")
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

        blurredBackground = findViewById(R.id.blur);

        confirmationDialog = findViewById(R.id.confirmation_dialog);
        findViewById(R.id.confirm_button).setOnClickListener(button -> {
            viewModel.confirmCharacter();
        });
        findViewById(R.id.cancel_button).setOnClickListener(button -> {
            viewModel.cancelConfirmingCharacter();
        });

        // TODO: setup onclicks and such for confirmation dialog
        viewModel.selectedCharacter().subscribe(wrappedCharacter -> {
            CharacterViewModel character = wrappedCharacter.getValue();
            if (character == null) {
                confirmationDialog.setVisibility(View.GONE);
                blurredBackground.setVisibility(View.GONE);
                return;
            }

            // TODO: reconfigure
            TextView selectedName = confirmationDialog.findViewById(R.id.name_selected).findViewById(R.id.character_name);
            selectedName.setText(character.name);
            selectedName.setTextColor(character.nameContrastColor);

            CardView nameCard = confirmationDialog.findViewById(R.id.name_selected).findViewById(R.id.card_view);
            CardView imageCard = confirmationDialog.findViewById(R.id.image_selected).findViewById(R.id.card_view);

            ImageView selectedImage = confirmationDialog.findViewById(R.id.image_selected).findViewById(R.id.characterImage);
            selectedImage.setImageResource(character.image);

            Drawable imageBackground = imageCard.findViewById(R.id.parent_layout).getBackground();
            Util.changeDrawableColor(imageBackground, character.imageBackgroundColor);

            Drawable nameBackground = nameCard.findViewById(R.id.parent_layout).getBackground();
            Util.changeDrawableColor(nameBackground, character.nameBackgroundColor);

            ImageView speakerIcon = nameCard.findViewById(R.id.speaker_icon);

            Drawable speakerDrawable = DrawableCompat.wrap(speakerIcon.getDrawable());
            Util.changeDrawableColor(speakerDrawable, character.nameContrastColor);

            Drawable nameBorder = nameCard.getBackground();
            Util.changeDrawableColor(nameBorder, character.nameContrastColor);
            nameCard.setRadius(23);

            Drawable imageBorder = imageCard.getBackground();
            Util.changeDrawableColor(imageBorder, character.imageContrastColor);
            imageCard.setRadius(23);

            blurredBackground.setVisibility(View.VISIBLE);
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
