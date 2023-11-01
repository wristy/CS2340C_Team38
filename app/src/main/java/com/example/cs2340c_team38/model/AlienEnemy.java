package com.example.cs2340c_team38.model;

public class AlienEnemy implements Enemy {

    private int x, y; // Position of the AlienEnemy

    @Override
    public void update(int playerX, int playerY) {
        if (this.x == playerX && this.y == playerY) {
            onCollisionWithPlayer(Player.getPlayer());
        }
    }

    @Override
    public void onCollisionWithPlayer(Player player) {
        // Implement what happens when an AlienEnemy collides with the player
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
