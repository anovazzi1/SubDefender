package com.subdefender.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.subdefender.game.subdefenderApp;
import com.subdefender.game.welcome.screen;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("SubDefender");
		config.setWindowedMode(1000,600);
		config.setInitialBackgroundColor(Color.BLUE);
		new Lwjgl3Application(new subdefenderApp(), config);
	}
}
