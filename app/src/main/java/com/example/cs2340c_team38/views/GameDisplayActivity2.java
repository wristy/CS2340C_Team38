package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;

import com.example.cs2340c_team38.databinding.ActivityGameDisplay2Binding;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel2;


public class GameDisplayActivity2 extends AppCompatActivity {

    private GameDisplayViewModel2 viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplay2Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_game_display2);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel2.class);
        binding.setViewModel(viewModel);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);
        int currScore = getIntent().getIntExtra("currentScore", 100);
        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);
        TextView scoreText = findViewById(R.id.textView6);
        scoreText.setText("Score: " + currScore);
        int[] currScore2 = {currScore};
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (currScore2[0] != 0) {
                    currScore2[0] = currScore2[0] - 1;
                    scoreText.setText("Score: " + currScore2[0]);
                }
                h.postDelayed(this, 1000);
            }
        };
        h.postDelayed(r, 1000);
        viewModel.getEndEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity2.this, EndActivity.class);
            startActivity(intent);
        });

        viewModel.getContinueEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity2.this, GameDisplayActivity3.class);
            intent.putExtra("PLAYER_NAME", viewModel.getPlayerName());
            intent.putExtra("DIFFICULTY", difficulty);
            intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
            intent.putExtra("currentScore", currScore2[0]);
            startActivity(intent);
        });
    }
}