package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Treasure extends Image {
    //imagem do tesouro
    public Treasure(int x, int y){
        super(new Texture(Gdx.files.internal("tesouro30px.png")));
        this.setPosition(x,y);

    }
}