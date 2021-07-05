package com.subdefender.game.gui.components;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.itens.Submarinos;
import com.subdefender.game.subdefenderApp;

public class heartLogo extends Image {
    //botão do coração

    private final subdefenderApp game;
    public sound lifeEffect;
    public heartLogo(final subdefenderApp game)
    {
        super(new Texture("heart.png"));
        this.lifeEffect = new sound("sounds/518306__mrthenoronha__extra-life-8-bit.wav");
        this.setPosition(800,10);
        this.game = game;
        this.addListener(new ClickListener(){
                                           @Override
                                           public void clicked(InputEvent event, float x, float y) {
                                               setTapCountInterval(2f);
                                               if (game.getLifeCounter() > 0 && getTapCount()<2)
                                               {
                                                   for (Submarinos submarino: game.jogador.submarinos) {
                                                       if(!submarino.getVivo()){
                                                           heartLogo.this.addAction(Actions.sequence(
                                                                   Actions.moveBy(0, 10),
                                                                   Actions.fadeOut(0.5f),
                                                                   Actions.fadeIn(0.5f),
                                                                   Actions.moveBy(0, -10)
                                                           ));
                                                           game.setLifeCounter(game.getLifeCounter()-1);
                                                           lifeEffect.setvolume(0.3f);
                                                           lifeEffect.play();
                                                           submarino.setVivo(true);
                                                          game.setRevivido(submarino.getSize(), submarino.getFilaInicio(), submarino.getColunaInicio(), submarino.getFilaFim(), submarino.getColunaFim());
                                                          break;
                                                       }
                                                   }

                                               }
                                           }
                                       }
        );
    }
}
