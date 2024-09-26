package com.example.stage.lld.snakeandladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Integer, Cell> cellMap;
    private int currentPlayer;

    private Dice dice;

    private int N;

    public Board(int N, Dice dice) {
        this.cellMap = new HashMap<>();
        this.currentPlayer = 0;
        this.N = N;
        this.dice = dice;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < this.N; i++) {
            cellMap.put(i+1, new Cell(i, null));
        }
    }

    public void setBoardEntity(int id, BoardEntity boardEntity) {
        Cell cell = cellMap.get(id);
        cell.setBoardEntity(boardEntity);
    }


    public int throwDice() {
        return dice.getNextNumber();
    }

    public void movePlayer(Player currentPlayer, int nextNumber) {
        Cell cell = cellMap.get(nextNumber);
        if (nextNumber > N) {
            return;
        }
        currentPlayer.setCurrentPosition(nextNumber);
        if (cell.getBoardEntity() != null) {
            BoardEntity entity = cell.getBoardEntity();
            currentPlayer.setCurrentPosition(entity.getDestination());
        }
    }

    public boolean isWinner(Player currentPlayer) {
        if (currentPlayer.getCurrentPosition() == N) {
            return true;
        }
        return false;
    }
}
