package com.subdefender.game.gui.components;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class gameTitle extends Image {


    //imagem do titulo do jogo
    public gameTitle()
    {
        super(new Texture("titulo_800_200px_1.png"));
        this.setPosition(120,390);
    }
}
