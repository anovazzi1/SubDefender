package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class themeMusic {
    //musica tema

    private static Music theme;

    public static void play(){
        theme = Gdx.audio.newMusic(Gdx.files.
                internal("sounds/516076__breviceps__pirate-band-performs-drunken-sailor.wav"));
        theme.setLooping(true);
        theme.setVolume(0.5f);
        theme.play();
    }

    public static void dispose()
    {
        theme.dispose();
    }

    public static void pause(){ theme.pause();}

}
