package com.example.cs2340c_team38.model;

public class ReduceDamageDecorator extends PlayerDecorator {
    private final double reduction;

    public ReduceDamageDecorator(Player player, double reduction) {
        super(player);
        this.reduction = reduction;
    }

    @Override
    public void setDamage(int damage) {
        player.setDamage((int) (player.getDamage() * reduction));
    }
}

