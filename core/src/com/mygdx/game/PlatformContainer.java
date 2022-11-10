package com.mygdx.game;

import java.util.Random;

public class PlatformContainer {
    private Platform[] platforms = new Platform[3];
    private Random random = new Random();
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    public void update() {
        isPersonOnPlatform();
        rebuildPlatforms();
        person.setSpeedY(platforms[0].speedY);
        if (!person.isOnPlatform()) {
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
            if (platform.y > 800) {
                platform.y = findLowestPlatformLevel()-300;
                platform.x = random.nextInt(550);
            }
        }
    }

    private boolean isPersonOnPlatform() {
        for (Platform platform: platforms) {
            if (platform.y<person.getY()
                    && person.getY()<(platform.y+20)
                    && person.getX()-20<(platform.x+230)
                    && platform.x-20<person.getX()-20) {
                person.setOnPlatform(true);
                return true;
            }
        }
        person.setOnPlatform(false);
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

    public void resetPlatforms() {
        platforms[0].setX(300);
        platforms[0].setY(300);
        platforms[1].setX(random.nextInt(550));
        platforms[1].setY(platforms[0].getY()-300);
        platforms[2].setX(random.nextInt(550));
        platforms[2].setY(platforms[1].getY()-300);
        for (Platform platform : platforms) {
            platform.setSpeedY(0);
            platform.setSpeedX(0);
        }
    }

    {
        platforms[0] = new Platform(300, 300);
        platforms[1] = new Platform(random.nextInt(550), platforms[0].getY()-300);
        platforms[2] = new Platform(random.nextInt(550), platforms[1].getY()-300);
    }
}
