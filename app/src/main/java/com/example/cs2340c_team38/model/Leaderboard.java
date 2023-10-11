package com.example.cs2340c_team38.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Leaderboard {
    private volatile static Leaderboard leaderboard;

    public void clearAll() {
        scores.clear();
    }

    public static class ScoreEntry {
        public String playerName;
        public int score;
        public Date dateTime;

        public ScoreEntry(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
            this.dateTime = new Date();
        }
    }

    private List<ScoreEntry> scores;

    private Leaderboard() {
        scores = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }

    public void addScore(String playerName, int score) {
        scores.add(new ScoreEntry(playerName, score));
        Collections.sort(scores, (a, b) -> b.score - a.score); // Sort in descending order by score
    }

    public List<ScoreEntry> getTopScores(int limit) {
        return scores.subList(0, Math.min(limit, scores.size()));
    }

}
