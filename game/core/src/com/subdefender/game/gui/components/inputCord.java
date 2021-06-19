package com.subdefender.game.gui.components;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class inputCord extends TextField {

    public inputCord(String text, Skin skin) {
        super(text, skin);
        this.setPosition(400,260);
        this.setSize(250,50);
        this.setColor(0.5f,0.5f,2,0.9f);
        this.setMessageText("Coordenadas");
        this.setOnlyFontChars(true);
    }
}
