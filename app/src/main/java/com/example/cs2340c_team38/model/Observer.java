package com.example.cs2340c_team38.model;

public interface Observer {
    void update(String observable, int x, int y);
}

/*private class TestObserver implements Observer {
    private int updatedX;
    private int updatedY;
    @Override
    public void update (int x, int y) {
        updatedX = x;
        updatedY = y;
    }
    public int getUpdatedX() {
        return updatedX;
    }
    public int getUpdatedY() {
        return updatedY;
    }*/

