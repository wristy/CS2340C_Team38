package com.example.cs2340c_team38.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.model.Leaderboard;

import java.util.List;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        populateHardCodedEntries();
        displayLeaderboard();
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

}