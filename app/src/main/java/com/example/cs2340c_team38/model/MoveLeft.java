package com.example.cs2340c_team38.model;

public class MoveLeft implements MoveStrategy {
    @Override
    public void move(Player player, TileType[][] tileMap) {
        int newX = player.getX() - 1;
        if (newX >= 0 && tileMap[player.getY()][newX].isWalkable()) {
            player.setPosition(newX, player.getY());
            player.setCurrentTile(tileMap[player.getY()][newX]);
        }
    }
}
