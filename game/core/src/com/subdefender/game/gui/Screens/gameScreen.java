package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.gui.components.*;
import com.subdefender.game.subdefenderApp;

public class gameScreen implements Screen {

    private final subdefenderApp game;
    private Stage stage;
    private Image title;
    private Image heart;
    private submarines subs;
    private bullets balas;
    private grid campoJ;
    private grid campoB;
    private cordTemplate cordenadas;
    private inputCord cordTiro;
    private buttons shootButton;
    private int[] tiroCord = new int[2];
    private sound shootSound;
    private erroCordInvalida erro = new erroCordInvalida(430, 30);
    private erroCordInvalida erro;

    public gameScreen(subdefenderApp game)
    {
        this.game = game;
        title = new smallTitle();
        heart = new heartLogo(game);
        subs = new submarines(game);
        balas = new bullets(game);
        stage = new Stage();
        //IMPORTANTE, NÃO ALTERAR
        campoJ = new grid(stage, false);
        campoB = new grid(stage, true);
        //IMPORTANTE, NÃO ALTERAR
        cordTiro = new inputCord("", game.skin, 10, -250);
        cordenadas = new cordTemplate(game);
        shootButton = new buttons(game);
        shootSound = new sound("sounds/470084__sheyvan__underwater-deep-impact.mp3");
        shootButton.shootButton();
        erro = new erroCordInvalida();
        erro.setPosition(200,80);
        stage.addActor(shootButton.shoot);
        stage.addActor(cordTiro);
        stage.addActor(title);
        stage.addActor(heart);
        subs.addActors(stage);
        balas.addActors(stage);
        stage.addActor(erro);

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        shootButton.shoot.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y){
                                                if (tratarCoord(cordTiro.getText()) && game.validateCoord(tiroCord[0], tiroCord[1])){
                                                    System.out.println(tiroCord);
                                                    if(game.playerShot(tiroCord[0], tiroCord[1])){
                                                        shootSound.play();
                                                        if(game.botShot()){
                                                            shootSound.play();
                                                        }
                                                        game.krakenAttack();
                                                    }

                                                    erro.setVisible(false);
                                                }else {
                                                    erro.showError();   //TODO - coordenadas de tiro invalidas
                                                }
                                                cordTiro.setText("");

                                            }
                                        }
        );

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        subs.checkStatus();
        stage.act(delta);
        stage.draw();
        //informações estaticas na tela
        game.batch.begin();
        {
            game.pixel.draw(game.batch, "bot", 640, 500);
            game.pixel.draw(game.batch, game.getPlayerName(), 240, 500);
            game.pixel.draw(game.batch, "x", 890, 35);
            game.pixel.draw(game.batch, "x", 45, 35);
            game.pixel.draw(game.batch, "x", 160, 35);
            game.pixel.draw(game.batch, "x", 283, 35);
            game.pixel.draw(game.batch, game.getAmmo(2) + "", 75, 35);
            game.pixel.draw(game.batch, game.getAmmo(1) + "", 190, 35);
            game.pixel.draw(game.batch, game.getAmmo(0) + "", 313, 35);
            game.pixel.draw(game.batch, game.getLifeCounter() + "", 920, 35);

        }
        //printa o esquema de coordenadas
        cordenadas.print(210,180);
        cordenadas.print(600,180);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private boolean tratarCoord(String tiroCord){
        try {
            //Coordenadas inicio
            int Fila = Character.toUpperCase(tiroCord.charAt(0))%65;
            int Coluna = Integer.parseInt(String.valueOf(tiroCord.charAt(1)));

            this.tiroCord[0] = Fila;
            this.tiroCord[1] = Coluna;

            return true;
        }catch (Exception e){
            System.out.println("Coordenadas invalidas! Tente Novamente");
            return false;
        }
    }
}
