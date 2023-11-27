package com.example.cs2340c_team38.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player implements Observable {

    private int x;
    private int y;

    private boolean isAlive = true;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    private int damage;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void reduceHealth() {
        health -= damage;
    }

    private int health;
    private TileType currentTile;
    private MoveStrategy moveStrategy;

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(TileType[][] tileMap) {
        moveStrategy.move(player, tileMap);
        notifyObservers();
    }

    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    private static volatile Player player;

    /*
     * @param x x-coordinate of player (default 0.0)
     * @param y y-coordinate of player (default 0.0)
     * @param movementSpeed movement speed of player (default 5.0)
     */
    public Player() {
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
        notifyObservers();
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

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(player, "Player", x, y);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
