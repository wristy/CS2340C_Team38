package com.example.cs2340c_team38.model;

public class WizardEnemy implements Enemy {
    private Player player;
    private int x;
    private int y; // Position of the AlienEnemy

    @Override
    public int getX() {
        return x;
    }

    @Override
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
            if (this.x == ((Player) o).getX() && this.y == ((Player) o).getY()) {
                ((Player) o).reduceHealth();
            }
        }
    }

    @Override
    public void onCollisionWithPlayer() {
        if (!isDead && this.x == player.getX() && this.y == player.getY()) {
            player.reduceHealth();
        }
    }

    @Override
    public void setPosition(int x, int y, TileType[][] tileMap) {

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
