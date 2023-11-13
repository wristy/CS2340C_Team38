package com.example.cs2340c_team38.model;

import java.util.ArrayList;
import java.util.List;

public class SlimeEnemy implements Enemy {
    private Player player;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    @Override
    public void onCollisionWithPlayer() {
        if (this.x == Player.getPlayer().getX() && this.y == Player.getPlayer().getY()) {
            Player.getPlayer().reduceHealth();
        }
    }

    public void setPosition(int x, int y, TileType[][] tileMap) {
        this.x = x;
        this.y = y;
    }

    public void update(Observable o, String observable, int playerX, int playerY) {
        if (o instanceof Player) {
            if (this.x == ((Player) o).getX() && this.y == ((Player) o).getY()) {
                ((Player) o).reduceHealth();
            }
        }
    }



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
