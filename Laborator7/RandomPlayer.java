package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class RandomPlayer extends Player {

    public RandomPlayer(String name, Board board) {
        Name = name;
        this.board = board;
        tokenList = new ArrayList<>();
        board.addPlayer(this);
    }

    @Override
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

    public boolean getMaxProgression() {
        Collections.shuffle(tokenList);
        maxSize = 0;
        if(tokenList.size() < 3)
        {
            return false;
        }

        maxSize = 2;

        for (int i = 0; i < tokenList.size() - 2; i++) {
            if(tokenList.get(i+1).getToken() == (tokenList.get(i).getToken() + tokenList.get(i+2).getToken())/2)
            {
                maxSize ++;
            }
            else
            {
                break;
            }
        }
        if(maxSize >= board.getPointsToWin())
            return true;
        return false;
    }

}
