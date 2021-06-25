package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class erroCordInvalida extends Image implements error{

    public erroCordInvalida(){
        super(new Texture(Gdx.files.internal("ErrorMessages/coordenadas invalidas2.png")));
        this.setPosition(250,310);
        setVisible(false);
    }

    @Override
    public void showError() {
        setVisible(true);
    }
}
