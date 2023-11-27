package com.example.cs2340c_team38.model;

public class HealthBoost extends PowerUpDecorator {
    private int healthBoost;

    public HealthBoost(PowerUp decoratedPowerUp, int healthBoost) {
        super(decoratedPowerUp);
        this.healthBoost = healthBoost;
    }

    @Override
    public void apply(Player player) {
        super.apply(player);
        player.setHealth(player.getHealth() + healthBoost);
    }


}
