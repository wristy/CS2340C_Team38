package com.example.cs2340c_team38;

import com.example.cs2340c_team38.model.Observer;
import com.example.cs2340c_team38.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
    private Player player;
    private TestObserver observer1;
    private TestObserver observer2;

    @Before
    public void setUp() {
        player = Player.getPlayer();
        observer1 = new TestObserver();
        observer2 = new TestObserver();
    }

    @Test
    public void testAddObserver() {
        player.addObserver(observer1);
        assertTrue(player.getObservers().contains(observer1));
        player.addObserver(observer2);
        assertTrue(player.getObservers().contains(observer1));
        assertTrue(player.getObservers().contains(observer2));
    }

    @Test
    public void testRemoveObserver() {
        player.addObserver(observer1);
        player.addObserver(observer2);
        player.removeObserver(observer1);
        assertTrue(!player.getObservers().contains(observer1));
        assertTrue(player.getObservers().contains(observer2));
    }

    @Test
    public void notifyObservers() {
        player.addObserver(observer1);
        player.addObserver(observer2);
        player.notifyObservers();
        assertEquals(player.getX(), observer1.getUpdatedX());
        assertEquals(player.getY(), observer1.getUpdatedY());
        assertEquals(player.getX(), observer1.getUpdatedX());
        assertEquals(player.getY(), observer1.getUpdatedY());

    }


    private class TestObserver implements Observer {
        private int updatedX;
        private int updatedY;

        @Override
        public void update(int x, int y) {
            updatedX = x;
            updatedY = y;
        }

        public int getUpdatedX() {
            return updatedX;
        }

        public int getUpdatedY() {
            return updatedY;
        }

    }
}
