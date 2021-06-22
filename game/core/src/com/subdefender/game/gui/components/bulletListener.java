package com.subdefender.game.gui.components;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.subdefender.game.subdefenderApp;

public class bulletListener extends ClickListener {
// coordena a seleção das balas
    private Image atual;
    private final subdefenderApp game;
    private int i;
    public bulletListener(Image atual, subdefenderApp game, int index)
    {
        super();
        this.atual = atual;
        this.game = game;
        this.i = index;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        setTapCountInterval(1f);
        if (getTapCount() < 2) {
            atual.addAction(Actions.sequence(
                    Actions.moveBy(0, 10),
                    Actions.fadeOut(0.5f),
                    Actions.fadeIn(0.5f),
                    Actions.moveBy(0, -10)
            ));
        }
        game.setSelectedBullet(i);
    }
}
