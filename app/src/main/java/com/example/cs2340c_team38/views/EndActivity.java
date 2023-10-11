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
    }

    private void displayLeaderboard() {
        Leaderboard leaderboard = Leaderboard.getInstance();
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(5);
        ListView l = findViewById(R.id.list);


        // TODO: Display topScores in the desired format on the EndActivity screen
        // You might use an adapter to populate a ListView or RecyclerView.
    }
}