package com.mobdeve.s12.cheng.delacruz.palettelock;

public class ScoreModel {
    private int score, level;


    public ScoreModel(){
    }

    public ScoreModel(int score, int level) {
        this.score = score;
        this.level = level;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

