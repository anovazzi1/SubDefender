package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.gui.components.buttons;
import com.subdefender.game.gui.components.gameTitle;
import com.subdefender.game.gui.components.nameError;
import com.subdefender.game.gui.components.nameField;
import com.subdefender.game.subdefenderApp;



public class inputScreen implements Screen {

    private final subdefenderApp game;
    private gameTitle title;
    private Stage stage;
    private nameField nameInput;
    private String playerName;
    private buttons inputButton;
    private nameError erro = new nameError();


    public inputScreen(final subdefenderApp game)
    {
        this.game = game;
        nameInput = new nameField("", game.skin);
        inputButton = new buttons(game);
        title = new gameTitle();
        stage = new Stage();
        stage.addActor(nameInput);
        stage.addActor(title);
        stage.addActor(erro);


    }

    @Override
    public void show() {
        initButtons();
        Gdx.input.setInputProcessor(stage);
        //captura o nome do jogador e prende a variavel game.playerName
        inputButton.iniciar.addListener(new ClickListener(){
                                          @Override
                                          public void clicked(InputEvent event, float x, float y){
                                              playerName = nameInput.getText();
                                              if(game.validateName(playerName))
                                              {
                                                  game.setPlayerName(playerName);
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
