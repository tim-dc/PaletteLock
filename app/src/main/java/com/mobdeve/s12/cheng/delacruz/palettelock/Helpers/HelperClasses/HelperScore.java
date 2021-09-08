package com.mobdeve.s12.cheng.delacruz.palettelock.Helpers.HelperClasses;

public class HelperScore {

    String level;
    int score;

    public HelperScore(String level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getScore() { return score; }
    public String getLevel() {
        return level;
    }



}
