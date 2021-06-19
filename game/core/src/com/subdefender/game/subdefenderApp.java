package com.subdefender.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.subdefender.game.gui.Screens.*;

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
	public Screen alocate;
	private boolean isMusicPlaying = true;
	private int dificult=1;
	private int lifeCounter= 5;
	private boolean[] subStatus;
	private boolean[] selectedBullet;
	private int[] ammo;
	public String[] subCords;

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
		subStatus = new boolean[5];
		selectedBullet = new boolean[3];
		ammo = new int[3];
		subCords = new String[5];
		initSubs();
		initBullets();
		initAmmo();
		nameScreen = new inputScreen(this);
		firstScreen = new welcomeScreen(this);
		battleship = new gameScreen(this);
		settings = new configScreen(this);
		alocate = new alocateScreen(this);

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

	public int getLifeCounter() {
		return lifeCounter;
	}

	public void setLifeCounter(int lifeCounter) {
		this.lifeCounter = lifeCounter;
	}

	public boolean getSubStatus(int index) {
		return subStatus[index];
	}

	public void setSubStatus(boolean status, int index) {
		this.subStatus[index] = status;
	}

	public int getSelectedBullet()
	{


		for(int i = 0;i< selectedBullet.length;i++)
		{
			if(selectedBullet[i])
			{
				return i;
			}
		}
		return 404;
	}

	public void setSelectedBullet(int index) {
		for(int i =0;i<this.selectedBullet.length;i++)
		{
			this.selectedBullet[i] = false;
		}
		this.selectedBullet[index] = true;
	}

	public int getAmmo(int i) {
		return ammo[i];
	}

	private void initSubs()
	{
		for(int i=0;i<5;i++) {
			this.subStatus[i] = true;
		}
	}

	private void initBullets()
	{
		for(int i =0;i< selectedBullet.length;i++)
		{
			this.selectedBullet[i] = false;
		}
		selectedBullet[0] = true;
	}

	private void initAmmo()
	{
		ammo[0] = 15;
		ammo[1] = 8;
		ammo[2] = 5;
	}

	public void updateAmmo()
	{
		if(ammo[getSelectedBullet()]>0){
			ammo[getSelectedBullet()]--;
		}
	}


}
