package com.company;

public class Game {
    public void play() {
        Board board = new Board(5, 100, 5);
        new Thread(new RandomPlayer("Jucatorul 1", board)).start();
        new Thread(new GameDaemon(board, 500000)).start();
        new Thread(new SmartPlayer("Jucatorul 2", board)).start();
        new Thread(new SmartPlayer("Jucatorul 3", board)).start();
        new Thread(new ManualPlayer("Jucatorul 4", board)).start();


    }
}
