package com.subdefender.game.gui.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.subdefender.game.subdefenderApp;

public class oceanSquare extends Image implements statusListener {
    //representação gráfica do quadrado de matriz do oceano
    private int i, j;
    private boolean isBot;
    public int x,y;
    private Image fogo;

    oceanSquare(int x, int y, int i, int j, boolean isBot) {
        super(new Texture("mar30px.png"));
        this.isBot = isBot;
        this.setPosition(240 + (x * 30), 160 + (y * 30));
        this.i = i;
        this.j = j;
        this.x = x;
        this.y = y;
        fogo = new fire(240 + (x * 30),160 + (y * 30));
    }

    //verificação automatica por meio do EventListener
    @Override
    public void statusChanged(subdefenderApp game) {
        if (isBot) {
            if (game.testeB.getVisible(i, j))
            {
                if(game.testeB.getPolvo(i,j)!= null)
                {
                    getStage().addActor(new tentacle(240 + (x * 30),160 + (y * 30)));
                }
                else if (game.testeB.getOcupado(i, j) && game.testeB.getAtingido(i, j) && game.testeB.getTipo(i, j))
                {
                    getStage().addActor(fogo);
                    fogo.addAction(Actions.fadeIn(1f));
                }
                else if(game.testeB.getOcupado(i, j) && game.testeB.getAtingido(i, j) && !game.testeB.getTipo(i, j))
                {
                    getStage().addActor(new Treasure(240 + (x * 30),160 + (y * 30)));
                }
                else if(game.testeB.getOcupado(i,j) && !game.testeB.getAtingido(i,j))
                {
                    getStage().addActor(new ocupado(240 + (x * 30),160 + (y * 30)));

                }
                else if(!game.testeB.getOcupado(i,j))
                {
                    this.addAction(Actions.fadeOut(1.5f));
                }
                if(game.testeB.getRevivido(i,j))
                {
                    fogo.addAction(Actions.fadeOut(1f));
                }
            }
        }
        else
        {
            if (game.testeP.getVisible(i, j))
            {
                if(game.testeP.getPolvo(i,j)!= null)
                {
                    getStage().addActor(new tentacle(240 + (x * 30),160 + (y * 30)));
                }
                else if (game.testeP.getOcupado(i, j) && game.testeP.getAtingido(i, j) && game.testeP.getTipo(i, j))
                {
                    getStage().addActor(fogo);
                    fogo.addAction(Actions.fadeIn(1f));
                }
                else if(game.testeP.getOcupado(i, j) && game.testeP.getAtingido(i, j) && !game.testeP.getTipo(i, j))
                {
                    getStage().addActor(new Treasure(240 + (x * 30),160 + (y * 30)));
                }
                else if(game.testeP.getOcupado(i,j) && !game.testeP.getAtingido(i,j))
                {
                    getStage().addActor(new ocupado(240 + (x * 30),160 + (y * 30)));
                }
                else if(!game.testeP.getOcupado(i,j))
                {
                    this.addAction(Actions.fadeOut(1.5f));
                }
                if(game.testeP.getRevivido(i,j))
                {
                    fogo.addAction(Actions.fadeOut(1f));
                }
            }
        }
    }
}
