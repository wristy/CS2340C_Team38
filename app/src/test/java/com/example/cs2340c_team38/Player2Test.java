package com.example.cs2340c_team38;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.MoveLeft;
import com.example.cs2340c_team38.model.MoveRight;
import com.example.cs2340c_team38.model.MoveStrategy;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.TileType;

public class Player2Test {
    private Player player;

    private TileType[][] tileMap;


    @Before
    public void setUp() {
        player = Player.getPlayer();
        player.setPosition(3,3);
        tileMap = new TileType[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tileMap[i][j]= TileType.WALL;
            }
        }

    }

    @Test
    public void testMoveLeftNotValid() {
        MoveStrategy strategy = new MoveLeft();
        player.setMoveStrategy(strategy);
        player.move(tileMap);

        assertEquals(3, player.getX());
        assertEquals(3, player.getY());
        assertFalse(tileMap[player.getY()][player.getX()].isWalkable());
    }

    @Test
    public void testMoveRightNotValid() {
        MoveStrategy strategy = new MoveRight();
        player.setMoveStrategy(strategy);
        player.move(tileMap);

        assertEquals(3, player.getX());
        assertEquals(3, player.getY());
        assertFalse(tileMap[player.getY()][player.getX()].isWalkable());
    }
}
