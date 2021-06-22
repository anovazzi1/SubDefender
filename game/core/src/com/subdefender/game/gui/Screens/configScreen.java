package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.gui.components.buttons;
import com.subdefender.game.gui.components.gameTitle;
import com.subdefender.game.subdefenderApp;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;

public class configScreen implements Screen {

    final private subdefenderApp game;
    private Image logo;
    private Stage stage;
    private buttons configurations;


    public configScreen(subdefenderApp game)
    {
        this.game = game;
        logo = new gameTitle();
        stage = new Stage();
        stage.addActor(logo);
        configurations = new buttons(game);



    }

    @Override
    public void show() {
        //animação do titulo
        Gdx.input.setInputProcessor(this.stage);
        logo.addAction(after(repeat(100,
                sequence(moveBy(0,-40,1.7f),moveBy(0,40,1.7f)))));
        initButtons();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        game.batch.begin();
        game.pixel.draw(game.batch,"Dificuldade Atual",20,320);
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

    }

    public void initButtons(){
        //inicializa os botões
        configurations.dificultButton();
        configurations.soundController();
        configurations.backButton();
        stage.addActor(configurations.level);
        stage.addActor(configurations.back);
        stage.addActor(configurations.soundController);
    }
}
