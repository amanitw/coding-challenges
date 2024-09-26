package com.example.stage.lld.snakeandladder.model;

public class Cell {
    private int id;
    private BoardEntity boardEntity;

    public Cell(int id, BoardEntity boardEntity) {
        this.id = id;
        this.boardEntity = boardEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }
}
