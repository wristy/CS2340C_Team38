/*package com.example.cs2340c_team38;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.PonyEnemy;
import com.example.cs2340c_team38.model.SlimeEnemy;
import com.example.cs2340c_team38.model.TileType;
import com.example.cs2340c_team38.model.WizardEnemy;

import org.junit.Test;

public class ExtraTestEnemy {
    @Test
    public void testPonyEnemyUpdate() {
        PonyEnemy ponyEnemy = new PonyEnemy();
        WizardEnemy wizardEnemy = new WizardEnemy();
        SlimeEnemy slimeEnemy = new SlimeEnemy();
        Player player1 = new Player();
        player1.setHealth(100);
        player1.setDamage(1);
        player1.setPosition(0, 0);


        ponyEnemy.setPosition(1, 1, new TileType[3][3]);
        wizardEnemy.setPosition(2, 2, new TileType[3][3]);
        slimeEnemy.setPosition(3, 3, new TileType[3][3]);
        ponyEnemy.update(player1, "Player has same health", player1.getX(), player1.getY());
        wizardEnemy.update(player1, "Player has same health", player1.getX(), player1.getY());
        slimeEnemy.update(player1, "Player has same health", player1.getX(), player1.getY());


        assertEquals(100, player1.getHealth());
    }
}*/
