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

        // Clear previous scores
        leaderboard.clearAll(); // Assuming you've implemented a method to clear scores. If not, you'll need to.

        // Populate with some test scores
        leaderboard.addScore("Test1", 500);
        leaderboard.addScore("Test2", 600);
        leaderboard.addScore("Test3", 550);
    }

    @Test
    public void testAddScore() {
        leaderboard.addScore("Test4", 650);
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(5);

        // We should have 4 entries now
        assertEquals(4, topScores.size());

        // The highest score (650) should be the first one
        assertEquals("Test4", topScores.get(0).playerName);
        assertEquals(650, topScores.get(0).score);
    }
    @Test
    public void testAddNegativeScore() {
        leaderboard.addScore("Test4", -650);
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(5);

        // We should have 4 entries now
        assertEquals(4, topScores.size());

        // The highest score (650) should be the first one
        assertEquals("Test4", topScores.get(0).playerName);
        assertEquals(650, topScores.get(0).score);
    }

    @Test
    public void testGetTopScores() {
        List<Leaderboard.ScoreEntry> topScores = leaderboard.getTopScores(3);

        // We should get 3 top scores
        assertEquals(3, topScores.size());

        // Scores should be in descending order
        assertTrue(topScores.get(0).score >= topScores.get(1).score);
        assertTrue(topScores.get(1).score >= topScores.get(2).score);

        leaderboard.addScore("MAX", 99999999);
        List<Leaderboard.ScoreEntry> topScore = leaderboard.getTopScores(1);
        assertTrue(topScore.get(0).score == 99999999);

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


