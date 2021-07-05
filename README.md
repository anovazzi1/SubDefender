
![Logo Subdefender](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/titulo_800_200px_1.png)


* [Equipe](#equipe)
* [Vídeos do Projeto](https://www.youtube.com/watch?v=hKskdlDX58Y)
* [Slides do Projeto](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/SUBDEFENDER.pptx)
* [Diagramas](#diagramas)

# Projeto SubDefender

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SUBDEFENDER é um jogo que se passa em um cenário de guerra onde o jogador é um general que deve usar de estratégia para posicionar e defender sua frota de ameaças submarinas, sejam elas humanas ou não. Para isso, o jogador tem à sua disposição alguns torpedos com os quais ele deve abater os submarinos inimigos que estão espalhados aleatoriamente pelo mapa. Além de sobreviver às ameaças humanas, o nosso general deve enfrentar o Kraken, uma criatura mítica e destruidora com o poder de destruir toda uma frota submarina. O jogo acaba quando todos os submarinos inimigos forem destruídos.


# Equipe:
Fernando dos R. S. Filho - 234471

Otavio Anovazzi - 186331

# Vídeos do Projeto
[Vídeo da Prévia](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/subdefender.mp4)

[Vídeo da Apresentação Final](https://www.youtube.com/watch?v=hKskdlDX58Y)


# Slides do Projeto
[Slides da Prévia](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/SUBDEFENDER.pptx)

[Slides da Apresentação Final](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/SUBDEFENDER.pptx)

## Relatório de Evolução
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SUBDEFENDERS foi um jogo que surgiu com a ideia de modernizar o clássico. Suas maiores inspirações foram Batalha Naval e Space Invaders. Assim, o primeiro desafio foi saber como implementar os conceitos apresentados por esses jogos clássicos, porém acrescentando features modernas e que venham utilizar as técnicas de orientação à objeto aprendido em sala de aula. Neste desafio uma das partes em que mais focamos foi criar novas features para o jogo. Em um momento de brainstorming levantamos a possibilidade de implementar um bot pseudo-inteligente que contra atacasse a frota do jogador de forma precisa, implementar novas balas com habilidades diferentes e ainda inserir um chefão polvo para interferir no meio da batalha submarina e ser oponente final em uma batalha estilo Space Invaders. Após usar a criatividade na concepção inicial do jogo, partimos para um planejamento estruturado: decidimos a LIBGDX como biblioteca a ser usada na interface gráfica, esboçamos ideias para a arquitetura do jogo e buscamos referencias de como os jogos clássicos eram implementados.
 
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Feito o planejamento do jogo partimos para a execução. Ao iniciar o jogo o jogador será apresentado a uma interface gráfica cuja  tela inicial lhe dará a opção de escolha entre clicar no botão “JOGAR”, que dá início ao jogo, ou clicar no botão “CONFIG”, que permite o jogador alterar a dificuldade e as configurações de som do jogo. Em seguida, o jogador terá que escolher o seu nome. Após a escolha do nome, o jogador escolherá a posição de cada um dos 5 submarinos da sua frota, que variam de tamanho 1 até 5, em um mapa de 10x10 coordenadas. Assim, o jogo se inicia. A  Fase 1 do jogo possui jogabilidade inspirada no clássico Batalha Naval onde jogador e bot se intercalam escolhendo coordenadas do campo adversário para descobrir, acertar e afundar os submarinos inimigos. 
   
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O jogador começa com um número inicial de torpedos e vidas, dependendo da dificuldade escolhida, e um score inicial de 1000 pontos. A cada rodada o jogador escolhe uma coordenada para lançar um torpedo, podendo desperdiçar uma bala acertando a água, acertar parte ou a totalidade de um submarino inimigo ou encontrar torpedos com habilidades especiais espalhados aleatoriamente pelo mapa.Se um dos seus submarinos for derrubado, ele possui a possibilidade de sacrificar uma de suas vidas para consertar um submarino afundado. Como o Kraken é uma ameaça não humana que está a solta nos mares, durante alguns momentos da Fase 1 será possível ver alguns de seus tentáculos emergindo tanto do campo do jogador quanto do seu adversário, podendo danificar as partes dos submarinos que estiverem naquelas coordenadas. Se o jogador afundar todos os submarinos inimigos antes de ter a sua frota inteira destruída ele ganha o jogo.

# Destaques de Código

Responsável por iniciar a aplicação:
~~~java
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle(subdefenderApp.NAME);
		config.setWindowedMode(subdefenderApp.WIDTH,subdefenderApp.HEIGHT);
		config.setResizable(false);
		new Lwjgl3Application(new subdefenderApp(), config);
	}
}
~~~
~~~java
   public void show() {
        initButtons();
        Gdx.input.setInputProcessor(stage);
        //captura o nome do jogador e prende a variavel game.playerName
        inputButton.iniciar.addListener(new ClickListener(){
                                          @Override
                                          public void clicked(InputEvent event, float x, float y){
                                              playerName = nameInput.getText();
                                              if (game.setPlayerName(playerName)){
                                                  game.setScreen(game.alocate);
                                              }
                                              else{
                                                  erro.showError();
                                                  nameInput.setText("");
                                              }
                                          }
                                      }
        );
    }
    
 ~~~
 ~~~java


    public interface statusListener {
//interface usada para ligar o as matrizes por meio de eventos
    void statusChanged(subdefenderApp game);

}
 
~~~
~~~java

public class bulletListener extends ClickListener {
// coordena a seleção das balas
    private Image atual;
    private final subdefenderApp game;
    private int i;
    public bulletListener(Image atual, subdefenderApp game, int index)
    {
        super();
        this.atual = atual;
        this.game = game;
        this.i = index;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        setTapCountInterval(1f);
        if (getTapCount() < 2) {
            atual.addAction(Actions.sequence(
                    Actions.moveBy(0, 10),
                    Actions.fadeOut(0.5f),
                    Actions.fadeIn(0.5f),
                    Actions.moveBy(0, -10)
            ));
        }
        game.setSelectedBullet(i);
    }

~~~
~~~java

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

~~~



# Conclusões e Trabalhos Futuros
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Durante o processo de desenvolvimento nos deparamos com alguns desafios. Um destes desafios foi a organização do tempo. Alocamos bastante tempo para a organização do desenvolvimento do jogo, escolhemos  uma boa arquitetura e uma potente biblioteca de interface visual, porém o pouco tempo alocado para o desenvolvimento, além da necessidade de familiarização com os processos de desenvolvimento de software orientado à objetos, impediu que conseguissemos implementar a arquitetura desejada e algumas features. Usar a biblioteca LIBGDX embora tenha consumido muito tempo do desenvolvimento para aprender a utilizar a ferramente, foi um dos diferenciais do nosso projeto. Essa biblioteca permitiu controlarmos a interface gráfica de forma bem eficaz usando, principalmente, listeners pra realizar as trocas de tela de forma sincronizada com as ações do usuário. Outro ponto forte do nosso jogo foram as artes, animações e sons inspirados nos clássicos jogosn 8-bit. Pensando no futuro do jogo temos como meta inserir features que ficaram de fora, como a batalha final contra o boss ao estilo Space Invaders, implementar uma arquitetura baseada em componentes, permitindo, assim, maior modularização e independência dos componentes e, por fim, fazer maior uso da LIBGDX com o objetivo de permitir a compatibilidade do jogo com o sistema Android e suas APKs.
   
   ** Caro professor, após a nossa apresentação o senhor tinha permitido fazer uma ¨limpa¨ na documentação e na arquitetura do jogo para maior organização e legibilidade. Durante a semana nós organizamos nossa arquitetura de acordo com o descrito aqui nesta documentação. Porém ao trocar branch o estado final do nosso jogo acabou sendo sobrescrito e a organização da arquitetura foi perdida, depois de muito esforço e quase perdendo o repositório, conseguimos voltar ao estado original do nosso jogo. Esperamos que o senhor possa considerar os demais elementos trabalhados nesse jogo.
   
# Diagramas

## Diagrama Geral do Projeto

![Arquitetura](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/Arquitetura.png)

## Componente Controller

![Controller](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/Controller.png)

# Componente GUI

![GUI](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/GUI.png)

# Componente Map

![Map](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/Map.png)


# Componente Players

![Players](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/Players.png)

# Componente Items

![Items](https://github.com/otavioanovazzi/SubDefender/blob/main/assets/ArquiteturaSubDefenders/Inventory.png)


<!-- ## Diagrama Geral do Componentes

### Componente 

## Detalhamento das Interfaces

# Plano de Exceções 

## Diagrama da hierarquia de exceções

## Descrição das classes de exceção -->



