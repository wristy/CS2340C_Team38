package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityGameDisplay3Binding;
import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveLeft;
import com.example.cs2340c_team38.model.MoveRight;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel3;


public class GameDisplayActivity3 extends AppCompatActivity {

    private GameDisplayViewModel3 viewModel;

    // TODO: Update this for map 3
    private final TileType[][] tileMap = {{TileType.GRASS, TileType.GRASS, TileType.GRASS,
            TileType.GRASS, TileType.WALL, TileType.EXIT, TileType.EXIT, TileType.WALL,
            TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
            {TileType.WALL, TileType.WALL, TileType.WALL, TileType.GRASS, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.GRASS, TileType.WALL,
                    TileType.WALL, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.LAVA, TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.LAVA,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
                    TileType.LAVA, TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.LAVA,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.WALL, TileType.WALL, TileType.GRASS, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.GRASS, TileType.WALL,
                    TileType.WALL, TileType.WALL},
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.GRASS, TileType.GRASS,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.WALL, TileType.FLOOR, TileType.LAVA,
                    TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.GRASS},
            {TileType.GRASS, TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.WALL, TileType.GRASS},
            {TileType.GRASS, TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.LAVA, TileType.FLOOR,
                    TileType.WALL, TileType.GRASS},
            {TileType.GRASS, TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.WALL, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.GRASS, TileType.GRASS,
                    TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WALL,
                    TileType.ENTRANCE, TileType.ENTRANCE, TileType.WALL, TileType.GRASS,
                    TileType.GRASS, TileType.GRASS, TileType.GRASS}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplay3Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_game_display3);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel3.class);
        binding.setViewModel(viewModel);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);
        int currScore = getIntent().getIntExtra("currentScore", 100);
        TextView scoreText = findViewById(R.id.textView6);
        scoreText.setText("Score: " + currScore);
        int[] currScore3 = {currScore};
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (currScore3[0] != 0) {
                    currScore3[0] = currScore3[0] - 1;
                    scoreText.setText("Score: " + currScore3[0]);
                }
                h.postDelayed(this, 1000);
            }
        };
        h.postDelayed(r, 1000);
        viewModel.getEndEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity3.this, EndActivity.class);
            intent.putExtra("finalScore", currScore3[0]);
            intent.putExtra("currName", playerName);
            startActivity(intent);
        });

        // Movements

        int startY = 18;
        int startX = 5;

        Player player = Player.getPlayer();
        player.setPosition(startX, startY);
        player.setCurrentTile(tileMap[startY][startX]);


        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveUp());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity3.this, String.format("X: %d, Y: %d",
                            player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveDown());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity3.this, String.format("X: %d, Y: %d",
                            player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveLeft());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity3.this, String.format("X: %d, Y: %d",
                            player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveRight());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity3.this, String.format("X: %d, Y: %d",
                            player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });
    }
}