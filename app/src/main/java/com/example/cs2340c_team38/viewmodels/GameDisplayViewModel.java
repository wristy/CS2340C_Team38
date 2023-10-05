package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.ViewModel;

public class GameDisplayViewModel extends ViewModel {

    private String playerName;
    private int difficulty;
    private int characterSpriteId;

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