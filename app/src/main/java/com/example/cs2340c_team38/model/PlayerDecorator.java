package com.example.cs2340c_team38.model;

public abstract class PlayerDecorator implements PowerUp  {
    protected Player player;

    public PlayerDecorator(Player player) {
        this.player = player;
    }

    @Override
    public void reduceHealth() {
        player.reduceHealth();
    }

    @Override
    public void move(TileType[][] tilemap) {
        player.move(tilemap);
    }

    @Override
    public void setDamage(int damage) {
        player.setDamage(damage);
    }

    @Override
    public void setHealth(int health) {
        player.setHealth(health);
    }

    @Override
    public void setPoints(int points) {
        player.setPoints(points);
    }
}

