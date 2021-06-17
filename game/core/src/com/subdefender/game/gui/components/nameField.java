package com.subdefender.game.gui.components;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class nameField extends TextField {
    public nameField(String text, Skin skin) {
        super(text, skin);
        this.setPosition(400,260);
        this.setSize(250,50);
        this.setColor(0,0,0,0.55f);
        this.setMessageText("Nome do Jogador");
        this.setOnlyFontChars(true);
    }
}
