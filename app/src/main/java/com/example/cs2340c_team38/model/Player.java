package com.example.cs2340c_team38.model;

public class Player {

    private int x;
    private int y; // Player's position on the tile map
    private TileType currentTile; // The type of tile the player is currently on

    private static volatile Player player;

    /*
     * @param x x-coordinate of player (default 0.0)
     * @param y y-coordinate of player (default 0.0)
     * @param movementSpeed movement speed of player (default 5.0)
     */


    private Player() {
        this.x = 0;
        this.y = 0;
    }

    /*
     * Constructor for Player
     * @return the instance of the player
     */

    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }
            }
        }
        return player;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCurrentTile(TileType currentTile) {
        this.currentTile = currentTile;
    }

    public TileType getCurrentTile() {
        return currentTile;
    }

    public boolean isOnWalkableTile() {
        if (currentTile == null) {
            return false;
        }
        return currentTile.isWalkable();
    }

}
