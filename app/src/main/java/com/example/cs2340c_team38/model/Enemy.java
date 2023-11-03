package com.example.cs2340c_team38.model;

public interface Enemy extends Observable {

    void onCollisionWithPlayer(Player player);
    void setPosition(int x, int y, TileType[][] tileMap);

    int getX();
    int getY();
}
