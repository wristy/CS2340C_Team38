package com.example.cs2340c_team38;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        int characterSpriteId = getIntent().getIntExtra("CHARACTER_SPRITE", -1);

        TextView playerNameTextView = findViewById(R.id.textView3);
        playerNameTextView.setText(playerName);

        TextView difficultyTextView = findViewById(R.id.textView2);
        difficultyTextView.setText(difficulty);

        ImageView characterImageView = findViewById(R.id.imageView);
        if (characterSpriteId == R.id.radioCharacter1) {
            characterImageView.setImageResource(R.drawable.character1);
        } else if (characterSpriteId == R.id.radioCharacter2) {
            characterImageView.setImageResource(R.drawable.character2);
        } else if (characterSpriteId == R.id.radioCharacter3) {
            characterImageView.setImageResource(R.drawable.character3);
        }
    }
}