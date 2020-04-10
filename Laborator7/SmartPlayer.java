package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SmartPlayer extends Player{

    public SmartPlayer(String name, Board board) {
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
        int n = tokenList.size();
        Collections.sort(tokenList);
        int[] set = new int[n];
        for(int i=0;i<n;i++)
        {
            set[i] = tokenList.get(i).getToken();
        }
        //System.out.println(Arrays.toString(set));

        if (n <= 2) {
            return false;
        }

        int[][] L = new int[n][n];
        int llap = 2;
        for (int i = 0; i < n; i++)
            L[i][n - 1] = 2;
        for (int j = n - 2; j >= 1; j--)
        {
            int i = j -1 , k = j + 1;
            while (i >= 0 && k <= n - 1)
            {
                if (set[i] + set[k] < 2 * set[j])
                    k++;
                else if (set[i] + set[k] > 2 * set[j])
                {
                    L[i][j] = 2; i--;

                }
                else
                {
                    L[i][j] = L[j][k] + 1;
                    llap = Math.max(llap, L[i][j]);
                    i--; k++;
                }
            }
            while (i >= 0)
            {
                L[i][j] = 2;
                i--;
            }
        }
        maxSize = llap;

        return maxSize >= board.getPointsToWin();
    }
}
