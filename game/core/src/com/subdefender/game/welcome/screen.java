package com.subdefender.game.welcome;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class screen extends Game {
    Texture img;
    Music theme;

    public Texture getImg() {
        return img;
    }

    public Music getTheme() {
        return theme;
    }

    @Override
    public void create () {
        img = new Texture("titulo_800_200px_1.png");
        theme = Gdx.audio.newMusic(Gdx.files.
                internal("516076__breviceps__pirate-band-performs-drunken-sailor.wav"));
        theme.setLooping(true);
        theme.play();
    }

    @Override
    public void dispose () {
        img.dispose();
        theme.dispose();
    }
}
