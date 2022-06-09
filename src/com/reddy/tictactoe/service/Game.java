package com.reddy.tictactoe.service;

import com.reddy.tictactoe.model.Board;
import com.reddy.tictactoe.model.Cell;
import com.reddy.tictactoe.model.Player;

public class Game {
    private final Board board;
    private final Player[] players;
    private final int MAX_PLAYERS = 2;
    private final int NO_OF_CELLS = 3;
    private Player currentPlayer;
    private GameStatus gameStatus;
    int moveCount = 0;

    public Game(Player p1, Player p2) {
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
        board = new Board(NO_OF_CELLS);
        this.currentPlayer = p1;
        this.gameStatus = GameStatus.PLAYING;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean play(int row, int col) {
        if(GameStatus.PLAYING == gameStatus) {
            if(isValidMove(row, col) == true) {
                board.boxes[row][col].setPiece(currentPlayer.getPiece());
                moveCount++;
                if(checkIfWon(row, col)) {
                    System.out.println(currentPlayer.getName() + " has won the game! GAME OVER");
                    gameStatus = GameStatus.WON;
                    board.printBoardStatus();
                    return false;
                } else if(checkIfDraw(row, col)) {
                    board.printBoardStatus();
                    return false;
                }
                gameStatus = GameStatus.PLAYING;
                changeTurn();
                board.printBoardStatus();
                return true;
            }
            System.out.println("Invalid move, please enter valid move");
            board.printBoardStatus();
            return false;
        } else {
            System.out.println(currentPlayer.getName()  +" has Already won! GAME IS OVER");
            board.printBoardStatus();
            return false;
        }
    }
    private boolean checkIfWon(int row, int col) {
        return rowCheck(row) || colCheck(col) || diagCheck(row, col) || revDiagCheck(row, col);
    }

    private boolean rowCheck(int row) {
        for(int i=0; i<NO_OF_CELLS; i++) {
            if(board.boxes[row][i].getPiece() != currentPlayer.getPiece())
                return false;
        }
        return true;
    }

    private boolean colCheck(int col) {
        for(int i=0; i<NO_OF_CELLS; i++) {
            if(board.boxes[i][col].getPiece() != currentPlayer.getPiece())
                return false;
        }
        return true;
    }

    private boolean diagCheck(int row, int col) {
        if(row != col) return false;
        for(int i=0; i<NO_OF_CELLS; i++) {
            if(board.boxes[i][i].getPiece() != currentPlayer.getPiece())
                return false;
        }
        return true;
    }

    private boolean revDiagCheck(int row, int col) {
        if((row+col )!= NO_OF_CELLS-1) return false;
        for(int i=NO_OF_CELLS-1, j=0; i>=0 && j<NO_OF_CELLS; i--, j++) {
            if(board.boxes[i][j].getPiece() != currentPlayer.getPiece())
                return false;
        }
        return true;
    }

    private boolean checkIfDraw(int row, int col) {
        if(moveCount == NO_OF_CELLS*NO_OF_CELLS)
            return true;

        return false;
    }
    private void changeTurn() {
        currentPlayer = (currentPlayer.getUserId() == players[0].getUserId())?players[1]:players[0];
    }

    private boolean isValidMove(int row, int col) {
        return row < NO_OF_CELLS && col < NO_OF_CELLS && board.boxes[row][col].getPiece() == null;
    }
}
