package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class nameError extends Image implements error{
    public nameError(){
        super(new Texture(Gdx.files.internal("ErrorMessages/erro_nome2.png")));
        this.setPosition(100,300);
        setVisible(false);
    }


    @Override
    public void showError() {
        setVisible(true);
    }
}
