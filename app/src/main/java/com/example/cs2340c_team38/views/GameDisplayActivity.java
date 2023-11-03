package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityGameDisplayBinding;
import com.example.cs2340c_team38.model.Enemy;
import com.example.cs2340c_team38.model.EnemyFactory;
import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveLeft;
import com.example.cs2340c_team38.model.MoveRight;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Observable;
import com.example.cs2340c_team38.model.Observer;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel;

import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Space;
import android.widget.TextView;

public class GameDisplayActivity extends AppCompatActivity implements Observer {

    private GameDisplayViewModel viewModel;
    private String playerName;
    private int difficulty;
    private int characterSpriteId;
    private int[] currScore;

    // Add as member variables in the GameDisplayActivity class
    private Enemy slime1;
    private Enemy slime2;

    private Handler enemyMoveHandler = new Handler();
    private Runnable enemyMoveRunnable;

    // Patrol directions for the slimes (true for right, false for left)
    private boolean slime1Direction = true;
    private boolean slime2Direction = true;

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

        playerName = getIntent().getStringExtra("PLAYER_NAME");
        difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);

        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);

        viewModel.getEndEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity.this, EndActivity.class);
            startActivity(intent);
        });
        TextView scoreText = findViewById(R.id.textView6);
        currScore = new int[]{5000};
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

        // Movements for player

        int startY = 18; // player starting
        int startX = 5;

        GridLayout gridLayout = findViewById(R.id.gameGrid);

        for (int x = 0; x < gridLayout.getColumnCount(); x++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(0, 1, 1);
            params.columnSpec = GridLayout.spec(x, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            gridLayout.addView(new Space(this), params);
        }
        for (int y = 0; y < gridLayout.getRowCount(); y++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(y, 1, 1);
            params.columnSpec = GridLayout.spec(0, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            gridLayout.addView(new Space(this), params);
        }



        Player player = Player.getPlayer();
        setPlayerHealth(difficulty, player);
        updateHealthText(player);



        player.addObserver(this);
        player.setPosition(startX, startY);
        player.setCurrentTile(tileMap[startY][startX]);
        moveViewToPosition(findViewById(R.id.imageView), startY, startX);

        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(v -> {

            player.setMoveStrategy(new MoveUp());
            player.move(tileMap);
        });

        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveDown());
            player.move(tileMap);
        });

        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveLeft());
            player.move(tileMap);
        });

        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveRight());
            player.move(tileMap);
        });

        // Enemy creation and setting

        setupEnemies(player);
        player.addObserver(slime1);
        player.addObserver(slime2);

        // Initialize the enemy patrol movement
        startEnemyPatrol(player);


    }

    public void update(Observable o, String type, int x, int y) {
        if (type.equals("Player")) {
            moveViewToPosition(findViewById(R.id.imageView), y, x);
            // Check if the player is on the EXIT tile
            if (tileMap[y][x] == TileType.EXIT) {
                Intent intent = new Intent(GameDisplayActivity.this, GameDisplayActivity2.class);
                intent.putExtra("PLAYER_NAME", playerName);
                intent.putExtra("DIFFICULTY", difficulty);
                intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
                intent.putExtra("currentScore", currScore[0]);
                startActivity(intent);
            }
        } else if (type.equals("Slime1")) {
            moveViewToPosition(findViewById(R.id.slime1), y, x);
        } else if (type.equals("Slime2")) {
            moveViewToPosition(findViewById(R.id.slime2), y, x);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Player.getPlayer().removeObserver(this); // Unregister the activity when it's destroyed
    }


    private void moveViewToPosition(View view, int newRow, int newColumn) {
        // Get the current layout parameters of the view
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) view.getLayoutParams();

        // Update the position
        params.rowSpec = GridLayout.spec(newRow);
        params.columnSpec = GridLayout.spec(newColumn);

        // Apply the updated layout parameters
        view.setLayoutParams(params);

        // Request the parent GridLayout to re-layout its children
        view.getParent().requestLayout();
    }

    private void setupEnemies(Player player) {
        EnemyFactory enemyFactory = new EnemyFactory();
        try {
            // Instantiate your enemies
            slime1 = enemyFactory.createEnemy("Slime");
            slime2 = enemyFactory.createEnemy("Alien");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Set initial positions for the enemies
        slime1.setPosition(2, 3, tileMap);
        slime2.setPosition(5, 11, tileMap);
        slime1.setPlayer(player);
        slime2.setPlayer(player);

    }


    private void startEnemyPatrol(Player player) {
        enemyMoveRunnable = new Runnable() {
            @Override
            public void run() {
                patrol(slime1, 2, 9, slime1Direction, player); // Assume patrol between columns 2 and 6
                patrol(slime2, 3, 8, slime2Direction, player); // Assume patrol between columns 5 and 9


                // Schedule the next run
                enemyMoveHandler.postDelayed(this, 1000); // move every second
            }
        };
        enemyMoveHandler.postDelayed(enemyMoveRunnable, 1000);
    }

    private void patrol(Enemy slime, int startColumn, int endColumn, boolean direction, Player player) {
        // Check the current position and move the slime accordingly
        int currentColumn = slime.getX();
        if (direction && currentColumn < endColumn) {
            if (slime == slime1) {
                slime.setPosition(currentColumn + 2, slime.getY(), tileMap);
            } else {
                slime.setPosition(currentColumn + 1, slime.getY(), tileMap);
            }
        } else if (!direction && currentColumn > startColumn) {
            if (slime == slime1) {
                slime.setPosition(currentColumn - 2, slime.getY(), tileMap);
            } else {
                slime.setPosition(currentColumn - 1, slime.getY(), tileMap);
            }
        } else {
            // Change direction if we've hit the end or start
            if (slime == slime1) slime1Direction = !slime1Direction;
            if (slime == slime2) slime2Direction = !slime2Direction;
            patrol(slime, startColumn, endColumn, !direction, player);
        }

        if (slime == slime1) {
            update(null, "Slime1", slime.getX(), slime.getY());
        } else if (slime == slime2) {
            update(null,"Slime2", slime.getX(), slime.getY());
        }

        slime.onCollisionWithPlayer();
        updateHealthText(player);

    }

    private void setPlayerHealth(int difficulty, Player player) {

        if (difficulty == 0) {
            player.setHealth(150);
            player.setDamage(10);
        } else if (difficulty == 1) {
            player.setHealth(100);
            player.setDamage(15);
        } else if (difficulty == 2) {
            player.setHealth(80);
            player.setDamage(20);
        }
    }

    private void updateHealthText(Player player) {
        TextView health = findViewById(R.id.healthText);
        health.setText(String.valueOf(player.getHealth()));
        if (player.getHealth() <= 0) {
            launchGameOver();
        }
    }

    private void launchGameOver() {
        Intent intent = new Intent(GameDisplayActivity.this, GameDisplayActivity2.class);
        intent.putExtra("PLAYER_NAME", playerName);
        intent.putExtra("DIFFICULTY", difficulty);
        intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
        intent.putExtra("currentScore", currScore[0]);
        startActivity(intent);
    }




}




