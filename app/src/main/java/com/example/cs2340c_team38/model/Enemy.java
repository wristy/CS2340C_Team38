package com.example.cs2340c_team38.model;

public interface Enemy extends Observable {


    @Override
    void addObserver(Observer o);

    @Override
    void removeObserver(Observer o);

    @Override
    void notifyObservers();
}
