package com.subdefender.game.gui.components;


public class GridTest {
    private CellTest[][] test = new CellTest[10][10];
    private boolean isBot;


    public GridTest(Boolean isBot){
        this.isBot = isBot;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                test[i][j] = new CellTest(i,j,isBot);
            }
        }
    }

    public boolean getVisible(int i, int j){
        return test[i][j].getVisivel();

    }
    public Boolean getPolvo(int i, int j){
        return test[i][j].getPolvo();
    }

    public boolean getAtingido(int i, int j){
        return test[i][j].getAtingido();

    }

    public Boolean getTipo(int i, int j){
        return test[i][j].getTipo();
    }

    public boolean getOcupado(int i, int j)
    {
        return test[i][j].getOcupado();
    }

    public boolean getRevivido(int i, int j)
    {
        return test[i][j].getRevivido();
    }


    public void setVisible(int i, int j, boolean isVisible)
    {
        test[i][j].setVisivel(isVisible);
    }


    public void setPolvo(int i, int j, boolean isPolvo)
    {
        test[i][j].setPolvo(isPolvo);
    }

    public void setOcupado(int i, int j, boolean isOcupado)
    {
        test[i][j].setOcupado(isOcupado);
    }

    public void setAtingido(int i, int j, boolean isAtingido)
    {
        test[i][j].setAtingido(isAtingido);
    }

    public void setTipo(int i, int j, boolean tipo)
    {
        test[i][j].setTipo(tipo);
    }

    public void setRevivido(int i, int j, boolean isRevivido)
    {
        test[i][j].setRevivido(isRevivido);
    }

}
