package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class tentacle extends Image {
    //imagem do tentaculo

    public tentacle(int x, int y){
        super(new Texture(Gdx.files.internal("tentaculo30px.png")));
        this.setPosition(x,y);

    }
}
