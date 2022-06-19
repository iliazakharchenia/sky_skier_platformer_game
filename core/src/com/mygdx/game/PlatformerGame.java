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
	private Texture personTexture, platformTexture1, platformTexture2, platformTexture3;
	private Person person;
	private PlatformContainer platformContainer = new PlatformContainer();
	private PointsCalculator pointsCalculator;
    private BitmapFont font;
	
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
		platformTexture1 = new Texture("core/assets/platform_img.png");
		platformTexture2 = new Texture("core/assets/platform_img.png");
		platformTexture3 = new Texture("core/assets/platform_img.png");
		personTexture = new Texture("core/assets/person_img.png");
		person = new Person(350, 400);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.7f, 0.7f, 0.7f, 1);
		batch.begin();
		batch.draw(platformTexture1,
				platformContainer.platforms[0].x,
				platformContainer.platforms[0].y);
		batch.draw(platformTexture2,
				platformContainer.platforms[1].x,
				platformContainer.platforms[1].y);
		batch.draw(platformTexture3,
				platformContainer.platforms[2].x,
				platformContainer.platforms[2].y);
		batch.draw(personTexture, Person.x, Person.y);
		font.draw(batch, "points: " + Integer.toString(pointsCalculator.getPoints()),30, 550);
		batch.end();
		update();
	}

	public void update() {
		person.update();
		platformContainer.update();
		pointsCalculator.update();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		personTexture.dispose();
		platformTexture1.dispose();
		platformTexture2.dispose();
		platformTexture3.dispose();
	}
}
