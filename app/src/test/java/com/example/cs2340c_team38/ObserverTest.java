package com.example.cs2340c_team38;

import com.example.cs2340c_team38.model.Observable;
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

    private TestObserver observer3;

    @Before
    public void setUp() {
        player = Player.getPlayer();
        observer1 = new TestObserver();
        observer2 = new TestObserver();
        observer3 = new TestObserver();
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
        player.addObserver(observer3);
        player.removeObserver(observer2);
        player.addObserver(observer2);
        player.removeObserver(observer3);
        player.addObserver(observer1);
        assertTrue(!player.getObservers().contains(observer3));
        assertTrue(player.getObservers().contains(observer1));
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
        public void update(Observable o, String Observalble, int x, int y) {
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
