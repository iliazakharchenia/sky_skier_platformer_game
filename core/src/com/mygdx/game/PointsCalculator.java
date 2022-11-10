package com.mygdx.game;

public class PointsCalculator {
    private int points = 0;
    private boolean stillOnPlatform = false;
    private int heightOfFlight = 0;
    private Person person;

    public void update() {
        calculateHeight();
        if (PlatformerGame.needToReset) {
            resetPoints();
            return;
        }
        if (person.isOnPlatform() && !stillOnPlatform) {
            this.stillOnPlatform = true;
            points++;
        }
        if (!person.isOnPlatform() && stillOnPlatform) {
            this.stillOnPlatform = false;
        }
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPoints() {
        return this.points;
    }

    private void calculateHeight() {
        if (person.isOnPlatform()) heightOfFlight = 0;
        else if (person.getTimer() == 1) heightOfFlight += person.getSpeedY();
        if (heightOfFlight > 700) PlatformerGame.needToReset = true;
    }

    private void resetPoints() {
        points = 0;
        stillOnPlatform = false;
        heightOfFlight = 0;
    }
}
