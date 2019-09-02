package com.mycompany.Game;

import com.mycompany.FrameWork.Music;
import com.mycompany.FrameWork.Sound;
import com.mycompany.FrameWork.gl.Animation;
import com.mycompany.FrameWork.gl.Texture;
import com.mycompany.FrameWork.gl.TextureRegion;
import com.mycompany.FrameWork.impl.GLGame;

public class Assets {
	public static Texture pool;
	public static Texture pool2;
	public static Texture pool3;
	public static Texture pool4;
	public static TextureRegion p1; 
	public static TextureRegion p2;
	public static TextureRegion p3;
	public static TextureRegion p4;
	public static Animation PlayerGO;
	public static Texture left;
	public static Texture ghoi;
	public static TextureRegion ghoiCircle;
	public static TextureRegion tap;
	public static TextureRegion ghoiTap;
	public static Texture fon;
    public static TextureRegion fonRegion;
	public static Animation маргание;
	public static void load(GLGame game){
		//pool=new Texture(game,"pool.png");
		pool2=new Texture(game,"nogi.png");
		pool3=new Texture(game,"Trunk.png");
		ghoi=new Texture(game,"ghoi.png");
	    ghoiCircle=new TextureRegion(ghoi,0,150,512,300);
		ghoiTap= new TextureRegion(ghoi,20,20,150,120);


		p3=new TextureRegion(pool3,120,70,250,500);
        p2=new TextureRegion(pool2,0,610,512,200);
		PlayerGO=new Animation(0.2f,
							   new TextureRegion(pool2,0,0,512,200),
							   new TextureRegion(pool2,0,180,512,200),
							   new TextureRegion(pool2,0,405,512,200),
							   new TextureRegion(pool2,0,610,512,200)
							   );
		left=new Texture(game,"left.png");
		fon=new Texture(game,"fin.png");
		fonRegion=new TextureRegion(fon,0,0,512,256);
		tap=new TextureRegion(left,0,0,512,256);
	}
	public static void reload() {
		pool.reload();
		
		}
		
	}
	
