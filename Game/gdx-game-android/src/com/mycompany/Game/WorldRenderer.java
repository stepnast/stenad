package com.mycompany.Game;
import javax.microedition.khronos.opengles.GL10;
import com.mycompany.FrameWork.Input.TouchEvent;
//import com.mycompany.FrameWork.gl.Animation;
import com.mycompany.FrameWork.gl.Camera2D;
import com.mycompany.FrameWork.gl.SpriteBatcher;
import com.mycompany.FrameWork.gl.TextureRegion;
import com.mycompany.FrameWork.impl.GLGraphics;
import com.mycompany.FrameWork.impl.MultiTouchHandler;

import com.mycompany.FrameWork.math.*;
import com.mycompany.FrameWork.gl.*;
//import com.badlogic.gdx.graphics.g2d.*;
public class WorldRenderer
{
	static final float FRUSTUM_WIDTH = 15f;
	static final float FRUSTUM_HEIGHT = 10f; 
	GLGraphics glGraphics;
	World world;
	Camera2D cam;
	
    SpriteBatcher batcher;
	public WorldRenderer(GLGraphics glGraphics,SpriteBatcher batcher, World world) {
		this.glGraphics = glGraphics;
		this.world = world;
		this.cam = new Camera2D(glGraphics, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.batcher = batcher;
	
		}
	public void render() {
		if(world.player.position.y > cam.position.y )
			cam.position.y = world.player.position.y;
		
			cam.setViewportAndMatrices();
		    renderBackground();
			renderObjects(); 
		//cam.position.x=world.player.position.x;
	    //cam.position.y = world.player.position.y;
			}
	public void renderBackground()
	{
		
		batcher.beginBatch(Assets.fon);
	
		batcher.drawSprite(5,8,FRUSTUM_WIDTH,FRUSTUM_HEIGHT,Assets.fonRegion);
		batcher.drawSprite(15,8,FRUSTUM_WIDTH,FRUSTUM_HEIGHT,Assets.fonRegion);
	batcher.endBatch();
	}
	public void renderObjects() {
		GL10 gl = glGraphics.getGL();
		gl.glEnable(GL10.GL_BLEND);
	gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


		
		renderPlayer();
		
	
		
		
		batcher.endBatch();
		
		
		gl.glDisable(GL10.GL_BLEND);
		
		}
	private void renderPlayer() {
		TextureRegion keyFrame;
		float side = world.player.velocity.x < 0? -1: 1; 
		float x=side<0?  world.player.position.x:world.player.position.x  ;
		
		switch(world.player.state) {
		
		//	case Player.PLAYER_STATE_JUMP:*
		
				
			
		

			    
					default: 
				
					
				//PlayerGO.getKeyFrame(world.player.stateTime,Animation.ANIMATION_LOOPING)
				batcher.beginBatch(Assets.pool2);
				keyFrame =Assets.PlayerGO.getKeyFrame(world.player.stateTime,Animation.ANIMATION_LOOPING);
				batcher.drawSprite(world.player.position.x, world.player.position.y-2, side * 5, 4,keyFrame);
		    	batcher.endBatch();
				batcher.beginBatch(Assets.pool3);
				keyFrame=Assets.p3;
 		
				batcher.drawSprite(x, world.player.position.y-1.2f, side * 1.7f,8f, side*Control.angle,keyFrame);
				
				}
		
		 
		cam.position.x=world.player.position.x;
				
					} 
		
		
			
		
}
