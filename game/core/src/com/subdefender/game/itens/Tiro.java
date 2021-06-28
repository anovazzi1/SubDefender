package com.subdefender.game.itens;

public class Tiro {
    private int qntd;
    private int poder;

    public int getQuantidade() {
        return this.qntd;
    }

    public void setQuantidade(int valor) {
        this.qntd = valor;
    }

    public void setPoder(int valor) {
        this.poder = valor;
    }

    public void shot() {
        this.qntd--;
    }
}
