package com.subdefender.game.map;

import com.subdefender.game.gui.components.inicializador;

public class Celula {
    int i,j;
    private boolean isBot;
    private boolean visivel = false;
    private boolean ocupado = false;
    private boolean atingido = false;
    private int tipo; // tesouro 1, tesouro 2, submarino 3
    private Boolean polvo = null;
    private boolean revivido = false;

    public Celula(int i, int j, Boolean isBot){
        this.isBot = isBot;
        this.i = i;
        this.j = j;
    }

    public boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
        inicializador.updatedStatus(i,j,isBot);
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean getAtingido() {
        return atingido;
    }

    public void setAtingido(Boolean atingido) {
        this.atingido = atingido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getPolvo() {
        return polvo;
    }

    public void setPolvo(Boolean polvo) {
        this.polvo = polvo;
    }

    public boolean getRevivido() {
        return revivido;
    }

    public void setRevivido(boolean revivido) {
        this.revivido = revivido;
    }
}
