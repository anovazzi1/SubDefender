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
	private String playerName;
	//telas do jogo
	public Screen firstScreen;
	public Screen nameScreen;
	public Screen battleship;
	public Screen settings;
	public Screen alocate;
	// estado da musica do jogo
	private boolean isMusicPlaying = true;
	//dificuldade do jogo
	private int dificult = 0;
	//numero de vidas
	private int lifeCounter = 10;
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
	public boolean[] alocateSubs;

	@Override
	public void create() {
		//inicializador do EventListener
		inicializador.setGame(this);
		//configurações iniciais
		camera = new OrthographicCamera();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 720);
		batch = new SpriteBatch();
		manager = new AssetManager();
		//configurações da fonte
		pixel = new BitmapFont(Gdx.files.internal("fonts/Pixeboy-z8XGD.ttf/Pixeboy-z8XGD.fnt"));
		pixel.getData().setScale(1.5f, 1.5f);
		skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
		// inicialzação dos dados que serão usados pelo backend
		subStatus = new boolean[5];
		selectedBullet = new boolean[3];
		alocateSubs = new boolean[5];
		ammo = new int[3];
		subCords = new String[5];
		testeB = new GridTest(true);
		testeP = new GridTest(false);
		initSubs();
		initalocate();
		initBullets();
		setDificult(0);
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
	public void render() {
		super.render();
	}


	@Override
	public void dispose() {
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
		switch (dificult) {
			case 2:
				setLifeCounter(3);
				setAmmo(30, 0, 0);
				break;
			case 1:
				setLifeCounter(5);
				setAmmo(60, 1, 0);
				break;
			default:
				setLifeCounter(10);
				setAmmo(100, 1, 1);
				break;
		}
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

	public int getSelectedBullet() {
		for (int i = 0; i < selectedBullet.length; i++) {
			if (selectedBullet[i]) {
				return i;
			}
		}
		return 404;
	}

	public void setSelectedBullet(int index) {
		for (int i = 0; i < this.selectedBullet.length; i++) {
			this.selectedBullet[i] = false;
		}
		this.selectedBullet[index] = true;
	}

	public int getAmmo(int i) {
		return ammo[i];
	}

	private void initSubs() {
		for (int i = 0; i < 5; i++) {
			this.subStatus[i] = true;
		}
	}

	private void initalocate() {
		for (int i = 0; i < 5; i++) {
			this.alocateSubs[i] = false;
		}
		alocateSubs[0] = true;
	}

	private void initBullets() {
		for (int i = 0; i < selectedBullet.length; i++) {
			this.selectedBullet[i] = false;
		}
		selectedBullet[0] = true;
	}

	//verificacao que sera mudada para o backend
	private void setAmmo(int normal, int power1, int power2) {
		ammo[0] = normal;
		ammo[1] = power1;
		ammo[2] = power2;
	}

	//verificação que sera mudada para o backend
	public void updateAmmo() {
		if (ammo[getSelectedBullet()] > 0) {
			ammo[getSelectedBullet()]--;
		}
	}

	public String getName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean validateName(String playerName) {
		if (playerName.length() > 17 || playerName.length() == 0) {
			System.out.println("Nome muito grande ou nao foi inserido.");    //TODO - implementar o aviso de nome excedendo o limite de caracteres ou nome nao inserido
			return false;
		}
		return true;
	}

	public boolean validateAlocateSub(String subCords, int tamanhoSub) {		//Valida as coordenadas para a alocacao dos submarinos
//		 if (validateCoord(subCords) && validarTamanhoCoords(subCords, tamanhoSub) && validarInterseccaoSubs(subCords, tamanhoSub)){
//			 return true;
//		}
		return true;
	}

	private boolean validarInterseccaoSubs(String subCords, int tamanhoSub) {
//		//Coordenadas inicio
//		int inicioFila = Character.toUpperCase(subCords.charAt(0));
//		int inicioColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));
//
//		//Coordenadas fim
//		int fimFila = Character.toUpperCase(subCords.charAt(0));
//		int fimColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));
//
//		for (int i = 0; i < tamanhoSub; i++){
//			// Line AB represented as a1x + b1y = c1
//			double a1 = B.y - A.y;
//			double b1 = A.x - B.x;
//			double c1 = a1*(A.x) + b1*(A.y);
//
//			// Line CD represented as a2x + b2y = c2
//			double a2 = D.y - C.y;
//			double b2 = C.x - D.x;
//			double c2 = a2*(C.x)+ b2*(C.y);
//
//			double determinant = a1*b2 - a2*b1;
//
//			if (determinant == 0)
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//				System.out.println("Coordenadas escolhidas interceptam um navio ja alocado. Tente Novamente!");	//TODO - Implementar aviso
//			}
//		}

		return true;
	}

	public boolean validateCoord(String subCords){
		try {
			//Coordenadas inicio
			int inicioFila = Character.toUpperCase(subCords.charAt(0));
			int inicioColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));

			//Coordenadas fim
			int fimFila = Character.toUpperCase(subCords.charAt(0));
			int fimColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));

			if ((inicioFila < 'A' || inicioFila > 'J') || (inicioColuna < 0 || inicioColuna > 9) || (fimFila < 'A' || fimFila > 'J') || (fimColuna < 0 || fimColuna > 9)) {
				System.out.println("Coordenadas além dos limites do tabuleiro. Tente Novamente!");	//TODO - implementar aviso
				return false;
			}
		}catch (Exception e){
			System.out.println("Coordenadas invalidas! Tente Novamente");	//TODO - Implementar aviso
			return false;
		}
		return true;
	}

	public boolean validarTamanhoCoords(String subCords, int tamanhoSub) {
		//Coordenadas inicio
		int inicioFila = Character.toUpperCase(subCords.charAt(0));
		int inicioColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));

		//Coordenadas fim
		int fimFila = Character.toUpperCase(subCords.charAt(0));
		int fimColuna = Integer.parseInt(String.valueOf(subCords.charAt(1)));

		if (inicioFila == fimFila || inicioColuna == fimColuna) {
			return fimFila - inicioFila + 1 == tamanhoSub || fimColuna - inicioColuna + 1 == tamanhoSub;
		}
		else {
			return false;
		}
	} //TODO  Implementar aviso
}
