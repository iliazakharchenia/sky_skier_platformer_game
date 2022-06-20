package com.mygdx.game;

import java.util.Random;

public class PlatformContainer {
    public Platform[] platforms = new Platform[3];
    private Random random = new Random();

    public void update() {
        isPersonOnPlatform();
        rebuildPlatforms();
        if (!Person.onPlatform) {
            for (Platform platform : platforms) {
                platform.update();
            }
        } else {
            for (Platform platform : platforms) {
                platform.setSpeedY(0);
            }
        }
    }

    private void rebuildPlatforms() {
        for (Platform platform : platforms) {
            if (platform.y>800) {
                platform.y = findLowestPlatformLevel()-300;
                platform.x = random.nextInt(550);
            }
        }
    }

    private boolean isPersonOnPlatform() {
        for (Platform platform: platforms) {
            if (platform.y<Person.y
                    && Person.y<(platform.y+20)
                    && Person.x-20<(platform.x+230)
                    && platform.x-20<Person.x-20) {
                Person.onPlatform = true;
                return true;
            }
        }
        Person.onPlatform = false;
        return false;
    }

    //returns Y value of the lowest platform
    private int findLowestPlatformLevel() {
        int lowestPlatformY = 600;
        for (Platform platform: platforms) {
            if (platform.y<lowestPlatformY) lowestPlatformY = platform.y;
        }
        return lowestPlatformY;
    }

    {
        platforms[0] = new Platform(300, 300);
        platforms[1] = new Platform(random.nextInt(550), platforms[0].getY()-300);
        platforms[2] = new Platform(random.nextInt(550), platforms[1].getY()-300);
    }
}
