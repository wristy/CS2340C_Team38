package com.example.cs2340c_team38.viewmodels;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cs2340c_team38.ConfigActivity;
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
        // Handle button start click event
        startEvent.setValue(null);
    }

    public void onButtonExitClicked() {
        endEvent.setValue(null);
    }
}