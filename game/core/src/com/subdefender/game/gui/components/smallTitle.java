package com.subdefender.game.gui.components;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class smallTitle extends Image {

    //versão menor do titulo do jogo
    public smallTitle()
    {
        super(new Texture("titulo_600_150px.png"));
        this.setPosition(200,480);
    }
}