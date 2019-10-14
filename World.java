package com.mycompany.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.mycompany.Game.Automatic;
import com.mycompany.Game.Control;
import com.mycompany.FrameWork.math.OverlapTester;
import com.mycompany.FrameWork.math.Vector2;
import com.mycompany.FrameWork.*;

public class World
{
	public static final float WORLD_WIDTH = 10;
	public static final float WORLD_HEIGHT = 10 ;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_GAME_OVER = 1;
	Player bot;
	public static final Vector2 gravity = new Vector2(0,-12);
	public final Player player;
	public final Random rand;
	public int state;
	Automatic avto;
	List<Wall>arrayWall;
	List<floor> arrayFlor;
	Ak47 ak;
	List<Player>listaPlayer;
   public World(){
	   this.player=new Player(0,0);
	   bot=new Player(10,0);
	   ak=new Ak47(10,0,2,2);
	   listaPlayer=new ArrayList<>();
	   arrayWall=new ArrayList<>();
	   rand=new Random(); 
	   avto=new Automatic(5,6,Control.angle);
	   this.state=WORLD_STATE_RUNNING;
	   arrayFlor=new ArrayList<>();
	   createObject();
	   listaPlayer.add(player);
	   listaPlayer.add(bot);
	  }
	public void update(float deltaTime,int go,int t,boolean move) {
		updateBob(deltaTime,go,move);
		if(player.stateAvto==0){
			
		}
		else if(player.stateAvto==1){ 
		updateAmy(deltaTime,t); 
		}
		chick();
		}
		
   private void updateBob(float deltaTime,int go,boolean move) {
	   if(player.state!=Player.PLAYER_STATE_HIT){
		   if(go==1){
			   player.Left(move); 
		   }
		   if(go==2){
			   player.Right(move);
		   }
		   if(go==0){
			   player.Stop();
		   }
		   if(go==3){
			   player.jimp();
		   }
	   }
	  player.update(deltaTime);
	   
   } 
  public float f=0;
   private void updateAmy(float deltaTime,float shot){
	   avto.setAngle(Control.angle);
	 
	   if(shot==1){
		   f+=deltaTime;
		   avto.x=player.position.x;
		   avto.y=player.position.y;
		   
		   if(f<0.1f){
			   
		   }else{ 
			   //поситион
			   float vX=player.velocity.x<0?  -2.3f:2.3f;
			   //вращение
			   float vvX=player.velocity.x<0?  2.1f:-2.1f;
		  
		   avto.addShot(vX,vvX);
		   f=0;
		   }
	   }
	 
		 
	   avto.update(deltaTime);
		   
	   }
	   public void createObject(){
		   arrayWall.add(new Wall(0,0,0.1f,100f));
		   arrayWall.add(new Wall(100,0,0.1f,100));
		   arrayFlor.add(new floor(50,0,100,0.1f));
	   }
	public void chick(){
		chickWall();
		chickFloor();
		chickAk47();
		chickBullet();
	}
	public void chickWall(){
		;
			
	int len=arrayFlor.size();
		for(int i=0;i<len;i++){
			Wall wall=arrayWall.get(i);
			if(OverlapTester.overlapRectangles(wall.bounds,player.bounds)){
				if(wall.position.x>player.position.x){
					player.position.x=wall.position.x;
				
				
				
			}
			
		}}}
			public void chickFloor(){
				if (player.velocity.y > 0)
					return;
					
				int len=arrayFlor.size();
				for(int i=0;i<len;i++){
					 floor floor =arrayFlor.get(i);
					if(OverlapTester.overlapRectangles(floor.bounds,player.bounds)){
						player.position.y=floor.position.y;
						player.velocity.y=0;
					}
						
					
				
			}}
	public void chickAk47(){
		if(ak!=null){
		if(OverlapTester.overlapRectangles(ak.bounds,player.bounds)){
			player.stateAvto=player.AK47;
			ak=null;
		} }
	}
	public void chickBullet(){
		
		for(int i=0;avto.shot.size()>i;i++){
			
			Bullet bullet=avto.getBullet(i);
			
			
		if(OverlapTester.overlapRectangles(bullet.bounds,bot.bounds)){
		
		player.HP-=rand.nextInt(10)+30;
		avto.removeBullet(i);
		return;
		}}
	}}
