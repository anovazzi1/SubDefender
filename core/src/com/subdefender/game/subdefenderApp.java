package com.subdefender.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.subdefender.game.Players.Bot;
import com.subdefender.game.Players.Player;
import com.subdefender.game.gui.Screens.*;
import com.subdefender.game.itens.Submarinos;
import com.subdefender.game.map.Mapa;
import com.subdefender.game.gui.components.inicializador;

import static java.lang.Math.abs;

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


	//telas do jogo
	public Screen firstScreen;
	public Screen nameScreen;
	public Screen battleship;
	public Screen settings;
	public Screen alocate;

	public Screen gameOver;
	public boolean win = true;
	// estado da musica do jogo
	private boolean isMusicPlaying = true;

	//dificuldade do jogo
	private int dificult = 0;

	public Player jogador;
	public Bot bot;

	public Mapa PlayerMap;
	public Mapa BotMap;

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
		jogador = new Player();
		bot = new Bot();
		BotMap = new Mapa(true);
		PlayerMap = new Mapa(false);

		setDificult(0);
		//inicialização das telas
		nameScreen = new inputScreen(this);
		firstScreen = new welcomeScreen(this);
		battleship = new gameScreen(this);
		settings = new configScreen(this);
		alocate = new alocateScreen(this);
		gameOver = new endScreen(this);
		//muda para tela inicial
		this.setScreen(firstScreen);
	}

	private int[] getBotCoords(int i) {
		String caminho = "data/mapaBot.csv";
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(caminho);
		String[] coordenadas = csv.requestCommands();
		String[] coord = coordenadas[i].split(":");
		int inicioFila = coord[0].charAt(0)%65;
		int inicioColuna = Integer.parseInt(String.valueOf(coord[0].charAt(1)));
		int fimFila = coord[0].charAt(3)%65;
		int fimColuna =  Integer.parseInt(String.valueOf(coord[0].charAt(4)));

		int[] subCords = new int[4];
		subCords[0] = inicioFila;
		subCords[1] = inicioColuna;
		subCords[2] = fimFila;
		subCords[3] = fimColuna;
		return subCords;
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

	public int getLifeCounter() { return this.jogador.getLifeCounter(); }
	public void setLifeCounter(int lifeCounter) { this.jogador.setLifeCounter(lifeCounter); }

	public boolean isSubAlocado(int index) {
		return this.jogador.isSubAlocado(index);
	}
	public void alocateSubs(int index, int[] subCords) {
		this.PlayerMap.alocateSub(index+1, subCords, false);
		this.jogador.alocateSub(index,subCords);
		this.BotMap.alocateSub(index+1, getBotCoords(index), true);
		this.BotMap.alocateTesouro(5, 1);
		this.BotMap.alocateTesouro(6, 2);
		this.bot.alocateSub(index, getBotCoords(index));
	}

	public int getSelectedBullet() {
		return this.jogador.getSelectedBullet();
	}
	public void setSelectedBullet(int index) {
		this.jogador.setSelectedBullet(index);
	}
	public int getAmmo(int i) {
		return this.jogador.balas[i].getQuantidade();
	}
	private void setAmmo(int normal, int power1, int power2) {
		this.jogador.balas[0].setQuantidade(normal);
		this.jogador.balas[0].setPoder(0);

		this.jogador.balas[1].setQuantidade(power1);
		this.jogador.balas[1].setPoder(1);

		this.jogador.balas[2].setQuantidade(power2);
		this.jogador.balas[2].setPoder(2);
	}

	public String getPlayerName() {
		return this.jogador.getPlayerName();
	}
	public boolean setPlayerName(String playerName) {
		if (this.jogador.validateName(playerName)){
			this.jogador.setPlayerName(playerName);
			return true;
		}

		return false;
	}

	public boolean validateAlocateSub(int[] subCords, int tamanhoSub) {		//Valida as coordenadas para a alocacao dos submarinos
		return validateCoord(subCords) && validarTamanhoCoords(subCords, tamanhoSub);
	}

	public boolean validateCoord(int[] subCords){
			//Coordenadas inicio
			int inicioFila = subCords[0];
			int inicioColuna = subCords[1];

			//Coordenadas fim
			int fimFila = subCords[2];
			int fimColuna = subCords[3];

			if ((inicioFila < 0 || inicioFila > 9) || (inicioColuna < 0 || inicioColuna > 9) || (fimFila < 0 || fimFila > 9) || (fimColuna < 0 || fimColuna > 9)) {
				System.out.println("Coordenadas além dos limites do tabuleiro. Tente Novamente!");
				return false;
			}

		return true;
	}
	public boolean validateCoord(int Fila, int Coluna){
		if ((Fila < 0 || Fila > 9) || (Coluna < 0 || Coluna > 9)) {
			System.out.println("Coordenadas além dos limites do tabuleiro. Tente Novamente!");
			return false;
		}

		return true;
	}
	public boolean validarTamanhoCoords(int[] subCords, int tamanhoSub) {
		//Coordenadas inicio
		int inicioFila = subCords[0];
		int inicioColuna = subCords[1];

		//Coordenadas fim
		int fimFila = subCords[2];
		int fimColuna = subCords[3];

		if (inicioFila == fimFila) {
			return abs(fimColuna - inicioColuna) + 1 == tamanhoSub;
		}else if (inicioColuna == fimColuna) {
			return abs(fimFila - inicioFila) + 1 == tamanhoSub;
		}
		else {
			return false;
		}
	}

	public boolean playerShot(int fila, int coluna) {
		if (!BotMap.getAtingido(fila, coluna) && jogador.balas[getSelectedBullet()].getQuantidade() > 0){
			if (getSelectedBullet() == 0) {					//Bala Comum
				validarTiro(fila, coluna);
				jogador.balas[getSelectedBullet()].shot();

			}else if (getSelectedBullet() == 2) {			//Tiro em Cruz
				usarPoder(2, fila, coluna);

			}else if (getSelectedBullet() == 1) {
				usarPoder(1, fila, coluna);
			}
			return true;
		}
		else{
			System.out.println("Tiro inválido");
		}
        return false;
    }
	private void usarPoder(int i, int fila, int coluna) {
		if (i == 1) {
			if(BotMap.getOcupado(fila,coluna)) BotMap.setVisible(fila, coluna, true);
			if(BotMap.getOcupado(fila+1, coluna+1))BotMap.setVisible(fila+1, coluna+1, true);
			if(BotMap.getOcupado(fila-1, coluna-1))BotMap.setVisible(fila-1, coluna-1, true);
			if(BotMap.getOcupado(fila+1, coluna))BotMap.setVisible(fila+1, coluna, true);
			if(BotMap.getOcupado(fila, coluna+1))BotMap.setVisible(fila, coluna+1, true);
			if(BotMap.getOcupado(fila-1, coluna))BotMap.setVisible(fila-1, coluna, true);
			if(BotMap.getOcupado(fila, coluna-1))BotMap.setVisible(fila, coluna-1, true);
			jogador.balas[getSelectedBullet()].shot();

		}else if (i == 2) {
			validarTiro(fila, coluna);
			if (fila+1 < 10) validarTiro(fila+1, coluna);
			if(coluna+1 < 10) validarTiro(fila, coluna+1);
			if(fila-1 >= 0) validarTiro(fila-1, coluna);
			if(coluna-1 >= 0)validarTiro(fila, coluna-1);
			jogador.balas[getSelectedBullet()].shot();
		}
	}
	private void validarTiro(int fila, int coluna) {
		if(BotMap.getOcupado(fila, coluna)){
			if (BotMap.getTipo(fila, coluna) == 3){
				BotMap.setAtingido(fila, coluna, true);
				jogador.setScore(1000);
				for (Submarinos submarino: bot.submarinos) {
					if (submarino.getVivo() && submarino.atirar(fila, coluna)){
						bot.submarinoAbatido();
						jogador.setScore(1000);
					}
				}
			}
			else if (BotMap.getTipo(fila, coluna) != 2) {
				BotMap.setAtingido(fila, coluna, true);
				jogador.balas[2].addQuantidade();
			}
			else if (BotMap.getTipo(fila, coluna) != 1) {
				BotMap.setAtingido(fila, coluna, true);
				jogador.balas[1].addQuantidade();
			}
		}else {
			jogador.setScore(-100);
		}
		BotMap.setVisible(fila, coluna, true);
		jogoGanho();
	}

	private void jogoGanho() {
		if (jogador.getFrota() == 0) {
			win = false;
			setScreen(gameOver);

		}else if (bot.getFrota() == 0) {
			win = true;
			setScreen(gameOver);
		}
	}

	public boolean botShot(){
		int[] coordinates = getBotShotCoord();
		if(PlayerMap.getOcupado(coordinates[0], coordinates[1])){
			if (PlayerMap.getTipo(coordinates[0], coordinates[1]) == 3){
				PlayerMap.setAtingido(coordinates[0], coordinates[1], true);
				for (Submarinos submarino: jogador.submarinos) {
					if(submarino.atirar(coordinates[0], coordinates[1])){
						jogador.submarinoAbatido();
					}
				}
			}
		}
		PlayerMap.setVisible(coordinates[0], coordinates[1], true);
		return true;
	}
	public  int[] getBotShotCoord() {
		int[] coordinates = new int[2];
		int fila = getRandomNumber(10);
		int coluna = getRandomNumber(10);

		while (PlayerMap.getVisible(fila, coluna) || !validateCoord(fila, coluna)) {
			fila = getRandomNumber(10);
			coluna = getRandomNumber(10);
		}
		coordinates[0] = fila;
		coordinates[1] = coluna;

		return coordinates;
	}

	int getRandomNumber(int max) {
		return (int) (Math.random() * (max));
	}

	public void setRevivido(int subSize, int inicioFila, int inicioColuna, int fimFila, int fimColuna) {
		if (inicioFila == fimFila) {    //Vertical
			for (int i = 0; i < subSize; i++){
				if(inicioColuna > fimColuna){ i = -1*i; }
				BotMap.setOcupado(inicioFila, inicioColuna+i, true);
				BotMap.setTipo(inicioFila, inicioColuna+i, 3);
				BotMap.setAtingido(inicioFila, inicioColuna+i, false);
				BotMap.setRevivido(inicioFila, inicioColuna+i, true);
				BotMap.setVisible(inicioFila, inicioColuna+i, true);
			}
		}else {      //Horizontal
			for (int i = 0; i < subSize; i++){
				if(inicioFila > fimFila){ i = -1*i; }
				BotMap.setOcupado(inicioFila+i, inicioColuna, true);
				BotMap.setTipo(inicioFila+i, inicioColuna, 3);
				BotMap.setAtingido(inicioFila, inicioColuna+i, false);
				BotMap.setRevivido(inicioFila, inicioColuna+i, true);
				BotMap.setTipo(inicioFila+i, inicioColuna, 3);
				BotMap.setVisible(inicioFila, inicioColuna+i, true);
			}
		}
	}

	public void krakenAttack() {
		Mapa mapa;
		Player player;
		
		if (getRandomNumber(100)%5 == 0) {
			if (getRandomNumber(1) == 0) {
				mapa = PlayerMap;
				player = jogador;
			}else {
				mapa = BotMap;
				player = bot;
			}
			int[] coordinates = getBotShotCoord();
			if(mapa.getOcupado(coordinates[0], coordinates[1])){
				if (mapa.getTipo(coordinates[0], coordinates[1]) == 3){
					mapa.setAtingido(coordinates[0], coordinates[1], true);
					for (Submarinos submarino: player.submarinos) {
						if(submarino.atirar(coordinates[0], coordinates[1])){
							player.submarinoAbatido();
						}
					}
				}
			}
			mapa.setPolvo(coordinates[0], coordinates[1], true);
			mapa.setVisible(coordinates[0], coordinates[1], true);
		}
	}
}
