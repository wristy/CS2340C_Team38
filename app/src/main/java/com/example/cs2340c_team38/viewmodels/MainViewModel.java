package com.example.cs2340c_team38.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Void> startEvent = new MutableLiveData<>();
    private MutableLiveData<Void> endEvent = new MutableLiveData<>();

    public MutableLiveData<Void> getStartEvent() {
        return startEvent;
    }

    public MutableLiveData<Void> getEndEvent() {
        return endEvent;
    }

    public void onButtonStartClicked() {
        startEvent.setValue(null);
    }

    public void onButtonExitClicked() {
        endEvent.setValue(null);
    }
}