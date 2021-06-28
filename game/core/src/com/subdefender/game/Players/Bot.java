package com.subdefender.game.Players;

import com.subdefender.game.itens.Submarinos;

public class Bot extends Player{

    public Bot(){
        for (int i=0; i < 5; i++){
            this.submarinos[i] = new Submarinos(i+1);
        }
    }
}
