package com.example.cs2340c_team38;

import com.example.cs2340c_team38.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = Player.getPlayer();
    }

    @Test
    public void testMoveUp() {
        player.setY(10.0);
        player.moveUp();
        assertEquals(5.0, player.getY(), 0.001);
    }

    @Test
    public void testMoveDown() {
        player.setY(10.0);
        player.moveDown();
        assertEquals(15.0, player.getY(), 0.001);
    }
    @Test
    public void testMoveRight() {
        player.setX(710.0);
        player.moveRight();
        assertEquals(715.0, player.getX(), 0.001);
    }



    @Test
    public void testMoveLeft() {
        player.setX(10.0);
        player.moveLeft();
        assertEquals(5.0, player.getX(), 0.001);
    }
    @Test
    public void testMoveRightBoundary() {
        player.setX(720.0);
        player.moveRight();
        assertEquals(720.0, player.getX(), 0.001);
    }
    @Test
    public void testMoveUpBoundary() {
        player.setY(0.0);
        player.moveUp();
        assertEquals(0.0, player.getY(), 0.001);
    }
    @Test
    public void testMoveLeftBoundary() {
        player.setX(0.0);
        player.moveLeft();
        assertEquals(0.0, player.getX(), 0.001);
    }
    @Test
    public void testMoveDownBoundary() {
        player.setY(720.0);
        player.moveDown();
        assertEquals(720.0, player.getY(), 0.001);
    }





}
