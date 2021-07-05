package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.subdefender.game.subdefenderApp;

public class cordTemplate {
    subdefenderApp game;
    //printa referencia das coordenadas de forma estática na tela

    public BitmapFont pixelSmall;
    public cordTemplate(subdefenderApp game){
        this.game = game;
        pixelSmall = new BitmapFont(Gdx.files.internal("fonts/Pixeboy-z8XGD.ttf/Pixeboy-z8XGD.fnt"));
        pixelSmall.getData().setScale(1.2f,1.2f);
    }
    public void print(int x, int y)
    {
        pixelSmall.draw(game.batch,"0",x,y);
        pixelSmall.draw(game.batch,"1",x,y+35);
        pixelSmall.draw(game.batch,"2",x,y+65);
        pixelSmall.draw(game.batch,"3",x,y+95);
        pixelSmall.draw(game.batch,"4",x,y+125);
        pixelSmall.draw(game.batch,"5",x,y+155);
        pixelSmall.draw(game.batch,"6",x,y+185);
        pixelSmall.draw(game.batch,"7",x,y+215);
        pixelSmall.draw(game.batch,"8",x,y+245);
        pixelSmall.draw(game.batch,"9",x,y+275);
        pixelSmall.draw(game.batch,"a",(x+32),y-20);
        pixelSmall.draw(game.batch,"b",(x+32)+35,y-20);
        pixelSmall.draw(game.batch,"c",(x+32)+65,y-20);
        pixelSmall.draw(game.batch,"d",(x+32)+95,y-20);
        pixelSmall.draw(game.batch,"e",(x+32)+125,y-20);
        pixelSmall.draw(game.batch,"f",(x+32)+155,y-20);
        pixelSmall.draw(game.batch,"g",(x+32)+185,y-20);
        pixelSmall.draw(game.batch,"h",(x+32)+215,y-20);
        pixelSmall.draw(game.batch,"i",(x+32)+245,y-20);
        pixelSmall.draw(game.batch,"j",(x+32)+275,y-20);


    }

}
