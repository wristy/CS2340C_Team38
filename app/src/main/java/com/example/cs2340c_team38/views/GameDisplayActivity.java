package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityGameDisplayBinding;
import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveLeft;
import com.example.cs2340c_team38.model.MoveRight;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel;

import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameDisplayActivity extends AppCompatActivity {

    private GameDisplayViewModel viewModel;

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

        ActivityGameDisplayBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_game_display);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel.class);
        binding.setViewModel(viewModel);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);

        viewModel.getEndEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity.this, EndActivity.class);
            startActivity(intent);
        });
        TextView scoreText = findViewById(R.id.textView6);
        int[] currScore = {5000};
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (currScore[0] != 0) {
                    currScore[0] = currScore[0] - 1;
                    scoreText.setText("Score: " + currScore[0]);
                }
                h.postDelayed(this, 1000);
            }
        };

        h.postDelayed(r, 1000);
        viewModel.getContinueEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity.this, GameDisplayActivity2.class);
            intent.putExtra("PLAYER_NAME", viewModel.getPlayerName());
            intent.putExtra("DIFFICULTY", difficulty);
            intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
            intent.putExtra("currentScore", currScore[0]);
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
            Toast.makeText(GameDisplayActivity.this, String.format("X: %d, Y: %d", player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveDown());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity.this, String.format("X: %d, Y: %d", player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveLeft());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity.this, String.format("X: %d, Y: %d", player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });

        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveRight());
            player.move(tileMap);
            Toast.makeText(GameDisplayActivity.this, String.format("X: %d, Y: %d", player.getX(), player.getY()),
                    Toast.LENGTH_SHORT).show();
        });



    }


    public void movePlayer(String direction) {
        Player player = Player.getPlayer();

        int newX = player.getX();
        int newY = player.getY();

        switch (direction) {
        case "UP":
            newY--;
            break;
        case "DOWN":
            newY++;
            break;
        case "LEFT":
            newX--;
            break;
        case "RIGHT":
            newX++;
            break;
        default:
            newY++;
            break;
        }

        if (isInBounds(newX, newY) && tileMap[newY][newX].isWalkable()) {
            player.setPosition(newX, newY);
            player.setCurrentTile(tileMap[newY][newX]);
        }
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < tileMap[0].length && y >= 0 && y < tileMap.length;
    }
}