package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Person {
    public static int x;
    public static float y;
    public static boolean onPlatform = false;
    private int width = 40;    //
    private int height = 40;    //
    public static float speedX = 0;
    public static float speedY = 0;
    private final int timeShift = 3;      // 3 frames
    private int timer = timeShift;

    public void update() {
        if (timer <= 0) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && onPlatform) {
                speedX += 0.7;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && onPlatform) {
                speedX -= 0.7;
            }
            timer = timeShift; //reload timer
        }
        x += speedX * 1;
        if (x>800) x = 0;
        if (x<0) x = 800;

        timer--;
    }

    public void resetPerson() {
        x = 350;
        y = 400;
        onPlatform = false;
        this.setSpeedX(0);
        this.setSpeedY(0);
        timer = timeShift;
    }

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        onPlatform = false;
    }

    public int getTimer() {
        return timer;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public static int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
