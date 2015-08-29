package com.amittaigames.graph;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class Main extends Core {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	public static Graph graph;
	
	public static void main(String[] args) {
		Window.init("Graphing is Cool", WIDTH, HEIGHT, 60, new Main());
	}

	@Override
	public void init() {
		graph = new Graph(20, 20);
		
		// Hiding Mouse
		/*
		int min = 16;
		IntBuffer tmp = BufferUtils.createIntBuffer(min * min);
		try {
			Mouse.setNativeCursor(new Cursor(16, 16, 0, 0, 1, tmp, null));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	@Override
	public void render(Render r) {
		r.clear(255, 255, 255);
		
		r.setColor(82, 82, 82);
		graph.draw(r);
		
		r.setColor(0, 122, 163);
		
		// Points
		for (int i = 0; i < Point.list.size(); i++) {
			Point p = Point.list.get(i);
			r.drawPoint(p);
		}
		
		// Lines
		for (int i = 0; i < Line.list.size(); i++) {
			Line l = Line.list.get(i);
			r.drawLine(l.getPointA(), l.getPointB(), 2.5f);
		}
		
		r.setColor(255, 0, 0);
		//r.drawRect((float)Mouse.getX() - 5, (float)Mouse.getY() + 5, 10, 10);
	}

	@Override
	public void update(int delta) {
		Mouse.updateCursor();
		if (Mouse.isButtonDown(0)) {
			new Point(Mouse.getX() / Graph.current.getWidthOffset(), Mouse.getY() / Graph.current.getHeightOffset());
		}
	}
	
}