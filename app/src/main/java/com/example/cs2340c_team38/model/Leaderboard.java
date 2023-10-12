package com.example.cs2340c_team38.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Leaderboard {
    private static volatile Leaderboard leaderboard;

    private static ScoreEntry recent;

    public void clearAll() {
        scores.clear();
    }

    private List<ScoreEntry> scores;

    private Leaderboard() {
        this.scores = new ArrayList<>();
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
        recent = new ScoreEntry(playerName, score);
        Collections.sort(scores, (a, b) -> b.score - a.score); // Sort in descending order by score
    }

    public List<ScoreEntry> getTopScores(int limit) {
        return scores.subList(0, Math.min(limit, scores.size()));
    }

    public ScoreEntry getMostRecent() {
        if (scores.isEmpty()) {
            return null;
        }
        return recent;
    }

    public static class ScoreEntry {
        private String playerName;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        private int score;

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        private Date dateTime;

        public ScoreEntry(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
            this.dateTime = new Date();
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }
    }


}
