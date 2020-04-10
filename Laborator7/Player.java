package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Runnable {
    protected String Name;
    protected int id;
    protected Board board;
    protected List<Token> tokenList;
    protected int maxSize;

    public Player(String name, Board board) {
        Name = name;
        this.board = board;
        tokenList = new ArrayList<>();
        board.addPlayer(this);
        maxSize = 0;
    }

    public Player() {

    }

    public abstract boolean getMaxProgression();

    public void run() {
        if (board.getTokenList().size() == 0) {
            return;
        }

        boolean result = true;

        do {
            try {
                result = board.play(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (result);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
