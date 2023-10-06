package com.example.cs2340c_team38.model;

public class Player {

    private double x;
    private double y;
    private double movementSpeed;

    private volatile static Player player;

    /*
     * @param x x-coordinate of player (default 0.0)
     * @param y y-coordinate of player (default 0.0)
     * @param movementSpeed movement speed of player (default 5.0)
     */

    private Player(double x, double y, double movementSpeed) {
        this.x = x;
        this.y = y;
        this.movementSpeed = movementSpeed;
    }

    private Player() {
        this.x = 0.0;
        this.y = 0.0;
        this.movementSpeed = 5.0;
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

    public void moveUp() {
        setY(Math.max(0, getY() - movementSpeed));
    }

    public void moveDown() {
        setY(Math.min(getY() + movementSpeed, 720));
    }

    public void moveLeft() {
        setX(Math.max(0, getX() - movementSpeed));
    }

    public void moveRight() {
        setX(Math.min(getX() + movementSpeed, 720));
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}