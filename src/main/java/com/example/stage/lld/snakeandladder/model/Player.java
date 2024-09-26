package com.example.stage.lld.snakeandladder.model;

public class Player extends User{
    private int currentPosition;

    public Player(String userId, String name) {
        super(userId, name);
        this.currentPosition = 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
