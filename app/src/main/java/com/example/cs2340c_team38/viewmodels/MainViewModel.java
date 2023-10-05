package com.example.cs2340c_team38.viewmodels;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cs2340c_team38.ConfigActivity;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> message = new MutableLiveData<>();

    public LiveData<String> getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message.setValue(message);
    }

    public class MainViewModel extends ViewModel {
        private MutableLiveData<String> message = new MutableLiveData<>();

        public LiveData<String> getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message.setValue(message);
        }

        public void onButtonStartClicked(Context context) {
            // Handle button start click event
            message.setValue("Button Start Clicked");
            Intent intent = new Intent(context, ConfigActivity.class);
            context.startActivity(intent);
        }
    }

    public void onButtonExitClicked() {
        // Handle button exit click event
    }
}