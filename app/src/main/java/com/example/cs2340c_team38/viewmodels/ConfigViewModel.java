package com.example.cs2340c_team38.viewmodels;

import android.text.TextUtils;
import android.widget.RadioGroup;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfigViewModel extends ViewModel {
    private MutableLiveData<String> playerName = new MutableLiveData<>();
    private MutableLiveData<Integer> difficulty = new MutableLiveData<>();
    private MutableLiveData<Integer> characterSprite = new MutableLiveData<>();
    private MutableLiveData<Boolean> isValidConfig = new MutableLiveData<>();

    public MutableLiveData<String> getPlayerName() {
        return playerName;
    }

    public MutableLiveData<Integer> getDifficulty() {
        return difficulty;
    }

    public MutableLiveData<Integer> getCharacterSprite() {
        return characterSprite;
    }

    public MutableLiveData<Boolean> getIsValidConfig() {
        return isValidConfig;
    }

    public void onSplitTypeChanged(RadioGroup radioGroup, int id) {
        this.characterSprite.setValue(radioGroup.getCheckedRadioButtonId());
    }

    public void setCharacterSprite(MutableLiveData<Integer> characterSprite) {
        this.characterSprite = characterSprite;
    }


    public void onButtonContinueClicked() {
        if (isValidConfig()) {
            isValidConfig.setValue(true);
        } else {
            isValidConfig.setValue(false);
        }
    }

    private boolean isValidConfig() {
        return !TextUtils.isEmpty(playerName.getValue()) &&
                difficulty.getValue() != null &&
                characterSprite.getValue() != null;
    }
}