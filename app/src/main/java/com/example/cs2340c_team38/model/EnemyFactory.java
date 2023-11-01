package com.example.cs2340c_team38.model;

public class EnemyFactory {
    public Enemy createEnemy(String enemy) throws IllegalAccessException {
        if (enemy == null || enemy.isEmpty()) {
            return null;
        }
        if (enemy.equals("Slime")) {
            return new SlimeEnemy();
        } else {
            throw new IllegalAccessException("Unknown enemy " + enemy);
        }
    }

}
