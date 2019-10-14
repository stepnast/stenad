package com.mycompany.Game;
import com.mycompany.FrameWork.DynamicGameObject;
import com.mycompany.FrameWork.math.Vector2;
public class Bullet extends DynamicGameObject
{
	public static float x,y,radians;
	private float angle;
	public Bullet(float x,float y,float angle){
		super(x,y,1,1);
		this.angle=angle;
		this.x=x;
		this.y=y;
		
		
		
		
	
		
	}
	
	public void getDeriction(float deltaTime){
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
		radians = angle * Vector2.TO_RADIANS;
		float Speed=0.1f;
		velocity.x = (float)Math.cos(radians) * Speed ;
		velocity.y = (float)Math.sin(radians) * Speed;
		x=velocity.x;
		y=velocity.y;
		velocity.add(x,y);
		position.x+=velocity.x;
		position.y+=velocity.y;
	}
	public float getAngle(){
		return angle;
	}
	
}
