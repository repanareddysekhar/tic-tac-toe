package com.reddy.tictactoe;

import com.reddy.tictactoe.model.Board;
import com.reddy.tictactoe.model.Piece;
import com.reddy.tictactoe.model.Player;
import com.reddy.tictactoe.service.Game;

public class TicTacToeApp {
    public static void main(String[] args) {
        Player p1 = new Player("reddy", 1, Piece.X);
        Player p2 = new Player("sekhar", 2, Piece.O);

        System.out.println("GAME 1");
        Game ticTac = new Game(p1, p2);
        ticTac.play(0,0);
        ticTac.play(0,1);
        ticTac.play(0,2);
        ticTac.play(1,1);
        ticTac.play(1,0);
        ticTac.play(2,1);
        ticTac.play(2,2);

        System.out.println("GAME 2");
        ticTac = new Game(p1,p2);
        ticTac.play(0,0);
        ticTac.play(0,1);
        ticTac.play(1,1);
        ticTac.play(1,0);
        ticTac.play(2,2);
    }
}
