package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlatformerGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture personTexture, platformTexture;
	private Person person;
	private PlatformContainer platformContainer = new PlatformContainer();
	private PointsCalculator pointsCalculator;
    private BitmapFont font;
    private PersonCostumeChanger personCostumeChanger;
    public static boolean needToReset = false;
	
	@Override
	public void create() {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 25;
        FreeTypeFontGenerator generator =
                new FreeTypeFontGenerator(Gdx.files.local("AlfaSlabOne-Regular.ttf"));
		font = generator.generateFont(parameter);
		generator.dispose();

		batch = new SpriteBatch();
		pointsCalculator = new PointsCalculator();
		platformTexture = new Texture(Gdx.files.local("platform.png"));
		personTexture = new Texture(Gdx.files.local("sprinter_right_1.png"));
		person = new Person(350, 400);
		pointsCalculator.setPerson(person);
		platformContainer.setPerson(person);

		Texture[] leftTextures = {new Texture(Gdx.files.local("sprinter_left_1.png")),
			new Texture(Gdx.files.local("sprinter_left_2.png"))};
		Texture[] rightTextures = {new Texture(Gdx.files.local("sprinter_right_1.png")),
				new Texture(Gdx.files.local("sprinter_right_2.png"))};

		personCostumeChanger = new PersonCostumeChanger(leftTextures, rightTextures, personTexture);
		personCostumeChanger.setPerson(person);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.7f, 0.7f, 0.7f, 1);
		batch.begin();
		for (Platform platform: platformContainer.getPlatforms()) {
			batch.draw(platformTexture, platform.x, platform.y);
		}
		batch.draw(personCostumeChanger.personTexture, person.getX(), person.getY());
		font.draw(batch, "points: " + pointsCalculator.getPoints(),30, 550);
		batch.end();
		update();
	}

	public void update() {
	    if (needToReset) {
	        person.resetPerson();
	        platformContainer.resetPlatforms();
	        needToReset = false;
        }
		person.update();
		platformContainer.update();
		pointsCalculator.update();
		personCostumeChanger.update();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		personTexture.dispose();
		platformTexture.dispose();
	}
}
