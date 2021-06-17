package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.gui.components.buttons;
import com.subdefender.game.gui.components.gameTitle;
import com.subdefender.game.gui.components.nameField;
import com.subdefender.game.gui.components.themeMusic;
import com.subdefender.game.subdefenderApp;



public class inputScreen implements Screen {

    private subdefenderApp game;
    private gameTitle title;
    private Stage stage;
    private nameField nameInput;
    private String playerName;
    private buttons inputButton;


    public inputScreen(final subdefenderApp game)
    {
        this.game = game;
        nameInput = new nameField("", game.skin);
        inputButton = new buttons(game);
        title = new gameTitle();
        stage = new Stage();
        stage.addActor(nameInput);
        stage.addActor(title);


    }

    @Override
    public void show() {
        initButtons();
        Gdx.input.setInputProcessor(stage);
        inputButton.iniciar.addListener(new ClickListener(){
                                          @Override
                                          public void clicked(InputEvent event, float x, float y){
                                              playerName = nameInput.getText();
                                              System.out.println(playerName);
                                              game.playerName = playerName;
                                              game.setScreen(game.battleship);

                                          }
                                      }
        );
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

    }

    @Override
    public void dispose() {
        inputButton.dispose();
        stage.dispose();
    }

    private void initButtons() {
        inputButton.startButton();
        stage.addActor(inputButton.iniciar);
    }
}
