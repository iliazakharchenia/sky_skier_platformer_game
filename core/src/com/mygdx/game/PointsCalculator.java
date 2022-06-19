package com.mygdx.game;

public class PointsCalculator {
    private int points = 0;
    private boolean stillOnPlatform = false;

    public void update() {
        if (Person.onPlatform && !stillOnPlatform) {
            this.stillOnPlatform = true;
            points++;
        }
        if (!Person.onPlatform && stillOnPlatform) {
            this.stillOnPlatform = false;
        }
    }

    public int getPoints() {
        return this.points;
    }
}
