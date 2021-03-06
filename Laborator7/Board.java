package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private int tokenNumber;
    private List<Token> tokenList;
    private int maxPlayersNumber;
    private List<Player> playerList;
    private int playerNumber;
    private int pointsToWin;
    private int turn;
    private boolean timeOut;
    private int winner;
    private int activePlayers;

    public Board(int playerNumber, int tokenNumber, int pointsToWin) {
        tokenList = new ArrayList<>();
        playerList = new ArrayList<>();
        maxPlayersNumber = playerNumber;
        this.playerNumber = 0;
        this.activePlayers = 0;
        for (int counter = 1; counter <= tokenNumber; counter++) {
            Token token = new Token(counter);
            tokenList.add(token);
        }
        Collections.shuffle(tokenList);
        System.out.println("Jocul are " + tokenList.size() + " piese si maxim " + maxPlayersNumber + " playeri.");
        this.pointsToWin = pointsToWin;
        turn = 0;
        timeOut = false;
        winner = -1;
    }

    public boolean addPlayer(Player player) {
        if (playerNumber == maxPlayersNumber) {
            return false;
        }
        player.setId(playerNumber);
        playerList.add(playerNumber, player);
        playerNumber++;
        activePlayers++;
        return true;

    }

    private synchronized void setNextTurn() {
        turn = (turn + 1) % playerNumber;
    }

    public synchronized boolean play(Player player) throws InterruptedException {
        while (player.getId() != turn) {
            this.wait(5);
        }
        System.out.println("Randul lui " + player.getName());

        if (getTokenList().size() == 0 || timeOut || winner != -1) {
            if(getTokenList().size() == 0)
            {
                System.out.println("No more tokens. Game Over!");
                System.out.println(player.getName() + " a strans " + player.getMaxSize() + " puncte.");
            }
            else if(timeOut)
            {
                System.out.println("Out of time. Game Over!");
                System.out.println(player.getName() + " a strans " + player.getMaxSize() + " puncte.");
            }
            else
            {
                System.out.println("Jucatorul " + player.getName() + " a pierdut :(!");
            }

            activePlayers--;
            //System.out.println(activePlayers);

            setNextTurn();
            this.notifyAll();
            return false;
        }

        Token token = getTokenList().get(0);
        getTokenList().remove(0);
        player.getTokenList().add(token);
        System.out.println(player.getName() + " a tras tokenul cu numarul " + token.getToken() + "!");

        setNextTurn();

        if(player.getMaxProgression())
        {
            System.out.println("We have a winner! " + player.getName() + " a castigat!");
            winner = player.getId();
            return false;
        }
        else
        {
            System.out.println(player.getName() + " are o serie de " + player.getMaxSize() + " puncte.");
        }

        this.notifyAll();
        return true;

    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public int getMaxPlayersNumber() {
        return maxPlayersNumber;
    }

    public void setMaxPlayersNumber(int maxPlayersNumber) {
        this.maxPlayersNumber = maxPlayersNumber;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPointsToWin() {
        return pointsToWin;
    }

    public void setPointsToWin(int pointsToWin) {
        this.pointsToWin = pointsToWin;
    }

    public boolean isTimeOut() {
        return timeOut;
    }

    public void setTimeOut(boolean timeOut) {
        this.timeOut = timeOut;
    }

    public int getActivePlayers() {
        return activePlayers;
    }

    public void setActivePlayers(int activePlayers) {
        this.activePlayers = activePlayers;
    }
}
