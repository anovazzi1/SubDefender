package com.subdefender.game.gui.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.gui.components.gameTitle;
import com.subdefender.game.subdefenderApp;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;

public class endScreen implements Screen {

    subdefenderApp game;
    private Image title;
    private Stage stage;

    public endScreen(subdefenderApp game){
        this.game = game;
        title = new gameTitle();
        stage = new Stage();
        stage.addActor(title);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        title.addAction(sequence(alpha(0),
                parallel(moveBy(0,40,1.7f),fadeIn(1.7f))));
        title.addAction(after(repeat(100,
                sequence(moveBy(0,-40,1.7f),moveBy(0,40,1.7f)))));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.begin();
        if(game.win)
        {
            game.pixel.draw(game.batch,"VOCE VENCEU !!!",370,400);
            game.pixel.draw(game.batch,("PARABENS "+ game.getName()+ ",\n voce destruiu toda frota inimiga" +
                    "\n e dominou os sete mares"),200,300);
            game.pixel.draw(game.batch,"score:"+ game.score,100,100);
        }
        else
        {
            game.pixel.draw(game.batch,"infelizmente soldado, voce falhou",200,400);
            game.pixel.draw(game.batch,(game.getName()+ " virou comida de peixe\n"+ " perdeu todos os seus submarinos"+"\n tente novamente"),200,300);
            game.pixel.draw(game.batch,"score:"+ game.score,100,100);
        }
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
}
