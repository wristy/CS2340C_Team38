package com.example.cs2340c_team38.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.model.Leaderboard;

import java.text.SimpleDateFormat;
import java.util.List;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        int currScore = getIntent().getIntExtra("currScore", 0);
        String currName = getIntent().getStringExtra("PLAYER_NAME");
        Leaderboard l = Leaderboard.getInstance();
        l.addScore(currName, currScore);
        displayLeaderboard();
        displayRecentAttempt();

        Button buttonRestart = findViewById(R.id.buttonRestart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                finish();
                startActivity(intent);

            }
        });

    }

    private void displayLeaderboard() {
        Leaderboard leaderboard = Leaderboard.getInstance();
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(5);
        ListView leaderboardListView = findViewById(R.id.list);
        LeaderboardAdapter adapter = new LeaderboardAdapter(this, topScores);
        leaderboardListView.setAdapter(adapter);
    }

    private void displayRecentAttempt() {
        Leaderboard leaderboard = Leaderboard.getInstance();
        Leaderboard.ScoreEntry recentEntry = leaderboard.getMostRecent();

        TextView recentPlayerNameTextView = findViewById(R.id.recentPlayerNameTextView);
        TextView recentScoreTextView = findViewById(R.id.recentScoreTextView);
        TextView recentDateTextView = findViewById(R.id.recentDateTextView);

        recentPlayerNameTextView.setText(recentEntry.getPlayerName());
        recentScoreTextView.setText(String.valueOf(recentEntry.getScore()));
        recentDateTextView.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(recentEntry.getDateTime()));
    }

}