package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.gui.components.*;
import com.subdefender.game.subdefenderApp;

public class gameScreen implements Screen {

    private subdefenderApp game;
    private Stage stage;
    private Image title;
    private Image heart;
    private Image subOne;
    private Image subTwo;
    private Image subThree;
    private Image subFour;
    private Image subFive;

    public gameScreen(subdefenderApp game)
    {
        this.game = game;
        title = new smallTitle();
        heart = new heartLogo();
        subOne = new sub1();
        subTwo = new sub2();
        subThree = new sub3();
        subFour = new sub4();
        subFive = new sub5();
        stage = new Stage();
        stage.addActor(title);
        stage.addActor(heart);
        stage.addActor(subOne);
        stage.addActor(subTwo);
        stage.addActor(subThree);
        stage.addActor(subFour);
        stage.addActor(subFive);
    }


    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

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
        stage.draw();

    }
}
