package com.subdefender.game.Players;

import com.subdefender.game.itens.Submarinos;

public class Bot extends Player{
    private int[] lastShot = new int[2];

    public Bot(){
        for (int i=0; i < 5; i++){
            this.submarinos[i] = new Submarinos(i+1);
        }
       this.lastShot[0] = -1;
       this.lastShot[1] = -1;
    }

    public int[] getLastShot() {
        return this.lastShot;
    }

    public void setLastShot(int fila, int coluna) {
        this.lastShot[0] = fila;
        this.lastShot[1] = coluna;
    }
}
