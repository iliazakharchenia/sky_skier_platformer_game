package com.mygdx.game;

public class Platform {
    private final int timeShift = 5;      // 5/60 sec

    public int x;
    public int y;
    private int width = 250;    //
    private int height = 20;    //
    public float speedX = 0;
    public float speedY = 0;
    private int timer = timeShift;

    public void update() {
        if (timer <= 0) {
            speedY += 1;
            y += speedY * 1;
            timer = timeShift; //reload timer
        }

        timer--;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Platform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Deprecated
    public int getWidth() {
        return width;
    }

    @Deprecated
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
