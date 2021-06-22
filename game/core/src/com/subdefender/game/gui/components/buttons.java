package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.gui.Screens.welcomeScreen;
import com.subdefender.game.subdefenderApp;

public class buttons {
    private Skin skin;
    final subdefenderApp game;
    public TextButton jogar;
    public TextButton sair;
    public TextButton iniciar;
    public TextButton config;
    public TextButton level;
    public TextButton soundController;
    public TextButton back;
    public TextButton alocate;
    static private String Atual = "normal";
    public TextButton shoot;

    public buttons(subdefenderApp game)
    {
        //configurações dos botões
        this.game = game;
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        game.manager.load("skins/uiskin.atlas", TextureAtlas.class);
        game.manager.finishLoading();
        skin.addRegions(this.game.manager.get("skins/uiskin.atlas", TextureAtlas.class));
    }

    public void playButton()
    {
        //botao da tela inicial de jogar
        jogar = new TextButton("jogar",skin,"default");
        jogar.setPosition(400,260);
        jogar.setSize(200,100);
        jogar.addListener(new ClickListener(){
                             @Override
                             public void clicked(InputEvent event, float x, float y){
                                 game.setScreen(game.nameScreen);
                             }
                         }
        );

    }

    public void exitButton()
    {
        //botão de sair do jogo
        sair = new TextButton("sair",skin,"default");
        sair.setPosition(400,120);
        sair.setSize(200,100);
        sair.addListener(new ClickListener(){
                             @Override
                             public void clicked(InputEvent event, float x, float y){
                                 Gdx.app.exit();
                             }
                         }
        );
    }

    public void startButton()
    {
        //botão que pega o nome do jogador
        iniciar = new TextButton("iniciar",skin,"default");
        iniciar.setPosition(700,260);
        iniciar.setSize(120,50);
    }

    public void configButton()
    {
        //botão que vai até a tela de configurações
        config = new TextButton("config",skin,"default");
        config.setPosition(800,60);
        config.setSize(120,50);
        config.addListener(new ClickListener(){
                              @Override
                              public void clicked(InputEvent event, float x, float y){
                                  game.setScreen(game.settings);
                              }
                          }
        );
    }

    public void dificultButton()
    {
        //botão que seleciona a dificuldade
        level = new TextButton(Atual,skin,"default");
        level.setPosition(400,260);
        level.setSize(200,100);
        level.addListener(new ClickListener(){
                                        @Override
                                        public void clicked(InputEvent event, float x, float y){

                                            if(game.getDificult() == 1)
                                            {
                                                game.setDificult(2);
                                                level.setText("dificil");
                                                buttons.Atual = "dificil";
                                            }
                                            else if(game.getDificult() ==2)
                                            {
                                                game.setDificult(0);
                                                level.setText("facil");
                                                buttons.Atual = "facil";

                                            }
                                            else if(game.getDificult() == 0)
                                            {
                                                game.setDificult(1);
                                                level.setText("normal");
                                                buttons.Atual ="normal";
                                            }

                                        }
                                    }
        );
    }

    public void backButton()
    {
        //botão que volta a tela incial
        back = new TextButton("voltar",skin,"default");
        back.setPosition(800,60);
        back.setSize(120,50);
        back.addListener(new ClickListener(){
                               @Override
                               public void clicked(InputEvent event, float x, float y){
                                   game.firstScreen.dispose();
                                   game.firstScreen = new welcomeScreen(game);
                                   game.setScreen(game.firstScreen);
                               }
                           }
        );
    }

    public void soundController()
    {
        //botão que controla o som da musica tema
        soundController = new TextButton("som",skin,"default");
        soundController.setPosition(400,120);
        soundController.setSize(200,100);
        soundController.addListener(new ClickListener(){
                               @Override
                               public void clicked(InputEvent event, float x, float y){
                                   if(game.getisMusicPlaying())
                                   {
                                       themeMusic.pause();
                                       soundController.setText("Som: desligado");
                                       game.setMusicPlaying(false);
                                   }
                                   else
                                   {
                                       soundController.setText("som: ligado");
                                       themeMusic.play();
                                       game.setMusicPlaying(true);
                                   }

                               }
                           }
        );
    }

    public void alocateButton()
    {
        //botão que envia a coordenada dos navios
        alocate = new TextButton("alocar",skin,"default");
        alocate.setPosition(700,260);
        alocate.setSize(120,50);
    }

    public void shootButton()
    {
        //botão que atira
        shoot = new TextButton("ATIRAR", skin, "default");
        shoot.setPosition(630,10);
        shoot.setSize(100,50);

    }

    public void dispose()
    {
        skin.dispose();

    }

}
