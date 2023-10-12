package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.cs2340c_team38.model.ScoreModel;

import java.util.Timer;
import java.util.TimerTask;



public class ScoreViewModel extends ViewModel {
    private ScoreModel scoreModel;


    public void startScoreDecrement() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scoreModel.decrementScore();
            }
        }, 0, 1000); // Decrease score every second
    }
}
