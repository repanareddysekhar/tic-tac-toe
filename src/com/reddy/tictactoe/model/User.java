package com.reddy.tictactoe.model;

public class User{
    String name;
    Integer userId;

    public User(String name, Integer userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }
}
