package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityGameDisplay2Binding;
import com.example.cs2340c_team38.model.DoublePointsDecorator;
import com.example.cs2340c_team38.model.Enemy;
import com.example.cs2340c_team38.model.EnemyFactory;
import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveLeft;
import com.example.cs2340c_team38.model.MoveRight;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Observable;
import com.example.cs2340c_team38.model.Observer;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.PlayerDecorator;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.viewmodels.GameDisplayViewModel2;


public class GameDisplayActivity2 extends AppCompatActivity implements Observer {

    private final TileType[][] tileMap = {{TileType.GRASS, TileType.GRASS, TileType.GRASS,
            TileType.GRASS, TileType.WALL, TileType.EXIT, TileType.EXIT, TileType.WALL,
            TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
        {TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.WALL},
        {TileType.WALL, TileType.LAVA, TileType.LAVA, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.LAVA,
            TileType.LAVA, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.LAVA,
            TileType.LAVA, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.LAVA, TileType.FLOOR, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.LAVA, TileType.LAVA,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.LAVA, TileType.LAVA, TileType.WALL,
            TileType.FLOOR, TileType.LAVA, TileType.WALL, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.LAVA, TileType.LAVA, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.FLOOR,
            TileType.FLOOR, TileType.FLOOR, TileType.FLOOR, TileType.LAVA, TileType.FLOOR,
            TileType.FLOOR, TileType.WALL},
        {TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.FLOOR, TileType.FLOOR, TileType.WALL, TileType.WALL, TileType.WALL,
            TileType.WALL, TileType.WALL},
        {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WALL,
            TileType.ENTRANCE, TileType.ENTRANCE, TileType.WALL, TileType.GRASS, TileType.GRASS,
            TileType.GRASS, TileType.GRASS}};
    private String playerName;
    private int difficulty;
    private int characterSpriteId;
    private int currScore;
    private int[] currScore2;
    private Enemy slime1;
    private Enemy slime2;

    private Handler enemyMoveHandler = new Handler();
    private Runnable enemyMoveRunnable;

    // Patrol directions for the slimes (true for right, false for left)
    private boolean slime1Direction = true;
    private boolean slime2Direction = true;
    private GameDisplayViewModel2 viewModel;

    private int powerUpX = 6;
    private int powerUpY = 6;
    private boolean powerUpAvailable = true; // The power-up is available to be picked up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGameDisplay2Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_game_display2);
        viewModel = new ViewModelProvider(this).get(GameDisplayViewModel2.class);
        binding.setViewModel(viewModel);

        playerName = getIntent().getStringExtra("PLAYER_NAME");
        difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);
        currScore = getIntent().getIntExtra("currentScore", 100);

        viewModel.setPlayerName(playerName);
        viewModel.setDifficulty(difficulty);
        viewModel.setDrawableImage(characterSpriteId);
        TextView scoreText = findViewById(R.id.textView6);
        scoreText.setText("Score: " + currScore);

        currScore2 = new int[]{currScore};
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
            finish();
            Player.getPlayer().removeObserver(this);
            Player.getPlayer().removeObserver(slime1);


