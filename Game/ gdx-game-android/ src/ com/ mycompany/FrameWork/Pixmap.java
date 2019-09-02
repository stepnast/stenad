package com.mycompany.FrameWork;
import com.mycompany.FrameWork.Graphics.PixmapFormat;
public interface Pixmap {
	
	public int getWidth();
	public int getHeight();
	public PixmapFormat getFormat();
	public void dispose();
	}

