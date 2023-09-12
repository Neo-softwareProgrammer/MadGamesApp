package com.example.madgames;

import java.io.Serializable;

public class truthPlayer implements Serializable {
    String name;
    int score;

    public truthPlayer() {
    }

    public truthPlayer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "truthPlayer{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
