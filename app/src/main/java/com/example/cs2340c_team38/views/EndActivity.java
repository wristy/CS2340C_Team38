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

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        //populateHardCodedEntries();
        int currScore = getIntent().getIntExtra("finalScore", 100);
        String currName = getIntent().getStringExtra("currName");
        Leaderboard l = Leaderboard.getInstance();
        l.addScore(currName, currScore);
        displayLeaderboard();
        displayRecentAttempt();

        Button buttonRestart = findViewById(R.id.buttonRestart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the EndActivity
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

    private void populateHardCodedEntries() {
        Leaderboard leaderboard = Leaderboard.getInstance();

        // Adding 5 hard-coded entries
        leaderboard.addScore("Alice", 5000);
        leaderboard.addScore("Bob", 4500);
        leaderboard.addScore("Charlie", 4900);
        leaderboard.addScore("Dave", 5100);
        leaderboard.addScore("Eve", 4800);
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