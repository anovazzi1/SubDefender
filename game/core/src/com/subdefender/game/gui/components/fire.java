package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class fire extends Image {

    //imagem do fogo
    public fire(int x, int y){
        super(new Texture(Gdx.files.internal("fogo30px.png")));
        this.setPosition(x,y);

    }
}