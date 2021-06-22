package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.subdefenderApp;

public class bullets {
    //imagem das balas
    private Image[] copia;
    private Image[] bullets = new Image[3];
    private bulletListener listener;
    private subdefenderApp game;
    public bullets(subdefenderApp game) {
        this.game = game;
        bullets[0] = new Image(new Texture("bala_comum.png"));
        bullets[0].setPosition(250, 10);
        bullets[0].setScale(0.5f);
        bullets[1] = new Image(new Texture("bala_poder2.png"));
        bullets[1].setPosition(125, 10);
        bullets[1].setScale(0.5f);
        bullets[2] = new Image(new Texture("bala_poder3.png"));
        bullets[2].setPosition(10, 10);
        bullets[2].setScale(0.5f);
        copia = new Image[bullets.length];
        clone(bullets,copia);
        createListeners();

    }

    private void clone(Image[] bullets, Image[] copia) {
        for(int i =0;i<bullets.length;i++){
            copia[i] = bullets[i];
        }
    }

    private void createListeners() {
        for (int i = 0;i<3;i++){
            listener = new bulletListener(copia[i],game,i);
            copia[i].addListener(listener);
        }
    }

    public void addActors(Stage stage){
        for(int i=0;i<3;i++)
        {
            stage.addActor(copia[i]);
        }
    }

}
