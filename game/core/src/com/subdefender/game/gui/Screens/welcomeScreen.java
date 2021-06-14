package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.subdefender.game.gui.components.image;
import com.subdefender.game.subdefenderApp;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class welcomeScreen implements Screen {

    private final subdefenderApp game;
    private image title;
    private Music theme;
    private Stage stage;
    private Image title_fade;

    public welcomeScreen(final subdefenderApp game)
    {
        this.game = game;
        this.stage = new Stage(new StretchViewport(1000,600, game.camera));
        Gdx.input.setInputProcessor(stage);
        title = new image("titulo_800_200px_1.png");
        title_fade = new Image(title);
        stage.addActor(title_fade);


    }

    @Override
    public void show() {
        title_fade.setPosition(120,390);
        theme = Gdx.audio.newMusic(Gdx.files.
                internal("516076__breviceps__pirate-band-performs-drunken-sailor.wav"));
        theme.setLooping(true);
        theme.play();
        title_fade.addAction(sequence(alpha(0),
                parallel(moveBy(0,40,1.7f),fadeIn(1.7f))));
        title_fade.addAction(after(repeat(100,
                sequence(moveBy(0,-40,1.7f),moveBy(0,40,1.7f)))));

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
        theme.dispose();
        stage.dispose();

    }
}
