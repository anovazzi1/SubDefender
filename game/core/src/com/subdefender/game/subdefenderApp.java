package com.subdefender.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subdefender.game.gui.Screens.welcomeScreen;

public class subdefenderApp extends Game {
	public AssetManager manager;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	private welcomeScreen firstScreen = new welcomeScreen(this);

	@Override
	public void create () {
		manager = new AssetManager();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,480,720);
		this.setScreen(firstScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		this.getScreen().dispose();
		manager.dispose();
	}
}
