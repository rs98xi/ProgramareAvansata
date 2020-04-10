package com.company;

public class GameDaemon implements Runnable{

    long initialTime;
    Board board;
    long maxTime;

    GameDaemon(Board board, long max)
    {
        this.board = board;
        maxTime = max;
    }

    public synchronized void  run()
    {
        boolean monitor = true;
        initialTime = System.currentTimeMillis();
        while(monitor)
        {
            long actualTime = System.currentTimeMillis();
            if(actualTime - initialTime > maxTime)
            {
                System.out.println("Time out");
                board.setTimeOut(true);
                monitor = false;
            }
            System.out.flush();
            int players = board.getActivePlayers();
            if(players == 0)
            {
                System.out.println("No more players. Game over!");
                monitor = false;
            }
        }
    }
}
