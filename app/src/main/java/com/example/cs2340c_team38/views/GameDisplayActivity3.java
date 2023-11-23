package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityGameDisplay3Binding;
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
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel3;


public class GameDisplayActivity3 extends AppCompatActivity implements Observer {

    private final TileType[][] tileMap = {{TileType.GRASS, TileType.GRASS, TileType.GRASS,
            TileType.WALL, TileType.WALL, TileType.EXIT, TileType.EXIT, TileType.WALL,
            TileType.WALL, TileType.GRASS, TileType.GRASS, TileType.GRASS},
        {TileType.GRASS, TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.WALL, TileType.WALL, TileType.GRASS},
        {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
            TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.WALL},
        {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.WALL},
        {TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.WALL,
            TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.LAVA, TileType.LAVA, TileType.LAVA, TileType.LAVA,
            TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.WALL},
        {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.WALL,
            TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.LAVA, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL},
        {TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
            TileType.LAVA, TileType.WALL, TileType.WALL, TileType.LAVA,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.LAVA,
            TileType.LAVA, TileType.WALL, TileType.WALL, TileType.LAVA,
            TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS,
            TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.LAVA, TileType.LAVA, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
        {TileType.GRASS, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.GRASS},
        {TileType.GRASS, TileType.GRASS, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.ENTRANCE, TileType.ENTRANCE, TileType.WALL,
            TileType.WALL, TileType.WALL, TileType.GRASS, TileType.GRASS}};

    private final TileType[][] tileMap2 = {{TileType.FLOOR, TileType.LAVA, TileType.GRASS,
            TileType.WALL, TileType.WALL, TileType.EXIT, TileType.EXIT, TileType.WALL,
            TileType.WALL, TileType.GRASS, TileType.GRASS, TileType.FLOOR},
            {TileType.GRASS, TileType.WALL, TileType.GRASS, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.WALL, TileType.WALL, TileType.GRASS},
            {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
                    TileType.GRASS, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL},
            {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.WALL},
            {TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.FLOOR,
                    TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.WALL,
                    TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.LAVA, TileType.LAVA, TileType.GRASS, TileType.LAVA,
                    TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.WALL},
            {TileType.WALL, TileType.LAVA, TileType.FLOOR, TileType.WALL,
                    TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
                    TileType.FLOOR, TileType.LAVA, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.WALL, TileType.WALL, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL},
            {TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
                    TileType.LAVA, TileType.WALL, TileType.WALL, TileType.LAVA,
                    TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.LAVA,
                    TileType.LAVA, TileType.WALL, TileType.WALL, TileType.LAVA,
                    TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.WALL, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.GRASS, TileType.GRASS, TileType.LAVA, TileType.GRASS,
                    TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
                    TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.LAVA, TileType.LAVA, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL},
            {TileType.GRASS, TileType.WALL, TileType.WALL, TileType.FLOOR,
                    TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
                    TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.LAVA},
            {TileType.LAVA, TileType.GRASS, TileType.WALL, TileType.WALL,
                    TileType.WALL, TileType.ENTRANCE, TileType.ENTRANCE, TileType.WALL,
                    TileType.WALL, TileType.WALL, TileType.GRASS, TileType.WALL}};
    private String playerName;
    private int difficulty;
    private int characterSpriteId;
    private int currScore;
    private int[] currScore3;
    private Enemy slime1;
    private Enemy slime2;

    private Handler enemyMoveHandler = new Handler();
    private Runnable enemyMoveRunnable;

    // Patrol directions for the slimes (true for right, false for left)
    private boolean slime1Direction = true;
    private boolean slime2Direction = true;
    private GameDisplayViewModel3 viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplay3Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_game_display3);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel3.class);
        binding.setViewModel(viewModel);

        playerName = getIntent().getStringExtra("PLAYER_NAME");
        difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);
        currScore = getIntent().getIntExtra("currentScore", 100);
        TextView scoreText = findViewById(R.id.textView6);
        scoreText.setText("Score: " + currScore);
        currScore3 = new int[]{currScore};
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
            finish();
            Player.getPlayer().removeObserver(this); // Unregister the activity when it's destroyed
            Player.getPlayer().removeObserver(slime1);
            Player.getPlayer().removeObserver(slime2);
            startActivity(intent);
        });

        // Movements

        int startY = 18;
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
        player.addObserver(this);
        player.setPosition(startX, startY);
        player.setCurrentTile(tileMap2[startY][startX]);
        moveViewToPosition(findViewById(R.id.imageView), startY, startX);

        setupEnemies(player);
        startEnemyPatrol(player);


        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveUp());
            player.move(tileMap2);
        });

        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveDown());
            player.move(tileMap2);
        });

        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveLeft());
            player.move(tileMap2);
        });

        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            player.setMoveStrategy(new MoveRight());
            player.move(tileMap2);
        });
    }

    @Override
    public void update(Observable o, String type, int x, int y) {
        if (type.equals("Player")) {
            moveViewToPosition(findViewById(R.id.imageView), y, x);
            // Check if the player is on the EXIT tile
            if (tileMap2[y][x] == TileType.EXIT) {
                Intent intent = new Intent(GameDisplayActivity3.this, EndActivity.class);
                intent.putExtra("PLAYER_NAME", playerName);
                intent.putExtra("DIFFICULTY", difficulty);
                intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
                intent.putExtra("currentScore", currScore3[0]);
                finish();
                Player.getPlayer().removeObserver(this); // Unregister the activity when it's destroyed
                Player.getPlayer().removeObserver(slime1);
                Player.getPlayer().removeObserver(slime2);
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
        Player.getPlayer().removeObserver(slime1);
        Player.getPlayer().removeObserver(slime2);
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
        slime1.setPosition(3, 1, tileMap2);
        slime2.setPosition(0, 9, tileMap2);
        slime1.setPlayer(player);
        slime2.setPlayer(player);
        player.addObserver(slime1);
        player.addObserver(slime2);

    }


    private void startEnemyPatrol(Player player) {
        enemyMoveRunnable = new Runnable() {
            @Override
            public void run() {
                patrol(slime1, 3, 8, slime1Direction, player); // Assume patrol between columns 2 and 6
                patrol(slime2, 3, 10, slime2Direction, player); // Assume patrol between columns 5 and 9


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
                slime.setPosition(currentColumn + 1, slime.getY(), tileMap2);
            } else {
                slime.setPosition(currentColumn + 2, slime.getY(), tileMap2);
            }
        } else if (!direction && currentColumn > startColumn) {
            if (slime == slime1) {
                slime.setPosition(currentColumn - 1, slime.getY(), tileMap2);
            } else {
                slime.setPosition(currentColumn - 2, slime.getY(), tileMap2);
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
        if (player.getHealth() <= 0 && player.isAlive()) {
            player.setAlive(false);
            launchGameOver();
        }
    }

    private void launchGameOver() {
        Intent intent = new Intent(GameDisplayActivity3.this, GameOverActivity.class);
        intent.putExtra("PLAYER_NAME", playerName);
        intent.putExtra("DIFFICULTY", difficulty);
        intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
        currScore3[0] = 0;
        intent.putExtra("currentScore", currScore3[0]);
        Player.getPlayer().removeObserver(this); // Unregister the activity when it's destroyed
        Player.getPlayer().removeObserver(slime1);
        Player.getPlayer().removeObserver(slime2);
        finish();
        startActivity(intent);
    }
}