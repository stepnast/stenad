package com.mycompany.FrameWork.impl;
import java.util.List;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.mycompany.FrameWork.Input;
public class AndroidInput implements Input
{
	KeyboardHandler keyHandler;
	
	TouchHandler touchHandler;
public AndroidInput(View view,float scaleX,float scaleY)
{
	
	touchHandler = new MultiTouchHandler(view, scaleX, scaleY); 
	}
	@Override
	public boolean isTouchDown(int pointer) {
		return touchHandler.isTouchDown(pointer);
		}
	@Override
	public int getTouchX(int pointer) {
		return touchHandler.getTouchX(pointer);
		}
	@Override
	public int getTouchY(int pointer) {
		return touchHandler.getTouchY(pointer);
		}
	@Override
	public List<TouchEvent> getTouchEvents() {
		return touchHandler.getTouchEvents();
		}

	@Override public List<KeyEvent> getKeyEvents() {
		return keyHandler.getKeyEvents();
		}
	@Override public boolean isKeyPressed(int keyCode) {
		return keyHandler.isKeyPressed(keyCode);
		}

}
