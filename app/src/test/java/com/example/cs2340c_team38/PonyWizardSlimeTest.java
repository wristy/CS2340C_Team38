package com.example.cs2340c_team38;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.PonyEnemy;
import com.example.cs2340c_team38.model.SlimeEnemy;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.model.WizardEnemy;

public class PonyWizardSlimeTest {
    @Test
    public void testPonyEnemyOnPlayerCollision() {
        PonyEnemy ponyEnemy = new PonyEnemy();
        Player player1 = Player.getPlayer();
        player1.setHealth(100);
        player1.setDamage(1);
        ponyEnemy.setPlayer(player1);

        ponyEnemy.setPosition(0, 0, new TileType[1][1]);
        player1.setPosition(0, 0);

        ponyEnemy.onCollisionWithPlayer();
        assertEquals(99, player1.getHealth());
    }
    @Test
    public void testSlimeEnemyOnPlayerCollision() {
        SlimeEnemy slimeEnemy = new SlimeEnemy();
        Player player2 = Player.getPlayer();
        player2.setHealth(80);
        player2.setDamage(3);

        slimeEnemy.setPlayer(player2);

        slimeEnemy.setPosition(0, 0, new TileType[1][1]);
        player2.setPosition(0, 0);

        slimeEnemy.onCollisionWithPlayer();
        assertEquals(77, player2.getHealth());
    }

    @Test
    public void testWizardEnemyOnPlayerCollision() {
        WizardEnemy wizardEnemy= new WizardEnemy();
        Player player3 = Player.getPlayer();
        player3.setHealth(90);
        player3.setDamage(9);
        wizardEnemy.setPlayer(player3);

        wizardEnemy.setPosition(0, 0, new TileType[1][1]);
        player3.setPosition(0, 0);

        wizardEnemy.onCollisionWithPlayer();

        assertEquals(81, player3.getHealth());
    }

    @Test
    public void testPonyEnemyUpdate() {
        PonyEnemy ponyEnemy = new PonyEnemy();
        Player player1 = new Player();
        player1.setHealth(100);
        player1.setDamage(1);
        ponyEnemy.setPlayer(player1);

        ponyEnemy.setPosition(0, 0, new TileType[1][1]);
        player1.setPosition(0, 0);
        ponyEnemy.update(player1, "Player is at same position", player1.getX(), player1.getY());

        assertEquals(99, player1.getHealth());
    }

    @Test
    public void testSlimeEnemyUpdate() {
        SlimeEnemy slimeEnemy = new SlimeEnemy();
        Player player2 = Player.getPlayer();
        player2.setHealth(80);

        player2.setDamage(3);

        slimeEnemy.setPlayer(player2);

        slimeEnemy.setPosition(0, 0, new TileType[1][1]);
        player2.setPosition(0, 0);

        slimeEnemy.update(player2, "Player is at same position", player2.getX(), player2.getY());

        assertEquals(77, player2.getHealth());

    }

    @Test
    public void testWizardEnemyUpdate() {
        WizardEnemy wizardEnemy= new WizardEnemy();
        Player player3 = Player.getPlayer();
        player3.setHealth(75);
        player3.setDamage(4);
        wizardEnemy.setPlayer(player3);

        wizardEnemy.setPosition(0, 0, new TileType[1][1]);
        player3.setPosition(0, 0);

        wizardEnemy.update(player3, "Player is at same position", player3.getX(), player3.getY());

        assertEquals(71, player3.getHealth());

    }




}


