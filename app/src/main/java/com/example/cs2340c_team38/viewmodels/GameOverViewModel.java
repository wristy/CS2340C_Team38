package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameOverViewModel extends ViewModel {

    private MutableLiveData<Void> endEvent = new MutableLiveData<>();

    public MutableLiveData<Void> getEndEvent() {
        return endEvent;
    }

    public void onButtonRestartClicked() {
        endEvent.setValue(null);
    }

}