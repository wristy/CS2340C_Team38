package com.example.cs2340c_team38.model;

public interface Enemy extends Observer {


    void onCollisionWithPlayer(Player player);
}
