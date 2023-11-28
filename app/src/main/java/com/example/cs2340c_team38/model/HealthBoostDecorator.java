package com.example.cs2340c_team38.model;

public class HealthBoostDecorator extends PlayerDecorator {
    private int extraHealth;

    public HealthBoostDecorator(Player player, int extraHealth) {
        super(player);
        this.extraHealth = extraHealth;
    }

    @Override
    public void setHealth(int health) {
        player.setHealth(health + extraHealth);
    }
}

