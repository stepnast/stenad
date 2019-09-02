package com.mycompany.FrameWork.impl;
import android.graphics.Bitmap;
import com.mycompany.FrameWork.Graphics.PixmapFormat;
import com.mycompany.FrameWork.Pixmap;
public class AndroidPixmap implements Pixmap { 
Bitmap bitmap; 
PixmapFormat format;

	public AndroidPixmap(Bitmap bitmap, PixmapFormat format) {
		this.bitmap = bitmap;
		this.format = format;
		}
	@Override public int getWidth() { return bitmap.getWidth();}
	@Override public int getHeight() { return bitmap.getHeight();}
	@Override public PixmapFormat getFormat() { return format; }
	@Override public void dispose() { bitmap.recycle(); }
	}

