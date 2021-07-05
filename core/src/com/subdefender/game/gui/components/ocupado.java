package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class ocupado extends Image {
    //imagem que representa submarino no campo
    public ocupado(int x, int y){
        super(new Texture(Gdx.files.internal("ocupado30px.png")));
        this.setPosition(x,y);

    }
}
