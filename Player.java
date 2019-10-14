package com.mycompany.Game;
import com.mycompany.Game.Legs;
import com.mycompany.Game.Trunc;
import com.mycompany.FrameWork.DynamicGameObject;
public class Player extends DynamicGameObject
{
	//прыгает
	public static final int PLAYER_STATE_JUMP=0;
	//идёт в право
	public static final int PLAYER_STATE_GO_RIGHT=1;
	//идёт влево
	public static final int PLAYER_STATE_GO_LEFT=2;
	//падает
	public static final int PLAYER_STATE_FALL=3;
	//мертв
	public static final int PLAYER_STATE_HIT=4;
	//стоит
	public static final int PLAYER_STATE_STOP=5;
	
	public static final float PLAYER_JUMP=10;
	public static final float PLAYER_MOVE=0.1f;
    public static final float PLAYER_WIDTH=2;
    public static final float PLAYER_HEIGHT=10;
	int stateAvto;
	int HP;
	public static final int рука=0;
	public static final int AK47=1;
	Legs legs;
    Trunc trunc;
	
	int state;
	 float stateTime;

        public Player (float x,float y){
			super(x,y,PLAYER_WIDTH,PLAYER_HEIGHT);
			legs=new Legs(x,y);
			trunc=new Trunc(x,y);
		     state=PLAYER_STATE_STOP;
			stateTime=0;
			stateAvto=рука;
			HP=100;
		}
   public void update( float deltaTime){
	   
	   velocity.add(velocity.x, World.gravity.y * deltaTime);
	   position.y+=velocity.y * deltaTime;
	   bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
	   
	   
	   //прыгает
	  /*
	   //идёт вправо
	   if(velocity.x>0&& state!=PLAYER_STATE_HIT){
		   if(state!=PLAYER_STATE_GO_RIGHT){
			   state=PLAYER_STATE_GO_RIGHT;
			  stateTime=0;
			   }}
			   //идёт влево
	   if(velocity.x<0&& state!=PLAYER_STATE_HIT){
		   if(state!=PLAYER_STATE_GO_LEFT){
			   state=PLAYER_STATE_GO_LEFT;
			  stateTime=0;
			   }
			   }
			   //стоит
	   if(velocity.x==0&& state!=PLAYER_STATE_HIT ){
		   if(state!=PLAYER_STATE_STOP){
			   state=PLAYER_STATE_STOP;
			  stateTime=0;
			   }}*/
	   stateTime += deltaTime;
	   }
	   //ходьба впрво
	   public void Right(boolean move){
		   if(move){
		   velocity.x=PLAYER_MOVE; 
		   }
		   position.x+=PLAYER_MOVE;
		   
		   state=PLAYER_STATE_GO_RIGHT;
		  
	   }
	  //ходьба в лево
	  public void Left(boolean move){
		  if(move){
		  velocity.x=-PLAYER_MOVE;
		  }
		  position.x-=PLAYER_MOVE;
		  
		  state=PLAYER_STATE_GO_LEFT;
		 
		  
	  }
	  public void Stop(){
		 
		  state=PLAYER_STATE_STOP;
		  stateTime=0;
	  }
	   public void setVelocosityLeft(){
		   velocity.x=-PLAYER_MOVE; 
		  
	   }
   public void setVelocosityRight(){
	   velocity.x=PLAYER_MOVE;
	   
   }
    
public void jimp(){
	
	velocity.y=8f;
	stateTime=0;
}







	
}
