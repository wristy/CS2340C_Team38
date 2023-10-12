package com.example.cs2340c_team38;


import org.junit.Test;



import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team38.model.ScoreModel;
import org.junit.jupiter.api.BeforeEach;

public class ScoreModelTest {
    private ScoreModel scoreModel;
    private static final int DECREMENT_VALUE = 1; // Assuming DECREMENT_VALUE is 1, adjust if different
    @BeforeEach
    public void setUp() {
        scoreModel = new ScoreModel(); // Assuming ScoreModel has a public constructor
    }

    @Test
    public void testDecrementScoreWhenScoreIsPositive() {
        int initialScore = 10; // Set an initial score value
        scoreModel.setScore(initialScore); // Assuming ScoreModel has a setScore method

        scoreModel.decrementScore();

        assertEquals(initialScore - DECREMENT_VALUE, scoreModel.getScore());
    }

    @Test
    public void testDecrementScoreWhenScoreIsZero() {
        scoreModel.setScore(0); // Assuming ScoreModel has a setScore method

        scoreModel.decrementScore();

        assertEquals(0, scoreModel.getScore());
    }
}
