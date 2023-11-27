package com.example.cs2340c_team38;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.Leaderboard;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.ScoreModel;
import com.example.cs2340c_team38.model.SlimeEnemy;
import com.example.cs2340c_team38.model.TileType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.HashSet;
import java.util.Set;
public class damageTests {
    private Player player;
    private TileType[][] tileMap;
    SlimeEnemy slimeEnemy = new SlimeEnemy();
    @Before
    public void initialize(int difficulty, Player player1) {

        if (difficulty == 0) {
            player.setHealth(150);
            player.setDamage(10);
        } else if (difficulty == 1) {
            player.setHealth(100);
            player.setDamage(15);
        } else if (difficulty == 2) {
            player.setHealth(80);
            player.setDamage(20);
        }
    }
    @Test
    public void testPlayerDamageUponCollision () {
        slimeEnemy.setPlayer(player);
        player.setPosition(0, 0);
        slimeEnemy.setPosition(0, 0, new TileType[1][1]);
        slimeEnemy.onCollisionWithPlayer();

        assertEquals(player.getHealth() - player.getDamage(), player.getHealth());

    }
}
