package com.subdefender.game.gui.components;

import com.subdefender.game.subdefenderApp;

import java.util.ArrayList;
import java.util.List;

public class inicializador {
    //responsavel pela adição de eventos do tipo statusListener e gerenciamento do mesmo
    static private subdefenderApp Game;

    static public void setGame(subdefenderApp game){
        Game = game;
    }

    static private List<statusListener> cells = new ArrayList<statusListener>();

    static public void addListener(statusListener toAdd)
    {
        cells.add(toAdd);
    }

    static public void updatedStatus(int i, int j, Boolean isBot)
    {
        if(!isBot){
            cells.get((i*10)+j).statusChanged(Game);
        }
        if(isBot)
        {
            cells.get(100+(i*10)+j).statusChanged(Game);
        }

    }


}
