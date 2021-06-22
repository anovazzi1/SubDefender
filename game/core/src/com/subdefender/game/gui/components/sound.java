package com.subdefender.game.gui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class sound {
    //efeitos sonoros

    private Music soundEffect;

    public sound(String path){
        soundEffect = Gdx.audio.newMusic(Gdx.files.internal(path));
    }

    public void play()
    {
        soundEffect.play();
    }

    public void setvolume(float volume){
        soundEffect.setVolume(volume);
    }


    public void dispose()
    {
        soundEffect.dispose();
    }
}
