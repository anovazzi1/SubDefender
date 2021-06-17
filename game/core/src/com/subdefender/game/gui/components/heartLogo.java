package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class heartLogo extends Image {

    public heartLogo()
    {
        super(new Texture("heart.png"));
        this.setPosition(800,10);
    }
}
