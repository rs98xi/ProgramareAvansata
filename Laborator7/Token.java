package com.company;

public class Token implements Comparable<Token>{
    private Integer token;

    public Token(Integer token) {
        this.token = token;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public int compareTo(Token token)
    {
        return this.getToken() - token.getToken();
    }
}
