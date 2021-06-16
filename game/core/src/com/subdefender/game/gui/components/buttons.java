package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.subdefenderApp;

public class buttons {
    Skin skin;
    subdefenderApp game;
    public TextButton jogar;
    public TextButton sair;


    public buttons(subdefenderApp game)
    {
        this.game = game;
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        game.manager.load("skins/uiskin.atlas", TextureAtlas.class);
        game.manager.finishLoading();
        skin.addRegions(this.game.manager.get("skins/uiskin.atlas", TextureAtlas.class));
    }

    public void playButton()
    {
        jogar = new TextButton("jogar",skin,"default");
        jogar.setPosition(400,260);
        jogar.setSize(200,100);

    }

    public void exitButton()
    {
        sair = new TextButton("sair",skin,"default");
        sair.setPosition(400,120);
        sair.setSize(200,100);
        sair.addListener(new ClickListener(){
                             @Override
                             public void clicked(InputEvent event, float x, float y){
                                 Gdx.app.exit();
                             }
                         }
        );
    }
    public void dispose()
    {
        skin.dispose();
    }

}
