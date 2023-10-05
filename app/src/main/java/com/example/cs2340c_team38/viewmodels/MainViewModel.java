package com.example.cs2340c_team38.viewmodels;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cs2340c_team38.ConfigActivity;
public class MainViewModel extends ViewModel {
    public MutableLiveData<Void> getStartEvent() {
        return startEvent;
    }

    private MutableLiveData<Void> startEvent = new MutableLiveData<>();

    public void onButtonStartClicked() {
        // Handle button start click event
        startEvent.setValue(null);
    }

    public void onButtonExitClicked() {
        // Handle button exit click event
    }
}