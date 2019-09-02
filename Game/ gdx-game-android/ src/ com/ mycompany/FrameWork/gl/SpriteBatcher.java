package com.mycompany.FrameWork.gl;

import javax.microedition.khronos.opengles.GL10;
import android.util.Log;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import com.mycompany.FrameWork.impl.GLGraphics;
import com.mycompany.FrameWork.math.Vector2;
public class SpriteBatcher
{
	final float[] verticesBuffer;
	int bufferIndex;
	final Vertices vertices;
	int numSprites;
	public SpriteBatcher(GLGraphics glGraphics, int maxSprites) {
		this.verticesBuffer = new float[maxSprites*4*4];
		this.vertices = new Vertices(glGraphics, maxSprites*4, maxSprites*6, false, true);
		this.bufferIndex = 0;
		this.numSprites = 0;
		short[] indices = new short[maxSprites*6];
		int len = indices.length;
		short j = 0;
		for (int i = 0; i < len; i += 6, j += 4) {
			indices[i + 0] = (short)(j + 0);
			indices[i + 1] = (short)(j + 1);
			indices[i + 2] = (short)(j + 2);
			indices[i + 3] = (short)(j + 2);
			indices[i + 4] = (short)(j + 3);
			indices[i + 5] = (short)(j + 0);
			}
		
			vertices.setIndices(indices, 0, indices.length) ;
		}
	public void beginBatch(Texture texture) {
		texture.bind();
		numSprites = 0;
		bufferIndex = 0;
		}
	public void endBatch() {
		vertices.setVertices(verticesBuffer, 0, bufferIndex);
		vertices.bind();
		vertices.draw(GL10.GL_TRIANGLES, 0, numSprites * 6);
		vertices.unbind();
		}
	public void drawSprite(float x, float y, float width, float height, TextureRegion region) {
		float halfWidth = width / 2;
		float halfHeight = height / 2;
		float x1 = x - halfWidth; 
		float y1 = y - halfHeight;
		float x2 = x + halfWidth;
		float y2 = y + halfHeight;
		verticesBuffer[bufferIndex++] = x1;
		verticesBuffer[bufferIndex++] = y1;
		verticesBuffer[bufferIndex++] = region.u1;
		verticesBuffer[bufferIndex++] = region.v2;
		verticesBuffer[bufferIndex++] = x2;
		verticesBuffer[bufferIndex++] = y1;
		verticesBuffer[bufferIndex++] = region.u2;
		verticesBuffer[bufferIndex++] = region.v2;
		verticesBuffer[bufferIndex++] = x2;
		verticesBuffer[bufferIndex++] = y2;
		verticesBuffer[bufferIndex++] = region.u2;
		verticesBuffer[bufferIndex++] = region.v1;
		verticesBuffer[bufferIndex++] = x1;
		verticesBuffer[bufferIndex++] = y2;
		verticesBuffer[bufferIndex++] = region.u1;
		verticesBuffer[bufferIndex++] = region.v1;
		numSprites++;}
	public void drawSprite(float x, float y, float width, float height, float angle, TextureRegion region) {
		float halfWidth = width /2;
		float halfHeight = height/2;

		float rad = angle * Vector2.TO_RADIANS;
		float cos = (float)cos(rad);
		float sin = (float)sin(rad);
	
	
		float x1 = -halfWidth * cos - (-halfHeight) * sin; 
		float y1 = -halfWidth * sin + (-halfHeight) * cos; 
		float x2 = halfWidth * cos -(-halfHeight) * sin;
		float y2 = halfWidth * sin + (-halfHeight) * cos;
		float x3 = halfWidth * cos -halfHeight * sin;
		float y3 = halfWidth * sin + halfHeight * cos;
		float x4 = -halfWidth * cos -halfHeight * sin;
		float y4 = -halfWidth * sin + halfHeight * cos;
		x1 += x; 
		y1 += y;
		x2 += x;
		y2 += y;
		x3 += x;
		y3 += y;
		x4 += x;
		y4 += y;
	/*
	
	//левый нижный
	    float x1 =-halfWidth;
		float y1 =-halfHeight ;
		//верхний левый
		float x2 =+halfWidth; 
		float y2 =-halfHeight;
		//вепхний левый
		float x3 =+halfWidth;
		float y3 =+halfHeight;
		//верхний правый
		float x4 =-halfWidth;
		float y4 =+halfHeight;
//x=x*cos-y*sin
//y=y*cos+x*sin
//x=x0+(x-x0)*cos-(y-y0)*sin
//y=y0+(y-y0)*cos+(x-x0)*sin
		
		float x0=x;
		float y0=y-halfHeight;
		x1=x0+(x1-x0)*cos-(y1-y0)*sin;
		y1=y0+(y1-y0)*cos+(x1-x0)*sin;
		x2=x0+(x2-x0)*cos-(y2-y0)*sin;
		y2=y0+(y2-y0)*cos+(x2-x0)*sin;

		x3=x0+(x3-x0)*cos-(y3-y0)*sin;
		y3=y0+(y3-y0)*cos+(x3-x0)*sin;
		x4=x0+(x4-x0)*cos-(y4-y0)*sin;
		y4=y0+(y4-y0)*cos+(x4-x0)*sin;
		
		*/
		verticesBuffer[bufferIndex++] = x1;
		verticesBuffer[bufferIndex++] = y1;
		verticesBuffer[bufferIndex++] = region.u1;
		verticesBuffer[bufferIndex++] = region.v2;
		
		verticesBuffer[bufferIndex++] = x2;
		verticesBuffer[bufferIndex++] = y2;
		verticesBuffer[bufferIndex++] = region.u2;
		verticesBuffer[bufferIndex++] = region.v2;
		
		verticesBuffer[bufferIndex++] = x3;
		verticesBuffer[bufferIndex++] = y3;
		verticesBuffer[bufferIndex++] = region.u2;
		verticesBuffer[bufferIndex++] = region.v1;
		
		verticesBuffer[bufferIndex++] = x4;
		verticesBuffer[bufferIndex++] = y4;
		verticesBuffer[bufferIndex++] = region.u1;
		verticesBuffer[bufferIndex++] = region.v1;
	 
		numSprites++; 
		}
		
}
