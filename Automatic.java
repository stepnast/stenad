package com.mycompany.Game;
import java.util.*;
import com.mycompany.FrameWork.math.Vector2;
import com.mycompany.Game.Bullet;
public class Automatic
{ 
	Bullet b;
	public static int  size;
	float deltaTime=0;
	float x,y,angle;
       ArrayList<Bullet> shot;
      public Automatic(float x,float y,float angle){
		  shot=new ArrayList<>();
		  this.x=x;
		  this.y=y;
		  this.angle=angle;
		  //shot.add(new Bullet(x,y,0));
	  } 
public void addShot(float ppX,float vX){
	float side =vX>0?-1:1;
	
	if(angle>75&&angle<90){
		angle=75;
	}
	else if(angle<290&&angle>270){
	    angle=290;
	}
	if(angle<110&&angle>90){
		angle=110;
	}

	else if(angle>240&&angle<280){
		angle=240;
	}
	if(side==-1){
		angle-=180;
	}
	float rad = angle * Vector2.TO_RADIANS;
	float cos = (float)Math.cos(rad);
	float sin = (float)Math.sin(rad);
    float ppY=side==-1?-0.1f:0.6f;
	//x=x0+(x-x0)*cos-(y-y0)*sin
	//y=y0+(y-y0)*cos+(x-x0)*sin
	float x0=vX;
	float y0=-0.6f;
	float halfWidth=side*2.5f;
	float halfHeight=ppY; 
	float pX=x0+(halfWidth-x0)*cos-(-halfHeight-y0)*sin;
	float pY=y0+(-halfHeight-y0)*cos+(halfWidth-x0)*sin;
	pX+=ppX+x;
	pY+=y+0.6f;
	angle=Control.angle;
	b=new Bullet(pX,pY,angle);
	
	
	shot.add(size,b);
}
public Bullet getBullet(int k){
	Bullet b=shot.get(k);
	return b;
	
		}
		public void removeBullet(int k){
			shot.remove(k);
		}
		public void setAngle(float angle){
			 
			
			this.angle=angle;
		}
		public void update(float deltaTime){
			size=shot.size();
			if(size>30){
				shot.remove(0);
				size=shot.size();
			}
			for(int i=0;i<size;i++){
			shot.get(i).getDeriction(deltaTime);
			}
		
			
		}
		
		}
	




	

