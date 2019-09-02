package com.mycompany.Game;
import javax.microedition.khronos.opengles.GL10;
import java.util.List;
import com.mycompany.FrameWork.Game;
import com.mycompany.FrameWork.Input.TouchEvent;
import com.mycompany.FrameWork.gl.Camera2D;
import com.mycompany.FrameWork.gl.SpriteBatcher;
import com.mycompany.FrameWork.impl.GLScreen;
import com.mycompany.FrameWork.math.OverlapTester;
import com.mycompany.FrameWork.math.Rectangle;
import com.mycompany.FrameWork.math.Vector2;
import com.mycompany.Game.Control;
import com.mycompany.FrameWork.math.Circle;
public class GameScreen extends GLScreen
{
	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_OVER = 3;
	int statePlayer;
	int state; 
	Camera2D guiCam;
	Control controlor;
	Vector2 touchPoint;
	SpriteBatcher batcher;
	 World world;
	//WorldListener worldListener;
	WorldRenderer renderer;
	Rectangle left;
	Rectangle reght;
	Rectangle tapDjoi;
	int lastScore;
	String scoreString;
	float tapX;
	float tapY;
	Rectangle tap;
	Vector2 rast;
	
public GameScreen(Game game){
	super(game);
	state = GAME_RUNNING;
	guiCam = new Camera2D(glGraphics, 320, 480);
	controlor=new Control(60,60);
	touchPoint = new Vector2();
	batcher = new SpriteBatcher(glGraphics, 1000);
tapX=281;
tapY=100;
rast=new Vector2();

	world = new World();
	renderer = new WorldRenderer(glGraphics, batcher, world);
	left= new Rectangle(10, 1, 50, 200);
	reght = new Rectangle(40, 1, 50,200);
	tapDjoi = new Rectangle (250,35,60,140);
	tap=new Rectangle(230,20,120,180);
}

	  @Override
	public void update(float deltaTime){
		  if(deltaTime > 0.1f) 
			  deltaTime = 0.1f; 
	
		  
			updateRunning(deltaTime); 
	
	}
	
     private void updateRunning(float deltaTime){
		 
		 
		 List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		 int len = touchEvents.size();
		 for(int i = 0; i < len; i++) {
			 TouchEvent event = touchEvents.get(i);
			 if(event.type != TouchEvent.TOUCH_DRAGGED&&event.type!=TouchEvent.TOUCH_UP)
			 continue;
			 touchPoint.set(event.x, event.y);
			 guiCam.touchToWorld(touchPoint);
			 if(OverlapTester.pointInRectangle(left, touchPoint)) {
				 statePlayer=1;
				 world.update(deltaTime,statePlayer);
				 }
			 else if(OverlapTester.pointInRectangle(reght,touchPoint)){
				 statePlayer=2;
				 world.update(deltaTime,statePlayer);
				
			 }
			 else if(OverlapTester.pointInRectangle(tap,touchPoint)){
				 if(touchPoint.x<260){
					 rast.set(260,35);
					 tapX=touchPoint.x+rast.dist(touchPoint.x,35);
					 controlor.update(deltaTime,touchPoint);
				 } 
				 else if(touchPoint.x>300){
					 rast.set(300,35);
					 tapX=touchPoint.x-rast.dist(touchPoint.x,35);
					 controlor.update(deltaTime,touchPoint);
				 
				 }
				 else{
				 tapX=touchPoint.x;
					// Control.angle=0;
					 controlor.update(deltaTime,touchPoint);
				 
			 }
			 if(touchPoint.y>175){
				 rast.set(0,175);
				 tapY=touchPoint.y-rast.dist(0,touchPoint.y);
				 controlor.update(deltaTime,touchPoint);
			 
			 }
				 else if(touchPoint.y<35){
					 rast.set(0,35);
					 tapY=touchPoint.y+rast.dist(0,touchPoint.y);
					 controlor.update(deltaTime,touchPoint);
				 
				 }
				 else{
					 tapY=touchPoint.y;
					 //Control.angle=0;
					controlor.update(deltaTime,touchPoint);
				 
				 }
				 
			 
			}
				
			
				 if(event.type==TouchEvent.TOUCH_UP){
					 tapX=281;
					 tapY=100;
					 Control.angle=0;
					 if(OverlapTester.pointInRectangle(left,touchPoint) ||OverlapTester.pointInRectangle(reght,touchPoint) ){
						
					 
					 statePlayer=0;
					 world.update(deltaTime,statePlayer);
				
			}
			 
			 
			
			}
			 }
	 }
	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    gl.glEnable(GL10.GL_TEXTURE_2D);
		renderer.render();
		guiCam.setViewportAndMatrices();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	
	
		presentRunning();
		batcher.endBatch();
		gl.glDisable(GL10.GL_BLEND);
		
}
	@Override
	public void pause()
	{
		if(state == GAME_RUNNING)
			state = GAME_PAUSED;
			}
	private void presentRunning() { 

		batcher.beginBatch(Assets.left);
	    batcher.drawSprite(32,100,40,100,Assets.tap);
		batcher.drawSprite(70,100,-40,100,Assets.tap);
		batcher.endBatch();
		batcher.beginBatch(Assets.ghoi);
		batcher.drawSprite(280,110,70,210,Assets.ghoiCircle);
		batcher.drawSprite(tapX,tapY,30,130,Assets.ghoiTap);
		batcher.endBatch();
	}
			
	@Override
	public void resume() { }
	
	@Override
	public void dispose() { }
}
