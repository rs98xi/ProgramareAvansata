package com.company;

public class Game {
    public void play() {
        Board board = new Board(5, 100, 15);
        new Thread(new Player("Jucatorul 1", board)).start();
        new Thread(new GameDaemon(board, 20)).start();
        new Thread(new Player("Jucatorul 2", board)).start();
        new Thread(new Player("Jucatorul 3", board)).start();
        new Thread(new Player("Jucatorul 4", board)).start();


    }
}
