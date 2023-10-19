package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cs2340c_team38.model.TileType;

public class GameDisplayViewModel extends ViewModel {

    private String playerName;
    private int difficulty;

    private MutableLiveData<Integer> drawableImage = new MutableLiveData<>();

    public MutableLiveData<Void> getEndEvent() {
        return endEvent;
    }

    public MutableLiveData<Void> getContinueEvent() {
        return continueEvent;
    }

    private MutableLiveData<Void> endEvent = new MutableLiveData<>();
    private MutableLiveData<Void> continueEvent = new MutableLiveData<>();


    public void setDrawableImage(int drawableResourceId) {
        this.drawableImage.setValue(drawableResourceId);
    }

    public MutableLiveData<Integer> getDrawableImage() {
        return drawableImage;
    }

    public String getHealthText() {
        return String.valueOf(getHealth());
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void onButtonClick() {
        endEvent.setValue(null);
    }

    public void onContinueButtonClick() {
        continueEvent.setValue(null);
    }


public String getDifficultyText() {
        switch (difficulty) {
        case 0:
            return "Easy";
        case 1:
            return "Medium";
        default:
            return "Hard";
        }
    }

    public int getHealth() {
        switch (difficulty) {
        case 0:
            return 150;
        case 1:
            return 100;
        default:
            return 85;
        }
    }
}