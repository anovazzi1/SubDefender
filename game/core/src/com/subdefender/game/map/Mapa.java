package com.subdefender.game.map;

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

    public Boolean getTipo(int i, int j){
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

    public void setTipo(int i, int j, boolean tipo)
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
                if(inicioColuna > fimColuna){ i = -1*i; }
                setOcupado(inicioFila, inicioColuna+i, true);
                setTipo(inicioFila, inicioColuna+i, true);
                setAtingido(inicioFila, inicioColuna+i, false);
                setRevivido(inicioFila, inicioColuna+i, false);
                if(!isBot){ setVisible(inicioFila, inicioColuna+i, true); }
            }
        }else {      //Horizontal
            for (int i = 0; i < subSize; i++){
                if(inicioFila > inicioFila){ i = -1*i; }
                setOcupado(inicioFila+i, inicioColuna, true);
                setTipo(inicioFila+i, inicioColuna, true);
                setAtingido(inicioFila, inicioColuna+i, false);
                setRevivido(inicioFila, inicioColuna+i, false);
                if(!isBot){ setVisible(inicioFila+i, inicioColuna, true); }
            }
        }
        setOcupado(fimFila, fimColuna, true);
    }
}
