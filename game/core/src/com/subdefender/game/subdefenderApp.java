package com.subdefender.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.subdefender.game.gui.Screens.configScreen;
import com.subdefender.game.gui.Screens.gameScreen;
import com.subdefender.game.gui.Screens.inputScreen;
import com.subdefender.game.gui.Screens.welcomeScreen;

public class subdefenderApp extends Game {

	public static final String NAME = "SubDefender";
	public static final int HEIGHT = 600;
	public static final int WIDTH = 1000;

	public AssetManager manager;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public BitmapFont pixel;
	public Skin skin;
	public String playerName;
	public welcomeScreen firstScreen;
	public Screen nameScreen;
	public Screen battleship;
	public Screen settings;
	private boolean isMusicPlaying = true;
	private int dificult=1;



	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,480,720);
		batch = new SpriteBatch();
		manager = new AssetManager();
		pixel = new BitmapFont(Gdx.files.internal("fonts/Pixeboy-z8XGD.ttf/Pixeboy-z8XGD.fnt"));
		pixel.getData().setScale(1.5f,1.5f);
		skin = new Skin(Gdx.files.internal("skins/uiskin.json"));

		nameScreen = new inputScreen(this);
		firstScreen = new welcomeScreen(this);
		battleship = new gameScreen(this);
		settings = new configScreen(this);

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
		pixel.dispose();
		skin.dispose();
	}

	public boolean getisMusicPlaying() {
		return isMusicPlaying;
	}

	public void setMusicPlaying(boolean musicPlaying) {
		this.isMusicPlaying = musicPlaying;
	}

	public boolean isMusicPlaying() {
		return isMusicPlaying;
	}

	public int getDificult() {
		return dificult;
	}

	public void setDificult(int dificult) {
		this.dificult = dificult;
	}
}
