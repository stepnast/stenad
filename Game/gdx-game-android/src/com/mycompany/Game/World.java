package com.mycompany.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mycompany.FrameWork.math.OverlapTester;
import com.mycompany.FrameWork.math.Vector2;

public class World
{
	public static final float WORLD_WIDTH = 10;
	public static final float WORLD_HEIGHT = 10 ;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_GAME_OVER = 1;
	
	public static final Vector2 gravity = new Vector2(0, -12);
	public final Player player;
	public final Random rand;
	public int state;
	
   public World(){
	   this.player=new Player(5,6);
	   rand=new Random();
	   this.state=WORLD_STATE_RUNNING;
	  }
	public void update(float deltaTime,int go) {
		updateBob(deltaTime,go);
		}
   private void updateBob(float deltaTime,int go ) {
	   if(player.state!=Player.PLAYER_STATE_HIT){
		   if(go==1){
			   player.Left(); 
		   }
		   if(go==2){
			   player.Right();
		   }
		   if(go==0){
			   player.Stop();
		   }
	   }
	  player.update(deltaTime);
	   
   }
}