            Player.getPlayer().removeObserver(slime2);
            enemyMoveHandler.removeCallbacksAndMessages(null);
            startActivity(intent);
        });

        viewModel.getContinueEvent().observe(this, message -> {
            Intent intent = new Intent(GameDisplayActivity2.this, GameDisplayActivity3.class);
            slime1.destroy();
            slime2.destroy();
            intent.putExtra("PLAYER_NAME", viewModel.getPlayerName());
            intent.putExtra("DIFFICULTY", difficulty);
            intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
            intent.putExtra("currentScore", currScore2[0]);
            enemyMoveHandler.removeCallbacksAndMessages(null);
            finish();
            startActivity(intent);
        });

        // powerups

        if (powerUpAvailable) {
            moveViewToPosition(findViewById(R.id.powerUp), powerUpY, powerUpX);
        }

        // Attacks



        int startY = 18;
        int startX = 5;

        GridLayout gridLayout = findViewById(R.id.gameGrid);
        Player player = Player.getPlayer();
        Button attackButton = findViewById(R.id.attack); // Replace with your actual button ID
        attackButton.setOnClickListener(v -> {

            player.performRadiusAttack(1); // Example: radius of 1 tile
            colorAttackTiles(player.getX(), player.getY(), gridLayout);
            update(Player.getPlayer(), "Attack", 0, 0);
        });

        for (int y = 0; y < gridLayout.getRowCount(); y++) {
            for (int x = 0; x < gridLayout.getColumnCount(); x++) {
                View tile = new View(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(y, 1, 1);
                params.columnSpec = GridLayout.spec(x, 1, 1);
                params.setGravity(Gravity.FILL);
                params.width = 2; // set appropriate width
                params.height = 2; // set appropriate height
                tile.setLayoutParams(params);
                tile.setBackgroundColor(Color.TRANSPARENT); // initially transparent
                gridLayout.addView(tile);
            }
        }


        player.addObserver(this);
        player.setPosition(startX, startY);
        player.setCurrentTile(tileMap[startY][startX]);
        moveViewToPosition(findViewById(R.id.imageView), startY, startX);

        setupEnemies(player);
        startEnemyPatrol(player);

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
    }

    @Override
    public void update(Observable o, String type, int x, int y) {

        if (powerUpAvailable && x == powerUpX && y == powerUpY) {
            applyScorePowerUp();
            removePowerUpFromScreen();
        }
        
        if (slime1 != null && slime1.isDead()) {
            findViewById(R.id.slime1).setVisibility(View.INVISIBLE);
        }

        if (slime2 != null && slime2.isDead()) {
            findViewById(R.id.slime2).setVisibility(View.INVISIBLE);
        }

        if (type.equals("Player")) {
            moveViewToPosition(findViewById(R.id.imageView), y, x);

            if (tileMap[y][x] == TileType.EXIT) {
                Intent intent = new Intent(GameDisplayActivity2.this, GameDisplayActivity3.class);
                slime1.destroy();
                slime2.destroy();
                intent.putExtra("PLAYER_NAME", playerName);
                intent.putExtra("DIFFICULTY", difficulty);
                intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
                intent.putExtra("currentScore", currScore2[0]);
                finish();
                enemyMoveHandler.removeCallbacksAndMessages(null);
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
        Player.getPlayer().removeObserver(this);
        Player.getPlayer().removeObserver(slime1);
        Player.getPlayer().removeObserver(slime2);
    }


    private void moveViewToPosition(View view, int newRow, int newColumn) {
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) view.getLayoutParams();

        // Update the position
        params.rowSpec = GridLayout.spec(newRow);
        params.columnSpec = GridLayout.spec(newColumn);

        // Apply the updated layout parameters
        view.setLayoutParams(params);

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
        player.addObserver(slime1);
        player.addObserver(slime2);

    }


    private void startEnemyPatrol(Player player) {
        enemyMoveRunnable = new Runnable() {
            @Override
            public void run() {

                patrol(slime1, 1, 10, slime1Direction, player);
                patrolVertical(slime2, 8, 15, slime2Direction, player);


                // Schedule the next run
                enemyMoveHandler.postDelayed(this, 1000); // move every second
            }
        };
        enemyMoveHandler.postDelayed(enemyMoveRunnable, 1000);
    }


   
    private void patrol(Enemy slime, int startColumn, int endColumn,
                        boolean direction, Player player) {
        // Check the current position and move the slime accordingly
        int currentColumn = slime.getX();
        if (direction && currentColumn < endColumn) {
            if (slime == slime1) {
                slime.setPosition(currentColumn + 1, slime.getY(), tileMap);
            } else {
                slime.setPosition(currentColumn + 1, slime.getY(), tileMap);
            }
        } else if (!direction && currentColumn > startColumn) {
            if (slime == slime1) {
                slime.setPosition(currentColumn - 1, slime.getY(), tileMap);
            } else {
                slime.setPosition(currentColumn - 1, slime.getY(), tileMap);
            }
        } else {

            if (slime == slime1) {
                slime1Direction = !slime1Direction;
            }
            if (slime == slime2) {
                slime2Direction = !slime2Direction;
            }
            patrol(slime, startColumn, endColumn, !direction, player);
        }

        if (slime == slime1) {
            update(null, "Slime1", slime.getX(), slime.getY());

        } else if (slime == slime2) {
            update(null, "Slime2", slime.getX(), slime.getY());
        }

        slime.onCollisionWithPlayer();
        updateHealthText(player);

    }

    private void patrolVertical(Enemy slime, int startRow, int endRow,
                                boolean direction, Player player) {
        // Check the current position and move the slime accordingly
        int currentRow = slime.getY();
        if (direction && currentRow < endRow) {
            if (slime == slime1) {
                slime.setPosition(slime.getX(), currentRow + 1, tileMap);
            } else {
                slime.setPosition(slime.getX(), currentRow + 1, tileMap);
            }
        } else if (!direction && currentRow > startRow) {
            if (slime == slime1) {
                slime.setPosition(slime.getX(), currentRow - 1, tileMap);
            } else {
                slime.setPosition(slime.getX(), currentRow - 1, tileMap);
            }
        } else {
            // Change direction if we've hit the end or start

            if (slime == slime1) {
                slime1Direction = !slime1Direction;
            }
            if (slime == slime2) {
                slime2Direction = !slime2Direction;
            }
            patrolVertical(slime, startRow, endRow, !direction, player);
        }

        if (slime == slime1) {
            update(null, "Slime1", slime.getX(), slime.getY());

        } else if (slime == slime2) {
            update(null, "Slime2", slime.getX(), slime.getY());
        }

        slime.onCollisionWithPlayer();
        updateHealthText(player);
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
        Intent intent = new Intent(GameDisplayActivity2.this, GameOverActivity.class);
        slime1.destroy();
        slime2.destroy();
        intent.putExtra("PLAYER_NAME", playerName);
        intent.putExtra("DIFFICULTY", difficulty);
        intent.putExtra("CHARACTER_SPRITE", characterSpriteId);
        currScore2[0] = 0;
        intent.putExtra("currentScore", currScore2[0]);
        Player.getPlayer().removeObserver(this);
        Player.getPlayer().removeObserver(slime1);

        Player.getPlayer().removeObserver(slime2);
        enemyMoveHandler.removeCallbacksAndMessages(null);
        finish();
        startActivity(intent);
    }

    private void applyScorePowerUp() {
        Player player = Player.getPlayer();
        PlayerDecorator decorator = new DoublePointsDecorator(player);
        decorator.setPoints(currScore2[0] * 2);
        currScore2[0] *= 2;
        powerUpAvailable = false;

        CharSequence text = "Collected score powerup!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    private void removePowerUpFromScreen() {
        findViewById(R.id.powerUp).setVisibility(View.INVISIBLE);
    }

    private void colorAttackTiles(int playerX, int playerY, GridLayout gridLayout) {
        int[] dx = {-1, 1, 0, 0, 0, -1, -1, 1, 1}; // Left, Right, Up, Down, Current, and Diagonals
        int[] dy = {0, 0, -1, 1, 0, -1, 1, -1, 1};
        int semiTransparentRed = Color.argb(128, 255, 0, 0);

        for (int i = 0; i < dx.length; i++) {
            int newX = playerX + dx[i];
            int newY = playerY + dy[i];

            // Calculate the index and check bounds
            int index = newY * gridLayout.getColumnCount() + newX + 4;
            if (newX >= 0 && newX < gridLayout.getColumnCount() && newY >= 0
                    && newY < gridLayout.getRowCount() && index < gridLayout.getChildCount()) {
                View tile = gridLayout.getChildAt(index);
                if (tile != null) {
                    tile.setBackgroundColor(semiTransparentRed); // Change color as needed
                } else {
                    Log.e("GameDisplayActivity", "Tile at index " + index + " is null.");
                }
            }
        }

        // Reset the color after 1 second
        new Handler().postDelayed(() -> {
            for (int i = 0; i < dx.length; i++) {
                int newX = playerX + dx[i];
                int newY = playerY + dy[i];
                int index = newY * gridLayout.getColumnCount() + newX + 4;

                if (newX >= 0 && newX < gridLayout.getColumnCount() && newY >= 0
                        && newY < gridLayout.getRowCount() && index < gridLayout.getChildCount()) {
                    View tile = gridLayout.getChildAt(index);
                    if (tile != null) {
                        tile.setBackgroundColor(Color.TRANSPARENT); // Reset to original color
                    }
                }
            }
        }, 1000); // Delay in milliseconds
    }
}