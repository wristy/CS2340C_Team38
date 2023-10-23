package com.example.cs2340c_team38;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340c_team38.model.ScoreModel;

import org.junit.Before;
import org.junit.Test;

public class ScoreModelTest {
    private ScoreModel scoreModel;

    @Before
    public void setUp() {
        scoreModel = new ScoreModel();
    }
    @Test
    public void testDecrementScore() {
        scoreModel.decrementScore();
        int updatedScore = scoreModel.getScore();
        assertEquals(99, updatedScore);
    }
    @Test
    public void testSetScore() {
        scoreModel.setScore(50);
        scoreModel.decrementScore();
        scoreModel.decrementScore();
        int updatedScore = scoreModel.getScore();
        assertEquals(48, updatedScore);
    }





}
