package com.mycompany.Game;
import com.mycompany.FrameWork.DynamicGameObject;
import com.mycompany.FrameWork.math.Vector2;
import com.mycompany.FrameWork.math.Rectangle;
import com.mycompany.FrameWork.gl.*;
import com.mycompany.FrameWork.Input.TouchEvent;
public class Control extends DynamicGameObject
{
  public static float SIZE=4f;
public static float CSIZE=2f;
	public static  float CIRCLERADIUS = 1.5f;
	public static float  CONTRLRADIUS = 3F;
	//public static float Coefficient = 1F;

	//угол для определения направления
	public static float angle;
	//public static int Opacity = 1;
	World world;

	//координаты отклонения khob
	protected Vector2 anglePos ;
    
	protected Vector2 position = new Vector2();
	protected Rectangle bounds ;
	public Control(float x,float y){
		super(x,y,SIZE,SIZE);
		
		bounds= new Rectangle(0,0,SIZE,SIZE);
		anglePos = new Vector2(x,y);
	}
	 public void update(float deltaTime,Vector2 tachPoint){
		 angle = tachPoint.sub(anglePos).angle();
		 }
	




	

	
}
