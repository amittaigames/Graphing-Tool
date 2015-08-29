package com.amittaigames.graph;

import org.lwjgl.opengl.GL11;

public class Render {

	public void clear(int r, int g, int b) {
		GL11.glClearColor(rgb(r), rgb(g), rgb(b), 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public void setColor(int r, int g, int b) {
		GL11.glColor3f(rgb(r), rgb(g), rgb(b));
	}
	
	public void drawRect(float x, float y, float width, float height) {
		GL11.glPushMatrix();
		
		GL11.glLineWidth(1.5f);
		GL11.glBegin(GL11.GL_LINES);
		{
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	public void drawPoint(Point p) {
		GL11.glPushMatrix();
		
		float width = Graph.current.getWidthOffset() / 4f;
		float height = Graph.current.getHeightOffset() / 4f;
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(p.getRealX() - width, p.getRealY() - height);
			GL11.glVertex2f(p.getRealX() + width, p.getRealY() - height);
			GL11.glVertex2f(p.getRealX() + width, p.getRealY() + height);
			GL11.glVertex2f(p.getRealX() - width, p.getRealY() + height);
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	public void drawLine(Vector a, Vector b, float size) {
		GL11.glPushMatrix();
		
		GL11.glLineWidth(size);
		GL11.glBegin(GL11.GL_LINES);
		{
			GL11.glVertex2f(a.getX(), a.getY());
			GL11.glVertex2f(b.getX(), b.getY());
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	public float rgb(int rgb) {
		return ((float)rgb/255f);
	}
	
}