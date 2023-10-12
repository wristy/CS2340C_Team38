package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;

import com.example.cs2340c_team38.databinding.ActivityGameDisplay2Binding;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel2;


public class GameDisplayActivity2 extends AppCompatActivity {

    private GameDisplayViewModel2 viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplay2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_game_display2);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel2.class);
        binding.setViewModel(viewModel);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);

        viewModel.getEndEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity2.this, EndActivity.class);
            startActivity(intent);
        });

        viewModel.getContinueEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity2.this, GameDisplayActivity3.class);
            intent.putExtra("PLAYER_NAME", viewModel.getPlayerName());
            intent.putExtra("DIFFICULTY", difficulty);
            intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
            startActivity(intent);
        });
    }
}