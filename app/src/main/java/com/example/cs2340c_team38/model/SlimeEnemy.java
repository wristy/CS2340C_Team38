package com.example.cs2340c_team38.model;

import java.util.ArrayList;
import java.util.List;

public class SlimeEnemy implements Enemy {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final List<Observer> observers = new ArrayList<>();


    @Override
    public void onCollisionWithPlayer(Player player) {
        // Implement what happens when an AlienEnemy collides with the player
    }

    public void setPosition(int x, int y, TileType[][] tileMap) {
        this.x = x;
        this.y = y;
        notifyObservers();
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
            observer.update(this, "Slime", x, y);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
