package com.subdefender.game.itens;

import static java.lang.Math.abs;

public class Submarinos {
    private int tamanho;
    private int celulasFuncionais;
    private boolean vivo;
    private int filaInicio;
    private int colunaInicio;
    private int filaFim;
    private int colunaFim;
    private boolean alocado;

    public Submarinos(int size) {
        this.tamanho = size;
        this.vivo = true;
        this.celulasFuncionais = size;
        this.alocado = false;
    }

    public void alocateSubs(int rowBegin, int columnBegin, int rowEnd, int columnEnd) {
        this.filaInicio = rowBegin;
        this.colunaInicio = columnBegin;
        this.filaFim = rowEnd;
        this.colunaFim = columnEnd;
        this.alocado = true;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean status) {
        vivo = status;
    }

    public int getSize() {
        return this.tamanho;
    }


    public int getFilaInicio() {
        return filaInicio;
    }


    public int getColunaInicio() {
        return colunaInicio;
    }

    public int getFilaFim() {
        return filaFim;
    }

    public int getColunaFim() {
        return colunaFim;
    }


    public boolean isAlocado() {
        return alocado;
    }

    public void atingido(int fila, int coluna) {

        if (filaInicio == filaFim && fila == filaInicio) {        //VERTICAL=
            if (colunaInicio <= coluna && coluna <= colunaFim){
                celulasFuncionais--;
            }
        }else if (coluna == colunaFim && coluna == colunaInicio) {    //HORIZONTAL
            if (filaInicio <= fila && fila <= filaFim){
                celulasFuncionais--;
            }
        }

        if (celulasFuncionais <= 0) { this.vivo = false; }
    }
}
