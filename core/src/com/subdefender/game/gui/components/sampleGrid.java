package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class sampleGrid extends Image {

    public sampleGrid(){
        super(new Texture(Gdx.files.internal("gridExample.png")));
        setPosition(400,10);
        setScale(0.7f);
    }
}
