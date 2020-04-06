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

    public void run()
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
        }
    }
}
