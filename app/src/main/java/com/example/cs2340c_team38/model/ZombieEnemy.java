package com.example.cs2340c_team38.model;

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

    private boolean isDead = false;

    public void destroy() {
        isDead = true;
    }

    public boolean isDead() {
        return isDead;
    }

    public void update(Observable o, String observable, int playerX, int playerY) {
        if (o instanceof Player) {
            if (!isDead && this.x == ((Player) o).getX() && this.y == ((Player) o).getY()) {
                ((Player) o).reduceHealth();
            }
        }
    }

    public void onCollisionWithPlayer() {
        if (this.x == player.getX() && this.y == player.getY()) {
            player.reduceHealth();
        }

    }
    public void setPosition(int x, int y, TileType[][] tileMap) {
        boolean isValid = false;
        if (x >= 0 && x < tileMap.length && y >= 0
                && y < tileMap[0].length && tileMap[x][y] == TileType.FLOOR) {
            isValid = true;
        }
        if (isValid) {
            this.x = x;
            this.y = y;
        }
    }
    public Player player() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

}




