package com.reddy.tictactoe.model;

public class Player extends User{
    User user;
    Piece piece;

    public Player(String name, Integer userId, Piece piece) {
        super(name, userId);
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
