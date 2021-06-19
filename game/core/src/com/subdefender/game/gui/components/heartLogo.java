package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.subdefenderApp;

public class heartLogo extends Image {

    subdefenderApp game;
    public heartLogo(final subdefenderApp game)
    {
        super(new Texture("heart.png"));
        this.setPosition(800,10);
        this.game = game;
        this.addListener(new ClickListener(){
                                           @Override
                                           public void clicked(InputEvent event, float x, float y) {
                                               setTapCountInterval(1f);
                                               if (game.getLifeCounter() > 0 && getTapCount()<2)
                                               {
                                                   heartLogo.this.addAction(Actions.sequence(
                                                           Actions.moveBy(0, 10),
                                                           Actions.fadeOut(0.5f),
                                                           Actions.fadeIn(0.5f),
                                                           Actions.moveBy(0, -10)
                                                   ));
                                                   game.setLifeCounter(game.getLifeCounter()-1);
                                               }
                                           }
                                       }
        );
    }
}
