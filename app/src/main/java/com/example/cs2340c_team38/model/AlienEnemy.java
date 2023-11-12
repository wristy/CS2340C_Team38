package com.example.cs2340c_team38.model;

public class AlienEnemy implements Enemy {
    private Player player;

    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y; // Position of the AlienEnemy


    @Override
    public void onCollisionWithPlayer() {
        if (this.x == player.getX() && this.y == player.getY()) {
            player.reduceHealth();
        }
    }

    public void setPosition(int x, int y, TileType[][] tileMap) {
        this.x = x;
        this.y = y;
    }

    public void update(Observable o, String observable, int playerX, int playerY) {
        if (o instanceof Player) {
            if (this.x == ((Player) o).getX() && this.y == ((Player) o).getY()) {
                ((Player) o).reduceHealth();            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }




}
