/*package com.example.cs2340c_team38;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team38.model.AlienEnemy;
import com.example.cs2340c_team38.model.Player;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class AlienEnemyTest {
private AlienEnemy alienEnemy;
private Player testPlayer;
@Before
    public void setUp() {
    testPlayer = Player.getPlayer();
    testPlayer.setHealth(10); // Set a known health value
    testPlayer.setDamage(1); // Set a known damage value
    testPlayer.setPosition(3, 3);
    alienEnemy = new AlienEnemy();
    alienEnemy.setPlayer(testPlayer);
}
@Test
public void testOnCollisionWithPlayerSamePosition() {
    testPlayer.setPosition(5, 10);
    alienEnemy.setPosition(5, 10, null);
    int initialHealth = testPlayer.getHealth();
    alienEnemy.onCollisionWithPlayer();
    assertEquals(initialHealth - 1, testPlayer.getHealth());
}
@Test
public void testOnCollisionWithPlayerDifferentPosition() {
    testPlayer.setPosition(3, 7);
    alienEnemy.setPosition(5, 10, null);
    int initialHealth = testPlayer.getHealth();
    alienEnemy.onCollisionWithPlayer();
    assertEquals(initialHealth, testPlayer.getHealth());
}
@Test
public void testUpdateWithCollision() {
    testPlayer.setPosition(5, 10);
    alienEnemy.setPosition(5, 10, null);
    int initialHealth = testPlayer.getHealth();
    alienEnemy.update(testPlayer, "PlayerMoved", 5, 10);
    assertEquals(initialHealth - 1, testPlayer.getHealth());
}
@Test
public void testUpdateWithoutCollision() {
    testPlayer.setPosition(3, 7);
    alienEnemy.setPosition(5, 10, null);
    int initialHealth = testPlayer.getHealth();
    alienEnemy.update(testPlayer, "PlayerMoved", 3, 7);
    assertEquals(initialHealth, testPlayer.getHealth());
    }
}*/

