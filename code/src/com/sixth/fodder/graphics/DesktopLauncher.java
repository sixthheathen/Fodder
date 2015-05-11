package com.sixth.fodder.graphics;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
        {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Fodder";
//                config.fullscreen = true;
//                config.resizable = true;
		new LwjglApplication(new Fodder(), config);
	}
}