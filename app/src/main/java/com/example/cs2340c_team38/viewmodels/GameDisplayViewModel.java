package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class GameDisplayViewModel extends ViewModel {

    private String playerName;
    private int difficulty;
    private int characterSpriteId;

    private MutableLiveData<Integer> drawableImage = new MutableLiveData<>();

    public MutableLiveData<Void> getEndEvent() {
        return endEvent;
    }

    public void setEndEvent(MutableLiveData<Void> endEvent) {
        this.endEvent = endEvent;
    }

    private MutableLiveData<Void> endEvent = new MutableLiveData<>();

    public void setDrawableImage(int drawableResourceId) {
        this.drawableImage.setValue(drawableResourceId);
    }

    public MutableLiveData<Integer> getDrawableImage() {
        return drawableImage;
    }

    public String getHealthText() {
        return String.valueOf(getHealth());
    }

    private String healthText;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void onButtonClick() { endEvent.setValue(null);}

    public void setCharacterSpriteId(int characterSpriteId) {
        this.characterSpriteId = characterSpriteId;
    }

    public int getCharacterSpriteId() {
        return characterSpriteId;
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