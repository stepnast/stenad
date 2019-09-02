package com.mycompany.Game;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


//import com.badlogic.androidgames.framework.gl.FPSCounter;

import com.mycompany.FrameWork.impl.GLScreen;


import com.mycompany.FrameWork.Screen;
import com.mycompany.FrameWork.impl.GLGame;
public class BRActivity extends GLGame
{
	
	
	boolean firstTimeCreate = true;
	
	@Override
	public Screen getStartScreen() {
		return new GameScreen(this);
		}
		
	@Override 
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		if(firstTimeCreate) {
			//Settings.load(getFileIO());
			Assets.load(this);
			firstTimeCreate = false;
			} else {
				Assets.reload();
				}
				}
	@Override
	public void onPause() {
		super.onPause();
		//if(Settings.soundEnabled)
			//Assets.music.pause();
			}
			
   





	  
}
