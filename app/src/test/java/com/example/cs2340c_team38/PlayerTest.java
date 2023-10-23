package com.example.cs2340c_team38;

import com.example.cs2340c_team38.model.MoveDown;
import com.example.cs2340c_team38.model.MoveStrategy;
import com.example.cs2340c_team38.model.MoveUp;
import com.example.cs2340c_team38.model.Player;
import com.example.cs2340c_team38.model.TileType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player;

    private TileType[][] tileMap;


    @Before
    public void setUp() {
        player = Player.getPlayer();
        player.setPosition(3,3);
        tileMap = new TileType[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tileMap[i][j]= TileType.FLOOR;
            }
        }

    }

//    @Test
//    public void testMoveUp() {
//        player.setY(10.0);
//        player.moveUp();
//        assertEquals(5.0, player.getY(), 0.001);
//    }
//    @Test
//    public void testMoveDown() {
//        player.setY(10.0);
//        player.moveDown();
//        assertEquals(15.0, player.getY(), 0.001);
//    }
//
//    @Test
//    public void testMoveRight() {
//        player.setX(710.0);
//        player.moveRight();
//        assertEquals(715.0, player.getX(), 0.001);
//    }
//
//
//
//
//    @Test
//    public void testMoveRightBoundary() {
//        player.setX(720.0);
//        player.moveRight();
//        assertEquals(720.0, player.getX(), 0.001);
//    }
//    @Test
//    public void testMoveLeft() {
//        player.setX(10.0);
//        player.moveLeft();
//        assertEquals(5.0, player.getX(), 0.001);
//    }
//
//
//
//    @Test
//    public void testMoveDownBoundary() {
//        player.setY(720.0);
//        player.moveDown();
//        assertEquals(720.0, player.getY(), 0.001);
//    }
//    @Test
//    public void testMoveUpBoundary() {
//        player.setY(0.0);
//        player.moveUp();
//        assertEquals(0.0, player.getY(), 0.001);
//    }
    //aria tests
    @Test
    public void testMoveUpValid() {
        MoveStrategy strategy = new MoveUp();
        player.setMoveStrategy(strategy);
        player.move(tileMap);

        assertEquals(3, player.getX());
        assertEquals(2, player.getY());
        assertTrue(tileMap[player.getY()][player.getX()].isWalkable());
    }

    @Test
    public void testMoveDownValid() {
        MoveStrategy strategy = new MoveDown();
        player.setMoveStrategy(strategy);
        player.move(tileMap);
        assertEquals(3, player.getX());
        assertEquals(4, player.getY());
        assertTrue(tileMap[player.getY()][player.getX()].isWalkable());

    }

}
