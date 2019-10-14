package com.mycompany.Game;

import com.mycompany.FrameWork.Music;
import com.mycompany.FrameWork.Sound;
import com.mycompany.FrameWork.gl.Animation;
import com.mycompany.FrameWork.gl.Texture;
import com.mycompany.FrameWork.gl.TextureRegion;
import com.mycompany.FrameWork.impl.GLGame;
public class Assets {
	
	public static Texture ak47;
	public static Texture pool2;
	public static Texture pool3;
public static TextureRegion hands;
	public static TextureRegion p1; 
	public static TextureRegion ak47T;
	public static TextureRegion p3;
	public static TextureRegion p4;
	public static Animation PlayerGO;
	public static Texture left;
	public static Texture ghoi;
	public static TextureRegion shot;
	public static TextureRegion hands2;
	public static TextureRegion ghoiCircle;
	public static TextureRegion tap;
	public static TextureRegion ghoiTap;
	public static Texture fon;
    public static TextureRegion fonRegion;
	public static Animation  shotAk;
	
	public static void load(GLGame game){
		//ak-47
		ak47=new Texture(game,"Ak-47.png");
		//рука
		hands=new TextureRegion(ak47,120,630,300,150);
		//ноги
		pool2=new Texture(game,"nogi.png");
		//туловище
		pool3=new Texture(game,"Trunk.png");
		//текстура ак47 без рук
		ak47T=new TextureRegion(ak47,140,50,300,100);
		ghoi=new Texture(game,"ghoi.png");
		//стрельба из ак47
		shotAk=new Animation(0.09f,
						
		new TextureRegion(ak47,130,185,300,150),
		new TextureRegion(ak47,130,340,300,150));
	    ghoiCircle=new TextureRegion(ghoi,0,150,512,300);
		ghoiTap= new TextureRegion(ghoi,20,20,150,120);
       // hands2=new TextureRegion(hands,160,280,390,200);
		//пуля
		
        shot=new TextureRegion(ak47,200,590,50,50);
		//туловище
		p3=new TextureRegion(pool3,100,0,250,300);
		//
      
		//ходьба
		PlayerGO=new Animation(0.1f,
							   new TextureRegion(pool2,0,0,512,150),
							   new TextureRegion(pool2,0,160,512,150),
							   new TextureRegion(pool2,0,315,512,150),
							   new TextureRegion(pool2,0,470,512,150),
							   new TextureRegion(pool2,0,615,512,160)
							   
							 
							   );
		left=new Texture(game,"left.png");
		fon=new Texture(game,"fin.png");
		fonRegion=new TextureRegion(fon,0,0,512,256);
		tap=new TextureRegion(left,0,0,512,256);
	}
	public static void reload() {
		
		
		}
		
	}
	
