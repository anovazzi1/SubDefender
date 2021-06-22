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
import com.subdefender.game.gui.components.GridTest;
import com.subdefender.game.gui.components.inicializador;

public class subdefenderApp extends Game {

	public static final String NAME = "SubDefender";
	public static final int HEIGHT = 600;
	public static final int WIDTH = 1000;

	//carrega  pacotes de skin dos botões
	public AssetManager manager;
	public Skin skin;
	//tela geral
	public SpriteBatch batch;
	public OrthographicCamera camera;
	//fonte usada no jogo
	public BitmapFont pixel;
	//string que contem o nome do jogador
	public String playerName;
	//telas do jogo
	public Screen firstScreen;
	public Screen nameScreen;
	public Screen battleship;
	public Screen settings;
	public Screen alocate;
	// estado da musica do jogo
	private boolean isMusicPlaying = true;
	//dificuldade do jogo
	private int dificult=1;
	//numero de vidas
	private int lifeCounter= 5;
	//vetor com situação dos submarinos True: vivo, Falso:morto.
	private boolean[] subStatus;
	//vetor que mostra qual bala foi selecionada
	private boolean[] selectedBullet;
	//vetor com o numero de balas de cada bala
	private int[] ammo;
	//coordenadas de cada submarino no mar
	public String[] subCords;
	//string com coordenada do tiro
	public String tiros;
	//ponteiros para matriz real que armazena as coordenadas
	public GridTest testeP;
	public GridTest testeB;

	@Override
	public void create () {
		//inicializador do EventListener
		inicializador.setGame(this);
		//configurações iniciais
		camera = new OrthographicCamera();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,480,720);
		batch = new SpriteBatch();
		manager = new AssetManager();
		//configurações da fonte
		pixel = new BitmapFont(Gdx.files.internal("fonts/Pixeboy-z8XGD.ttf/Pixeboy-z8XGD.fnt"));
		pixel.getData().setScale(1.5f,1.5f);
		skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
		// inicialzação dos dados que serão usados pelo backend
		subStatus = new boolean[5];
		selectedBullet = new boolean[3];
		ammo = new int[3];
		subCords = new String[5];
		testeB = new GridTest(true);
		testeP = new GridTest(false);
		initSubs();
		initBullets();
		initAmmo();
		//inicialização das telas
		nameScreen = new inputScreen(this);
		firstScreen = new welcomeScreen(this);
		battleship = new gameScreen(this);
		settings = new configScreen(this);
		alocate = new alocateScreen(this);
		//muda para tela inicial
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
		firstScreen.dispose();
		nameScreen.dispose();
		settings.dispose();
	}

	public boolean getisMusicPlaying() {
		return isMusicPlaying;
	}

	public void setMusicPlaying(boolean musicPlaying) {
		this.isMusicPlaying = musicPlaying;
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

	//verificacao que sera mudada para o backend
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
	//verificacao que sera mudada para o backend
	private void initAmmo()
	{
		ammo[0] = 15;
		ammo[1] = 8;
		ammo[2] = 5;
	}

	//verificação que sera mudada para o backend
	public void updateAmmo()
	{
		if(ammo[getSelectedBullet()]>0){
			ammo[getSelectedBullet()]--;
		}
	}

}
