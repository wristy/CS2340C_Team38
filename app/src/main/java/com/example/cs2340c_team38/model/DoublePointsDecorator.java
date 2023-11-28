package com.example.cs2340c_team38.model;

public class DoublePointsDecorator extends PlayerDecorator {
    public DoublePointsDecorator(Player player) {
        super(player);
    }

    // Suppose the player has a method to add points
    @Override
    public void setPoints(int points) {
        player.setPoints(2 * points);
    }
}
