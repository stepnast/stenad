package com.mycompany.Game;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;
import com.mycompany.FrameWork.Game;
import com.mycompany.FrameWork.Input.TouchEvent;
import com.mycompany.FrameWork.gl.Camera2D;
//import com.badlogic.androidgames.framework.gl.FPSCounter;
import com.mycompany.FrameWork.gl.SpriteBatcher;
import com.mycompany.FrameWork.impl.GLScreen;
import com.mycompany.FrameWork.math.OverlapTester;
import com.mycompany.FrameWork.math.Rectangle;
import com.mycompany.FrameWork.math.Vector2;
//import com.badlogic.androidgames.jumper.World.WorldListener;

import com.mycompany.FrameWork.Screen;
import com.mycompany.FrameWork.impl.GLGame;


public class MainMenuScreen extends GLScreen
{
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle soundBounds;
	Rectangle playBounds;
	Rectangle highscoresBounds;
	Rectangle helpBounds;
	Vector2 touchPoint;
	public MainMenuScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 320, 480);
	    batcher = new SpriteBatcher(glGraphics, 100);
		soundBounds = new Rectangle(0, 0, 64, 64);
		playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
		highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36); 
		touchPoint = new Vector2(); 
		}
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getTouchEvents();
		int len = touchEvents.size();
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);
				if(OverlapTester.pointInRectangle(playBounds, touchPoint)) { 
				//Assets.playSound(Assets.clickSound);
				game.setScreen(new GameScreen(game));
				return;
				}
				if(OverlapTester.pointInRectangle(highscoresBounds, touchPoint)) {
				//Assets.playSound(Assets.clickSound);
				//game.setScreen(new HighscoresScreen(game));
				return;
				}
				if(OverlapTester.pointInRectangle(helpBounds, touchPoint)) {
				//Assets.playSound(Assets.clickSound);
				//game.setScreen(new HelpScreen(game));
				return; }
				if(OverlapTester.pointInRectangle(soundBounds, touchPoint)) {
				//Assets.playSound(Assets.clickSound);
				//Settings.soundEnabled = !Settings.soundEnabled;
				//if(Settings.soundEnabled)
					//Assets.music.play();
					//else Assets.music.pause();
					} } }}
	@Override public void present(float deltaTime) { GL10 gl = glGraphics.getGL(); gl.glClear(GL10.GL_COLOR_BUFFER_BIT); guiCam.setViewportAndMatrices();
		gl.glEnable(GL10.GL_TEXTURE_2D);
		//batcher.beginBatch(Assets.background);
		//batcher.drawSprite(160, 240, 320, 480,Assets.);
		batcher.endBatch();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		//batcher.beginBatch(Assets.items);
		//batcher.drawSprite(160, 480 - 10 - 71, 274, 142, Assets.logo);
		//batcher.drawSprite(160, 200, 300, 110, Assets.mainMenu);// batcher.drawSprite(32, 32, 64, 64,);
		batcher.endBatch();
		gl.glDisable(GL10.GL_BLEND); 
		}
				
					
	@Override public void pause() { //Settings.save(game.getFileIO());
	}
	@Override public void resume() { }
	@Override public void dispose() { }
}
