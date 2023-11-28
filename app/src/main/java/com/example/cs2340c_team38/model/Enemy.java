package com.example.cs2340c_team38.model;

public interface Enemy extends Observer {

    void onCollisionWithPlayer();

    void setPlayer(Player player);
    void setPosition(int x, int y, TileType[][] tileMap);

    int getX();
    int getY();

    void destroy();

    boolean isDead();
}



