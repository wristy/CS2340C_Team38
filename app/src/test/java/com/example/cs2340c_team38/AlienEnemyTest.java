/*package com.example.cs2340c_team38;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team38.model.AlienEnemy;
import com.example.cs2340c_team38.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class AlienEnemyTest {
    private class TestablePlayer extends Player {
        boolean healthReduced = false;

        @Override
        public void reduceHealth() {
            super.reduceHealth();
            healthReduced = true;
        }

        public boolean isHealthReduced() {
            return healthReduced;
        }

        public void resetHealthReduced() {
            healthReduced = false;
        }
    }
    private AlienEnemy alienEnemy;
    private Player testPlayer;
    @BeforeEach
    void setUp() {
        testPlayer = new Player();
        alienEnemy = new AlienEnemy();
        alienEnemy.setPlayer(testPlayer);
    }
    @Test
    void testUpdateWithCollision() {
        testPlayer.setX(10);
        testPlayer.setY(10);
        alienEnemy.setPosition(10, 10, null);
        alienEnemy.update(testPlayer, "", 10, 10);
        assertEquals(true, testPlayer.isHealthReduced(), "Health should be reduced on update with collision");
    }
}*/

