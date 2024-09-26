package com.example.stage.lld.snakeandladder.model;

public class Snake implements BoardEntity{
    private int from;
    private int to;

    public Snake(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public int getDestination() {
        return this.to;
    }
}
