package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class bullet1 extends Image {
    public bullet1(){
        super(new Texture("bala_comum.png"));
        this.setPosition(250,10);
        this.setScale(0.5f);
        this.addListener(new ClickListener(){
                             @Override
                             public void clicked(InputEvent event, float x, float y) {
                                 setTapCountInterval(1f);
                                 if (getTapCount() < 2) {

                                     bullet1.this.addAction(Actions.sequence(
                                             Actions.moveBy(0, 10),
                                             Actions.fadeOut(0.5f),
                                             Actions.fadeIn(0.5f),
                                             Actions.moveBy(0, -10)
                                     ));
                                 }
                                 bullet1.this.addAction(Actions.color(new Color(1,0,0,0.5f)));

                             }
                         }
        );
    }
}
