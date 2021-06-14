package com.subdefender.game.gui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subdefender.game.gui.components.image;

public class screen extends Game {
    SpriteBatch batch;
    image title;
    Music theme;

    @Override
    public void create () {
        title = new image("titulo_800_200px_1.png");
        theme = Gdx.audio.newMusic(Gdx.files.
                internal("516076__breviceps__pirate-band-performs-drunken-sailor.wav"));
        theme.setLooping(true);
        theme.play();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(title,120, 430);
        batch.end();

    }

    @Override
    public void dispose () {
        title.dispose();
        theme.dispose();
        batch.dispose();
    }
}
