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
	public welcomeScreen firstScreen;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		manager = new AssetManager();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,480,720);
		firstScreen = new welcomeScreen(this);
		this.setScreen(firstScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		manager.dispose();
		firstScreen.dispose();
	}
}
