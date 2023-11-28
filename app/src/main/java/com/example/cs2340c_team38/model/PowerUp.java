package com.example.cs2340c_team38.model;

public interface PowerUp {
    void reduceHealth();
    void setDamage(int damage);
    void move(TileType[][] tileMap);
    void setHealth(int health);
    void setPoints(int points);
}
