package com.mycompany.Game;
import javax.microedition.khronos.opengles.GL10;
import com.mycompany.FrameWork.Input.TouchEvent;
//import com.mycompany.FrameWork.gl.Animation;
import com.mycompany.FrameWork.gl.Camera2D;
import java.lang.*;
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
	
			cam.position.y = world.player.position.y;
		    cam.position.x = world.player.position.x;
			cam.setViewportAndMatrices();
		    renderBackground();
			renderObjects(); 
		//cam.position.x=world.player.position.x;
	    //cam.position.y = world.player.position.y;
			}
	public void renderBackground()
	{
		
		batcher.beginBatch(Assets.fon);
	
		batcher.drawSprite(5,0,FRUSTUM_WIDTH,FRUSTUM_HEIGHT,Assets.fonRegion);
		batcher.drawSprite(15,0,FRUSTUM_WIDTH,FRUSTUM_HEIGHT,Assets.fonRegion);
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
		//поситион
		float pX=side<0?  -2.3f:2.3f;
		//поситион у
		float pY=side<0?  0.6f:0.6f;
		//вращенте х
		float vX=side<0?  2.1f:-2.1f;
		//вращение у
		float vY=side<0?  -0.6f:-0.6f;
		switch(world.player.state) {
		
		//	case Player.PLAYER_STATE_JUMP:*
				
				
			
		

			    
					default:  
					
					for(int l=0;world.listaPlayer.size()>l;l++){
					batcher.endBatch();
					
					//PlayerGO.getKeyFrame(world.player.stateTime,Animation.ANIMATION_LOOPING)
					if(world.ak!=null){
					batcher.beginBatch(Assets.ak47);
					keyFrame=Assets.ak47T;
					batcher.drawSprite(world.ak.position.x,world.ak.position.y,3,1,keyFrame);
				
				}
				batcher.endBatch();
				//ноги
				 batcher.beginBatch(Assets.pool2);
				 keyFrame =Assets.PlayerGO.getKeyFrame(world.player.stateTime,Animation.ANIMATION_LOOPING);
				 batcher.drawSprite(world.listaPlayer.get(l).position.x, world.listaPlayer.get(l).position.y-2.1f, side * 6, 3,keyFrame);
				 batcher.endBatch();
				
				batcher.beginBatch(Assets.pool3);
				keyFrame=Assets.p3;
				
				float angle=Control.angle;
			
                  
				
				
				
		//туловище
				batcher.drawSprite(world.listaPlayer.get(l).position.x, world.listaPlayer.get(l).position.y+0.5f, 0.2f,-2,side * 2.2f,5f,0, keyFrame);
				batcher.endBatch();
			
				if(Control.angle>75&&Control.angle<90){
					angle=75;
				}
				else if(Control.angle<290&&Control.angle>270){
					angle=290;
				}
				if(Control.angle<110&&Control.angle>90){
					angle=110;
				}

				else if(Control.angle>240&&Control.angle<280){
					angle=240;
				}
				
				if (side==-1){
					angle-=180;
				}
                
					
				
				//пули
				batcher.beginBatch(Assets.ak47);
				keyFrame=Assets.shot;
				
				if(Automatic.size==0){
					batcher.drawSprite(0,0,0,0,keyFrame);

				}
				else{
					
					for(int i=0;i<Automatic.size;i++){
						
						
						batcher.drawSprite(world.avto.getBullet(i).position.x,world.avto.getBullet(i).position.y,0,0,side*1f,0.8f,world.avto.getBullet(i).getAngle(),keyFrame);
						}
						
						
					
				}
				if(world.player.stateAvto==0){
					keyFrame=Assets.hands;//Assets.shotAk.getKeyFrame(world.f,Animation.ANIMATION_LOOPING);
					batcher.drawSprite(world.listaPlayer.get(l).position.x+pX,world.listaPlayer.get(l).position.y+pY,vX,vY,side*5f,2f,angle,keyFrame);
					batcher.endBatch();
					}
				else if(world.player.stateAvto==1){
						
					
				//рука
				keyFrame=Assets.shotAk.getKeyFrame(world.f,Animation.ANIMATION_LOOPING);
				batcher.drawSprite(world.listaPlayer.get(l).position.x+pX,world.listaPlayer.get(l).position.y+pY,vX,vY,side*5f,2f,angle,keyFrame);
				batcher.endBatch();
				
				}
				
				
				
			
			
			
				batcher.endBatch();
			
			
			
			}
			
				
				
				
		
		 
		
				
					
		
			
		
}}}
