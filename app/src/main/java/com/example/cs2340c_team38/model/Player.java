package com.example.cs2340c_team38.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player extends PlayerDecorator implements Observable {

    private static volatile Player player;
    private final CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<>();
    private int x;
    private int y;
    private int points;

    private boolean isAlive = true;
    private int damage;

    private int health;
    private TileType currentTile;
    private MoveStrategy moveStrategy;

    /*
     * @param x x-coordinate of player
     * @param y y-coordinate of player
     */
    public Player() {
        super(player);
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void reduceHealth() {
        health -= damage;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(TileType[][] tileMap) {
        moveStrategy.move(player, tileMap);
        notifyObservers();
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

    public void performRadiusAttack(int radius) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                int attackX = this.x + dx;
                int attackY = this.y + dy;

                for (Observer o: observers) {
                    if (o instanceof Enemy) {
                        if (((Enemy) o).getX() == attackX && ((Enemy) o).getY() == attackY) {
                            ((Enemy) o).destroy();
                            observers.remove(o);
                        }
                    }
                }
            }
        }
    }

}
