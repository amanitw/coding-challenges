package com.example.stage.lld.snakeandladder.service;

import com.example.stage.lld.snakeandladder.model.Board;
import com.example.stage.lld.snakeandladder.model.Player;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerId;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerId = 0;
    }

    public void startGame() {
        while (true) {
            Player currentPlayer = players.get(currentPlayerId);
            currentPlayerId = (currentPlayerId + 1) % players.size();

            int steps = board.throwDice();

            int nextNumber = currentPlayer.getCurrentPosition() + steps;

            board.movePlayer(currentPlayer, nextNumber);
            System.out.println("Player "+currentPlayer.getName()+" is at "+currentPlayer.getCurrentPosition());
            if (board.isWinner(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " is winner");
                return;
            }
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

}
