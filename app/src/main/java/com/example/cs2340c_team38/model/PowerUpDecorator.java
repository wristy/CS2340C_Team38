package com.example.cs2340c_team38.model;

public abstract class PowerUpDecorator implements PowerUp {
    protected PowerUp decoratedPowerUp;

    public PowerUpDecorator(PowerUp decoratedPowerUp) {
        this.decoratedPowerUp = decoratedPowerUp;
    }

    public void apply(Player player) {
        decoratedPowerUp.apply(player);
    }
}
