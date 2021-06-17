package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.subdefender.game.gui.components.buttons;
import com.subdefender.game.gui.components.gameTitle;
import com.subdefender.game.gui.components.themeMusic;
import com.subdefender.game.subdefenderApp;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class welcomeScreen implements Screen {

    private final subdefenderApp game;
    private Stage stage;
    private gameTitle logo;
    private buttons menuButtons;

    public welcomeScreen(final subdefenderApp game)
    {
        logo = new gameTitle();
        this.game = game;
        this.stage = new Stage(new StretchViewport(1000,600, game.camera));
        Gdx.input.setInputProcessor(stage);
        stage.addActor(logo);
        menuButtons = new buttons(game);
    }

    @Override
    public void show() {
        themeMusic.play();
        logo.addAction(sequence(alpha(0),
                parallel(moveBy(0,40,1.7f),fadeIn(1.7f))));
        logo.addAction(after(repeat(100,
                sequence(moveBy(0,-40,1.7f),moveBy(0,40,1.7f)))));
        initButton();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.begin();
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
        //chamado antes da janela mudar, onde se coloca as informações salvas

    }

    @Override
    public void dispose() {
        themeMusic.dispose();
        stage.dispose();
        menuButtons.dispose();
    }

    private void initButton() {
        menuButtons.playButton();
        menuButtons.exitButton();
        stage.addActor(menuButtons.jogar);
        stage.addActor(menuButtons.sair);
    }
}
