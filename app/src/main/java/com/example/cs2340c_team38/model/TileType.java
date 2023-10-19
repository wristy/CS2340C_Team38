package com.example.cs2340c_team38.model;

public enum TileType {
    FLOOR,
    WALL,
    LAVA,
    ENTRANCE,
    EXIT,
    GRASS;

    public boolean isWalkable() {
        return this == FLOOR || this == EXIT;
    }
}
