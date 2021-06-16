package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class themeMusic {

    private static Music theme;

    public static void play(){
        theme = Gdx.audio.newMusic(Gdx.files.
                internal("516076__breviceps__pirate-band-performs-drunken-sailor.wav"));
        theme.setLooping(true);
        theme.play();
    }

    public static void dispose()
    {
        theme.dispose();
    }

}
