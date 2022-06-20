package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class PersonCostumeChanger {
    private Texture[] leftCostumes;
    private Texture[] rightCostumes;
    public Texture personTexture;
    private int currentLeftCostumeNum = 0;
    private int currentRightCostumeNum = 0;
    private final int delay = 10; //10 frames delay for costume change
    private int timer = 0;
    private boolean lastRightKeyPressed = true; //if false - left key

    public PersonCostumeChanger(Texture[] leftCostumes, Texture[] rightCostumes,
                                Texture personStartTexture) {
        this.leftCostumes = leftCostumes;
        this.rightCostumes = rightCostumes;
        this.personTexture = personStartTexture;
    }

    public void update() {
        if (timer<delay) {
            timer++;
            return;
        }
        timer = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Person.onPlatform) {
            currentLeftCostumeNum = 0;
            if (currentRightCostumeNum<rightCostumes.length-1) currentRightCostumeNum++;
            else currentRightCostumeNum = 0;
            personTexture = rightCostumes[currentRightCostumeNum];
            lastRightKeyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Person.onPlatform) {
            currentRightCostumeNum = 0;
            if (currentLeftCostumeNum<leftCostumes.length-1) currentLeftCostumeNum++;
            else currentLeftCostumeNum = 0;
            personTexture = leftCostumes[currentLeftCostumeNum];
            lastRightKeyPressed = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Person.onPlatform) {
            currentLeftCostumeNum = 0;
            currentRightCostumeNum = 0;
            personTexture = rightCostumes[0];
            lastRightKeyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Person.onPlatform) {
            currentLeftCostumeNum = 0;
            currentRightCostumeNum = 0;
            personTexture = leftCostumes[0];
            lastRightKeyPressed = false;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Person.onPlatform && lastRightKeyPressed) {
            currentLeftCostumeNum = 0;
            currentRightCostumeNum = 0;
            personTexture = rightCostumes[0];
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.LEFT) && Person.onPlatform && !lastRightKeyPressed) {
            currentLeftCostumeNum = 0;
            currentRightCostumeNum = 0;
            personTexture = leftCostumes[0];
        }
    }
}
