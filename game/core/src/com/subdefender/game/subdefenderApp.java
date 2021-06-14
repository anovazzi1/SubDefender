package com.subdefender.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subdefender.game.welcome.screen;

public class subdefenderApp extends Game {
	SpriteBatch batch;
	screen staticBackground;


	@Override
	public void create () {
		staticBackground = new screen();
		staticBackground.create();
		batch = new SpriteBatch();

	}

	@Override
	public void render () {

		batch.begin();
		batch.draw(staticBackground.getImg(),120, 430);
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		staticBackground.dispose();
	}
}
