package com.example.cs2340c_team38;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.SlimeEnemy;
import com.example.cs2340c_team38.model.TileType;

public class DamageTest {
    private Player player;
    private TileType[][] tileMap;
    SlimeEnemy slimeEnemy = new SlimeEnemy();
    @Before
    public void initialize() {
        player = Player.getPlayer();
        player.setHealth(150);
        player.setDamage(10);
    }
    @Test
    public void testPlayerDamageUponCollision () {
        player = Player.getPlayer();
        slimeEnemy.setPlayer(player);
        player.setPosition(0, 0);
        slimeEnemy.setPosition(0, 0, new TileType[1][1]);
        slimeEnemy.onCollisionWithPlayer();
        assertEquals(140, player.getHealth());

    }
}
