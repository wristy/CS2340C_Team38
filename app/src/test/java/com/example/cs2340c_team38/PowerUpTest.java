package com.example.cs2340c_team38;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.AlienEnemy;
import com.example.cs2340c_team38.model.DoublePointsDecorator;
import com.example.cs2340c_team38.model.HealthBoostDecorator;
import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveStrategy;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.PonyEnemy;
import com.example.cs2340c_team38.model.ReduceDamageDecorator;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.model.WizardEnemy;

import org.junit.Before;
import org.junit.Test;

public class PowerUpTest {
    private Player player;
    private HealthBoostDecorator healthBoostDecorator;

    private DoublePointsDecorator doublePointsDecorator;

    private ReduceDamageDecorator reduceDamageDecorator;

    private TileType[][] tileMap;


    @Before
    public void setUp() {
       player = Player.getPlayer();
       healthBoostDecorator = new HealthBoostDecorator(player, 5);

    }

    @Test
    public void testReduceHealthWithEnemy() {
        WizardEnemy wizardEnemy= new WizardEnemy();
        int healthVal = 100;
        player.setHealth(healthVal);
        player.setDamage(9);
        wizardEnemy.setPlayer(player);
        wizardEnemy.setPosition(0, 0, new TileType[1][1]);
        player.setPosition(0, 0);
        wizardEnemy.onCollisionWithPlayer();
        healthVal = player.getHealth();
        healthBoostDecorator.setHealth(healthVal);
        assertEquals(96, player.getHealth());

    }
    @Test
    public void testReduceDamage() {
        player.setPosition(3, 3);
        player.setHealth(100);
        player.setDamage(6);

        tileMap = new TileType[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tileMap[i][j]= TileType.FLOOR;
            }
        }

        MoveStrategy strategy = new MoveDown();
        player.setMoveStrategy(strategy);
        player.move(tileMap);

        reduceDamageDecorator = new ReduceDamageDecorator(player, 2.0);
        int damage = player.getDamage();
        reduceDamageDecorator.setDamage(damage);

        AlienEnemy alienEnemy = new AlienEnemy();
        alienEnemy.setPlayer(player);
        alienEnemy.setPosition(3, 4, tileMap);
        alienEnemy.onCollisionWithPlayer();

        assertEquals(3, player.getDamage());
        assertEquals(97, player.getHealth());
        assertTrue(tileMap[player.getY()][player.getX()].isWalkable());
    }

    @Test
    public void testMultiplePowerUp() {
        player.setPoints(45);
        player.setHealth(100);
        healthBoostDecorator.setHealth(player.getHealth());
        doublePointsDecorator = new DoublePointsDecorator(player);
        doublePointsDecorator.setPoints(player.getPoints());

        assertEquals(105, player.getHealth());
        assertEquals(90, player.getPoints());
    }

    @Test
    public void withEnemySinglePowerUp() {
        int healthVal = 200;
        player.setHealth(healthVal);
        player.setDamage(8);
        player.setPosition(0, 0);
        WizardEnemy wizardEnemy = new WizardEnemy();
        wizardEnemy.setPosition(0, 0, new TileType[1][1]);
        wizardEnemy.setPlayer(player);
        wizardEnemy.onCollisionWithPlayer();

        player.setPoints(player.getHealth());
        doublePointsDecorator = new DoublePointsDecorator(player);
        doublePointsDecorator.setPoints(player.getHealth());

        assertEquals(384, player.getPoints());
    }
    @Test
    public void testMultiplePowerUpWithEnemy() {
        tileMap = new TileType[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tileMap[i][j]= TileType.FLOOR;
            }
        }
        player.setPosition(0, 0);
        player.setDamage(10);
        player.setHealth(100);
        player.setPoints(1000);

        doublePointsDecorator = new DoublePointsDecorator(player);
        doublePointsDecorator.setPoints(player.getPoints());
        reduceDamageDecorator = new ReduceDamageDecorator(player, 5.0);
        reduceDamageDecorator.setDamage(player.getDamage());

        PonyEnemy ponyEnemy = new PonyEnemy();
        ponyEnemy.setPlayer(player);
        ponyEnemy.setPosition(0, 0, tileMap);
        ponyEnemy.onCollisionWithPlayer();

        healthBoostDecorator.setHealth(player.getHealth());
        assertEquals(2000, player.getPoints());
        assertEquals(103, player.getHealth());

    }
    @Test
    public void testMathOrderOfOperations() {
        player.setHealth(100);

        player.setDamage(18);

        healthBoostDecorator.setHealth(player.getHealth());
        reduceDamageDecorator = new ReduceDamageDecorator(player, 3.0);
        int damage = player.getDamage();
        reduceDamageDecorator.setDamage(damage);

        assertEquals(105, player.getHealth());

    }

    @Test
    public void testMathOrderOfOperations2() {
        player.setHealth(100);

        player.setDamage(35);

        reduceDamageDecorator = new ReduceDamageDecorator(player, 5.0);
        int damage = player.getDamage();
        reduceDamageDecorator.setDamage(damage);
        healthBoostDecorator.setHealth(player.getHealth());


        assertEquals(105, player.getHealth());
        assertEquals(7, player.getDamage());

    }
    @Test
    public void testDifferentOrderEnemy() {
        player.setPosition(0, 0);
        player.setDamage(10);
        player.setHealth(90);


        WizardEnemy wizardEnemy = new WizardEnemy();
        wizardEnemy.setPlayer(player);
        wizardEnemy.setPosition(0, 0, new TileType[1][1]);
        wizardEnemy.onCollisionWithPlayer();

        reduceDamageDecorator = new ReduceDamageDecorator(player, 5.0);
        reduceDamageDecorator.setDamage(player.getDamage());

        healthBoostDecorator.setHealth(player.getHealth());

        assertEquals(85, player.getHealth());
    }

    @Test
    public void singleOperationWithTileMapAndEnemy() {
        player.setPosition(3, 3);
        player.setHealth(100);
        player.setDamage(16);

        tileMap = new TileType[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tileMap[i][j]= TileType.FLOOR;
            }
        }
        MoveStrategy strategy = new MoveDown();
        player.setMoveStrategy(strategy);
        player.move(tileMap);

        reduceDamageDecorator = new ReduceDamageDecorator(player, 4.0);
        int damage = player.getDamage();
        reduceDamageDecorator.setDamage(damage);

        AlienEnemy alienEnemy = new AlienEnemy();
        alienEnemy.setPlayer(player);
        alienEnemy.setPosition(3, 4, tileMap);
        alienEnemy.onCollisionWithPlayer();

        healthBoostDecorator.setHealth(player.getHealth());

        assertEquals(4, player.getDamage());
        assertEquals(101, player.getHealth());
        assertTrue(tileMap[player.getY()][player.getX()].isWalkable());
    }

    @Test
    public void testDamageWithoutCollision() {
        AlienEnemy wizardEnemy = new AlienEnemy();;
        player.setDamage(9);
        player.setHealth(1000);
        player.setPoints(90);
        wizardEnemy.setPlayer(player);
        wizardEnemy.setPosition(0, 0, new TileType[2][2]);
        player.setPosition(1, 1);
        wizardEnemy.onCollisionWithPlayer();
        healthBoostDecorator.setHealth(player.getHealth());

        reduceDamageDecorator = new ReduceDamageDecorator(player, 3.0);
        reduceDamageDecorator.setDamage(player.getDamage());
        assertEquals(1005, player.getHealth());
        assertEquals(90, player.getPoints());

    }









}
