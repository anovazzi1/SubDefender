package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.subdefenderApp;

public class submarines {
    public Image[] sub;
    private subdefenderApp game;

    public submarines(subdefenderApp game)
    {
        this.game = game;
        sub = new Image[5];
        sub[0] = new Image(new Texture("sub_1.png"));
        sub[0].setPosition(20,500);
        sub[1] = new Image(new Texture("sub_2.png"));
        sub[1].setPosition(20,400);
        sub[1].setScale(0.9f,0.9f);
        sub[2] = new Image(new Texture("sub_3.png"));
        sub[2].setPosition(20,290);
        sub[2].setScale(0.7f,0.7f);
        sub[3] = new Image(new Texture("sub_4.png"));
        sub[3].setPosition(20,200);
        sub[3].setScale(.9f,0.95f);
        sub[4] = new Image(new Texture("sub_5.png"));
        sub[4].setPosition(20,110);
        sub[4].setScale(0.9f,0.8f);
    }

    public void checkStatus()
    {
        for(int i =0;i<5;i++){
            if(!game.getSubStatus(i))
            {
                sub[i].addAction(Actions.fadeOut(1f));
            }
        }
    }

    public void addActors(Stage stage)
    {
        for(int i =0;i<5;i++){
            stage.addActor(sub[i]);
        }
    }
}
