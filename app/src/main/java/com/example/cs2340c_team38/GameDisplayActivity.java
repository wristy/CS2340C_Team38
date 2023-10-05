package com.example.cs2340c_team38;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.databinding.ActivityGameDisplayBinding;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel;


public class GameDisplayActivity extends AppCompatActivity {

    private GameDisplayViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game_display);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel.class);
        binding.setViewModel(viewModel);
        binding.setBindingAdapters(new BindingAdapters());

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        int character;
        switch (characterSpriteId) {
            case 1:
                character = R.drawable.character1;
                break;
            case 2:
                character = R.drawable.character2;
                break;
            default:
                character = R.drawable.character3;
                break;
        }
        viewModel.setCharacterSpriteId(character);

        binding.exitButton.setOnClickListener(view -> {
            Intent intent = new Intent(GameDisplayActivity.this, EndActivity.class);
            startActivity(intent);
        });
    }
}