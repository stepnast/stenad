package com.mycompany.FrameWork.impl;

import com.mycompany.FrameWork.Game; 
import com.mycompany.FrameWork.Screen;

public abstract class GLScreen extends Screen {
	protected final GLGraphics glGraphics;
	protected final GLGame glGame;
	public GLScreen(Game game) {
		super(game);
		glGame = (GLGame)game;
		glGraphics = ((GLGame)game).getGLGraphics();
		}
}
