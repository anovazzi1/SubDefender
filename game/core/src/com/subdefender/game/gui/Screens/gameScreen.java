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
    private submarines subs;
    private Bullets balas;

    public gameScreen(subdefenderApp game)
    {
        this.game = game;
        title = new smallTitle();
        heart = new heartLogo(game);
        subs = new submarines(game);
        balas = new Bullets(game);
        stage = new Stage();
        stage.addActor(title);
        stage.addActor(heart);
        subs.addActors(stage);
        balas.addActors(stage);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        subs.checkStatus();
        stage.act(delta);
        stage.draw();
        game.batch.begin();
        game.pixel.draw(game.batch,"x",890,35);
        game.pixel.draw(game.batch,"x",45,35);
        game.pixel.draw(game.batch,"x",160,35);
        game.pixel.draw(game.batch,"x",283,35);
        game.pixel.draw(game.batch,game.getAmmo(2)+"",75,35);
        game.pixel.draw(game.batch,game.getAmmo(1)+"",190,35);
        game.pixel.draw(game.batch,game.getAmmo(0)+"",313,35);
        game.pixel.draw(game.batch,game.getLifeCounter()+"",920,35);
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
}
