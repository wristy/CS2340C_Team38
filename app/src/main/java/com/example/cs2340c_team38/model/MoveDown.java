package com.example.cs2340c_team38.model;

public class MoveDown implements MoveStrategy {
    @Override
    public void move(Player player, TileType[][] tileMap) {
        int newY = player.getY() + 1;
        if (newY < tileMap.length && tileMap[newY][player.getX()].isWalkable()) {
            player.setPosition(player.getX(), newY);
            player.setCurrentTile(tileMap[newY][player.getX()]);
        }
    }
}