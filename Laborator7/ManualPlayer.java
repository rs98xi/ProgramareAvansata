package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ManualPlayer extends Player {

    public ManualPlayer(String name, Board board) {
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
        for (int i = 0; i < n; i++) {
            set[i] = tokenList.get(i).getToken();
        }
        System.out.println(Arrays.toString(set));

        Scanner s = new Scanner(System.in);
        int[] array = new int[s.nextInt()];
        for (int i = 0; i < array.length; i++)
            array[i] = s.nextInt();

        maxSize = 0;
        n = array.length;
        if (n < 3 || n > tokenList.size()) {
            if (n <= tokenList.size()) {
                maxSize = n;
            }
            return false;
        }
        maxSize = 2;
        for (int i = 0; i < n - 2; i++) {
            if (array[i] >= tokenList.size() || array[i + 1] >= tokenList.size() || array[i + 2] >= tokenList.size()) {
                return false;
            }
            if (set[array[i + 1]] == (set[array[i]] + set[array[i + 2]]) / 2) {
                maxSize++;
            } else {
                return maxSize >= board.getPointsToWin();
            }
        }

        return maxSize >= board.getPointsToWin();
    }
}
