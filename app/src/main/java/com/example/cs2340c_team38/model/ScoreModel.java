package com.example.cs2340c_team38.model;

public class ScoreModel {
    private int score;
    private final int startingScore = 100; // Starting score
    private final int decrementValue = 1;  // Score decrement value

    public ScoreModel() {
        this.score = startingScore;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int a) {
        this.score = a;
    }

    // Decrease the score by the DECREMENT_VALUE
    public void decrementScore() {
        if (score > 0) {
            score -= decrementValue;
        }
    }
}

