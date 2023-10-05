package com.example.cs2340c_team38;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 3);
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        TextView playerNameTextView = findViewById(R.id.textView3);
        playerNameTextView.setText(playerName);

        TextView difficultyTextView = findViewById(R.id.textView2);
        String diff;
        switch (difficulty) {
            case 0:
                diff = "Easy";
                break;
            case 1:
                diff = "Medium";
                break;
            default:
                diff = "Hard";
                break;
        }
        difficultyTextView.setText(diff);

        ImageView characterImageView = findViewById(R.id.imageView);
        if (characterSpriteId == R.id.radioCharacter1) {
            characterImageView.setImageResource(R.drawable.character1);
        } else if (characterSpriteId == R.id.radioCharacter2) {
            characterImageView.setImageResource(R.drawable.character2);
        } else if (characterSpriteId == R.id.radioCharacter3) {
            characterImageView.setImageResource(R.drawable.character3);
        }

        TextView healthTextView = findViewById(R.id.textView);
        if (diff.equals("Easy")) {
            healthTextView.setText("Health: 150");
        } else if (diff.equals("Medium")) {
            healthTextView.setText("Health: 100");
        } else if (diff.equals("Hard")) {
            healthTextView.setText("Health: 85");
        }

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameDisplayActivity.this, EndActivity.class);
                startActivity(intent);
            }
        });
    }
}