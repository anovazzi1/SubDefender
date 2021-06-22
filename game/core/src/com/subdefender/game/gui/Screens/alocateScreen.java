package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.gui.components.*;
import com.subdefender.game.subdefenderApp;



public class alocateScreen implements Screen {

    private final subdefenderApp game;
    private smallTitle title;
    private Stage stage;
    private inputCord inputCordenate;
    private String subCords;
    private buttons inputButton;
    private submarines subs;
    private int counter=0;

    public alocateScreen(final subdefenderApp game)
    {
        this.game = game;
        inputCordenate = new inputCord("", game.skin,0,0);
        inputButton = new buttons(game);
        subs = new submarines(game);
        title = new smallTitle();
        stage = new Stage();
        stage.addActor(inputCordenate);
        stage.addActor(title);
        subs.addActors(stage);


    }

    @Override
    public void show() {
        initButtons();

        Gdx.input.setInputProcessor(stage);
        inputButton.alocate.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y){
                                                subCords = inputCordenate.getText();
                                                System.out.println(subCords);
                                                //inserir verificação das coordenadas do navio
                                                game.subCords[counter] = subCords;
                                                counter++;
                                                inputCordenate.setText("");

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
        //informações estaticas na tela
        game.batch.begin();
        game.pixel.draw(game.batch,"tamanhos:",10,590);
        game.pixel.draw(game.batch,"1",140,530);
        game.pixel.draw(game.batch,"2",150,430);
        game.pixel.draw(game.batch,"3",180,330);
        game.pixel.draw(game.batch,"4",200,230);
        game.pixel.draw(game.batch,"5",240,140);
        game.batch.end();
        if (counter==5)
        {
            //muda de tela
            game.setScreen(game.battleship);
        }

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
        inputButton.alocateButton();
        stage.addActor(inputButton.alocate);
    }
}
