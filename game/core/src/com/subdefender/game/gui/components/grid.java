package com.subdefender.game.gui.components;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class grid {
    private oceanSquare[][] matriz = new oceanSquare[10][10];
    private int k = 0;

    public grid(Stage stage, boolean isBot){
        //representação visual da matriz do oceano
        if(isBot){
            k=13;
        }
        for(int i=0;i<10;i++){
            for(int j =0;j<10;j++){
                matriz[i][j] = new oceanSquare(i+k,j,i, j, isBot);
                stage.addActor(matriz[i][j]);
                inicializador.addListener(matriz[i][j]);
            }
        }
    }
}
