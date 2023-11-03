package com.example.cs2340c_team38.model;

public class AlienEnemy implements Enemy {

    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y; // Position of the AlienEnemy


    @Override
    public void onCollisionWithPlayer(Player player) {
        // Implement what happens when an AlienEnemy collides with the player
    }

    public void setPosition(int x, int y, TileType[][] tileMap) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void addObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {

    }
}
