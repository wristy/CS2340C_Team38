package com.example.cs2340c_team38.model;

import android.service.quicksettings.Tile;

public class ZombieEnemy implements Enemy {
    private Player player;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(Observable o, String observable, int playerX, int playerY) {
        if (o instanceof Player) {
            if (this.x == ((Player) o).getX() && this.y == ((Player) o).getY()) {
                ((Player) o).reduceHealth();
            }
        }
    }

    public void onCollisionWithPlayer() {

    }
    public void setPosition(int x, int y, TileType[][] tileMap) {

    }
    public Player player() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

}




