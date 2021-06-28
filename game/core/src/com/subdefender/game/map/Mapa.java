package com.subdefender.game.map;

import com.subdefender.game.CSVHandling;

public class Mapa {
    private Celula[][] celula = new Celula[10][10];
    private boolean isBot;


    public Mapa(Boolean isBot){
        this.isBot = isBot;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                celula[i][j] = new Celula(i,j,isBot);
            }
        }
    }

    public boolean getVisible(int i, int j){
        return celula[i][j].getVisivel();

    }

    public Boolean getPolvo(int i, int j){
        return celula[i][j].getPolvo();
    }

    public boolean getAtingido(int i, int j){
        return celula[i][j].getAtingido();

    }

    public int getTipo(int i, int j){
        return celula[i][j].getTipo();
    }

    public boolean getOcupado(int i, int j)
    {
        return celula[i][j].getOcupado();
    }

    public boolean getRevivido(int i, int j)
    {
        return celula[i][j].getRevivido();
    }

    public void setVisible(int i, int j, boolean isVisible)
    {
        celula[i][j].setVisivel(isVisible);
    }

    public void setPolvo(int i, int j, boolean isPolvo)
    {
        celula[i][j].setPolvo(isPolvo);
    }

    public void setOcupado(int i, int j, boolean isOcupado)
    {
        celula[i][j].setOcupado(isOcupado);
    }

    public void setAtingido(int i, int j, boolean isAtingido)
    {
        celula[i][j].setAtingido(isAtingido);
    }

    public void setTipo(int i, int j, int tipo)
    {
        celula[i][j].setTipo(tipo);
    }

    public void setRevivido(int i, int j, boolean isRevivido)
    {
        celula[i][j].setRevivido(isRevivido);
    }

    public void alocateSub(int subSize, int[] subCords, boolean isBot) {
        //Coordenadas inicio
        int inicioFila = subCords[0];
        int inicioColuna = subCords[1];

        //Coordenadas fim
        int fimFila = subCords[2];
        int fimColuna = subCords[3];


        if (inicioFila == fimFila) {    //Vertical
            for (int i = 0; i < subSize; i++){
                if(inicioColuna > fimColuna){
                    int I = (-1)*i;
                    setOcupado(inicioFila, inicioColuna+I, true);
                    setTipo(inicioFila, inicioColuna+I, 3);
                    setAtingido(inicioFila, inicioColuna+I, false);
                    setRevivido(inicioFila, inicioColuna+I, false);
                    if(!isBot){ setVisible(inicioFila, inicioColuna+I, true); }

                }else{
                    setOcupado(inicioFila, inicioColuna+i, true);
                    setTipo(inicioFila, inicioColuna+i, 3);
                    setAtingido(inicioFila, inicioColuna+i, false);
                    setRevivido(inicioFila, inicioColuna+i, false);
                    if(!isBot){ setVisible(inicioFila, inicioColuna+i, true); }
                }
            }
        }else {      //Horizontal
            for (int i = 0; i < subSize; i++){
                if(inicioFila > inicioFila){
                    int I = (-1)*i;
                    setOcupado(inicioFila+I, inicioColuna, true);
                    setTipo(inicioFila+I, inicioColuna, 3);
                    setAtingido(inicioFila+I, inicioColuna, false);
                    setRevivido(inicioFila+I, inicioColuna, false);
                    if(!isBot){ setVisible(inicioFila+I, inicioColuna, true); }
                }else {
                    setOcupado(inicioFila + i, inicioColuna, true);
                    setTipo(inicioFila + i, inicioColuna, 3);
                    setAtingido(inicioFila + i, inicioColuna, false);
                    setRevivido(inicioFila + i, inicioColuna, false);
                    if (!isBot) {
                        setVisible(inicioFila + i, inicioColuna, true);
                    }
                }
            }
        }
        setOcupado(fimFila, fimColuna, true);
    }

    public void alocateTesouro(int i, int poder) {
        String caminho = "data/mapaBot.csv";
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminho);
        String[] coordenadas = csv.requestCommands();
        String tesouro = coordenadas[i];
        int fila = tesouro.charAt(0)%65;
        int coluna = Integer.parseInt(String.valueOf(tesouro.charAt(1)));

        setTipo(fila, coluna, poder);
        setOcupado(fila, coluna, true);
    }
}
