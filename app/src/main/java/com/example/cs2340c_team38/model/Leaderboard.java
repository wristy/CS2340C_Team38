package com.example.cs2340c_team38.model;

import java.util.ArrayList;

public class Leaderboard {
    private ArrayList<String> names;
    private ArrayList<Integer> scores;
    private ArrayList<Integer> dates;
    private volatile static Leaderboard leaderboard;

    private Leaderboard() {
        this.names = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }

}
