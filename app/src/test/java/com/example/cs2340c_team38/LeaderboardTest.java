package com.example.cs2340c_team38;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.Leaderboard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.HashSet;
import java.util.Set;

public class LeaderboardTest {

    private Leaderboard leaderboard;

    @Before
    public void setUp() {
        leaderboard = Leaderboard.getInstance();

        leaderboard.clearAll();

        leaderboard.addScore("Test1", 500);
        leaderboard.addScore("Test2", 600);
        leaderboard.addScore("Test3", 550);
    }

    @Test
    public void testAddScore() {
        leaderboard.addScore("Test4", 650);
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(5);

        assertEquals(4, topScores.size());

        assertEquals("Test4", topScores.get(0).getPlayerName());
        assertEquals(650, topScores.get(0).getScore());
    }
    @Test
    public void testGetTopScores() {
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(3);

        // We should get 3 top scores
        assertEquals(3, topScores.size());

        // Scores should be in descending order
        assertTrue(topScores.get(0).getScore() >= topScores.get(1).getScore());
        assertTrue(topScores.get(1).getScore() >= topScores.get(2).getScore());

        leaderboard.addScore("MAX", 99999999);
        List<Leaderboard.ScoreEntry> topScore = leaderboard.getTopScores(1);
        assertTrue(topScore.get(0).getScore() == 99999999);

    }


        @Test
        public void testSingletonProperty() throws Exception {
            // Create a set to hold instances of Leaderboard
            Set<Leaderboard> instances = new HashSet<>();

            // Create an ExecutorService to simulate concurrent access
            ExecutorService executor = Executors.newFixedThreadPool(100);

            // Submit tasks to the executor to get instances of Leaderboard
            for (int i = 0; i < 100; i++) {
                Future<Leaderboard> future = executor.submit(Leaderboard::getInstance);
                instances.add(future.get());
            }

            // Shutdown the executor
            executor.shutdown();

            // Assert that only one unique instance of Leaderboard exists
            assertEquals(1, instances.size());
        }
    }


