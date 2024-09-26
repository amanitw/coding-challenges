package com.example.stage.lld.snakeandladder.model;

public class Dice {
    private int totalFace;

    public Dice(int totalFace) {
        this.totalFace = totalFace;
    }

    public int getNextNumber(){
        double nextNumber =  Math.random()*100;
        nextNumber = Math.floor(nextNumber);
        int t =  (int) (nextNumber%totalFace);
        return t+1;
    }

    public int getTotalFace() {
        return totalFace;
    }

    public void setTotalFace(int totalFace) {
        this.totalFace = totalFace;
    }

}
