package com.mycompany.Game;
import javax.microedition.khronos.opengles.GL10;
import java.util.*;

import com.mycompany.FrameWork.Game;
import com.mycompany.FrameWork.Input.TouchEvent;
import com.mycompany.FrameWork.gl.Camera2D;
import com.mycompany.FrameWork.gl.SpriteBatcher;
import com.mycompany.FrameWork.impl.GLScreen;
import com.mycompany.FrameWork.math.OverlapTester;
import com.mycompany.FrameWork.math.Rectangle;
import com.mycompany.FrameWork.math.Vector2;
import com.mycompany.Game.Control;
import com.mycompany.FrameWork.impl.MultiTouchHandler;
import com.mycompany.FrameWork.math.Circle;
public class GameScreen extends GLScreen
{
	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_OVER = 3;
	int statePlayer;
	int state; 
	//камера
	Camera2D guiCam;
	//крнтролёр
	Control controlor;
	//нажатия
	Vector2 touchPoint;
	//рисование кнопок
	SpriteBatcher batcher;
	//мир
	 World world;
	//WorldListener worldListener;
	//отрисовка мира
	WorldRenderer renderer;
	//кнопка лево
	Rectangle left;
	//кнопка право
	Rectangle reght;
	float angle;
	Vector2 v;
	int lastScore;
	String scoreString;
	//x средней кнопки джоя
	float tapX;
	//y средней кнопки джоя
	float tapY;
	//кнопка джоя
	Rectangle tap;
	//растояние границ джоя
	Vector2 rast;
	// обработчик касаний
	 int t;
	 Rectangle jimp;
	MultiTouchHandler tapHandler;
public GameScreen(Game game){
	super(game);
	state = GAME_RUNNING;
	guiCam = new Camera2D(glGraphics, 320, 480);
	controlor=new Control(280,100,guiCam);
	touchPoint = new Vector2();
	batcher = new SpriteBatcher(glGraphics, 1000);
tapX=281;
tapY=100;
rast=new Vector2();
v= new Vector2();

jimp=new Rectangle(40,200,50,200);
	world = new World();
	renderer = new WorldRenderer(glGraphics, batcher, world);
	left= new Rectangle(10, 1, 50, 200);
	reght = new Rectangle(40, 1, 50,200);
	angle=0;
	tap=new Rectangle(200,-20,150,380);
}

	  @Override
	public void update(float deltaTime){
		  if(deltaTime > 0.1f) 
			  deltaTime = 0.1f; 
	
		  
			updateRunning(deltaTime); 
	
	}
	boolean move=true;
     private void updateRunning(float deltaTime){
		 
		 
		 List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		 
		 int len = touchEvents.size();
		 for(int i = 0; i < len; i++) {
			 TouchEvent event = touchEvents.get(i);
			 if(event.type != TouchEvent.TOUCH_DRAGGED&event.type!=TouchEvent.TOUCH_UP)
			 continue;
			 touchPoint.set(event.x, event.y);
			
			 guiCam.touchToWorld(touchPoint);
			 touchPoint.y-=35;
			 v.set(touchPoint);
			 //если задета левая кнопка
			 if(OverlapTester.pointInRectangle(left, touchPoint)) {
				 statePlayer=1;
				
				 }
				 //если задета правая
			 else if(OverlapTester.pointInRectangle(reght,touchPoint)){
				 statePlayer=2;}
				 //прыжок
				else if(OverlapTester.pointInRectangle(jimp,touchPoint)){
					statePlayer=3;
				}
				
			 
			 //если задет джой
			 else if(OverlapTester.pointInRectangle(tap,touchPoint)){
				 //долеко влево
				 t=1;
				 move=false;
				 if(touchPoint.x<250){
					 rast.set(250,35);
					
					 touchPoint.x=touchPoint.x+rast.dist(touchPoint.x,35);
					 tapX=touchPoint.x;
					 controlor.update(touchPoint);
					 
					 
				 }
				 //долеко вправо
				 else if(touchPoint.x>300){
					 rast.set(300,35);
					
					touchPoint.x=touchPoint.x-rast.dist(touchPoint.x,35);
					 tapX=touchPoint.x;
					 controlor.update(touchPoint);
					 
				 
				 }
				//в деопозоне джоя
				 else{
				 tapX=v.x;
					 
					 controlor.update(touchPoint);
					 
				 
			 }
			 //высоко по У
			 if(touchPoint.y>175){
				 rast.set(0,175);
				 
				 touchPoint.y=175;
				 
				 tapY=touchPoint.y;
				 
				 controlor.update(touchPoint);
			 }
			 //ниже джоя по Y
				 else if(touchPoint.y<35){
					 rast.set(0,35);
					
					 touchPoint.y=35;
					 tapY=touchPoint.y;
					 controlor.update(touchPoint);
					 
					 
				 }
				 //в деопазоне джоя
				 else{
					 
					
					 
					 tapY=touchPoint.y;
					 
					 controlor.update(touchPoint);
					
				 }
				 
				 
			 if(touchPoint.x<280){
				 world.player.setVelocosityLeft();
			 }
			 else{
				 world.player.setVelocosityRight();
			 }
			 
	}
			if(event.type==TouchEvent.TOUCH_UP){
				 
				 if(OverlapTester.pointInRectangle(tap,touchPoint)){
					
				
					 t=0;
					 tapX=281;
					 tapY=100;
					 move=true;
					 
					// Control.angle=0;
				 }
				 if(OverlapTester.pointInRectangle(left,touchPoint)){
			        statePlayer=0;
				 }
				 if(OverlapTester.pointInRectangle(reght,touchPoint)){
					statePlayer=0;
				 }
			     if(OverlapTester.pointInRectangle(jimp,touchPoint)){
					 statePlayer=0;
				 }
		       
			 
			}
				}
				 
		 
		 world.update(deltaTime,statePlayer,t,move);
		 
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
		batcher.drawSprite(70,300,40,100,Assets.tap);
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
