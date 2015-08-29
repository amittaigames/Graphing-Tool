package com.amittaigames.graph;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window {

	private static int width;
	private static int height;
	private static int fps;
	private static Core c;
	private static long lastFrame;
	
	private static long lastFPS;
	private static int LAST = 0;
	private static int FPS;
	
	public static void init(String title, int width, int height, int fps, Core c) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Window.width = width;
		Window.height = height;
		Window.c = c;
		Window.fps = fps;
		Menu.init("Graph Menu", 300, 500, Display.getX() + width + 25, Display.getY());
		start();
	}
	
	private static void start() {
		initGL();
		getDelta();
		
		c.init();
		
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			
			c.update(delta);
			c.render(new Render());
			
			Display.update();
			Display.sync(fps);
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	private static void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, 0, height, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
		private static int getDelta() {
			long time = getTime();
			int delta = (int) (time - lastFrame);
			lastFrame = time;
			return delta;
		}
		
		private static long getTime() {
			return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		}
		
		public static int getCurrentFPS() {
			int ret = LAST;
			if (getTime() - lastFPS > 1000) {
				ret = FPS;
				LAST = FPS;
				FPS = 0;
				lastFPS += 1000;
			}
			FPS++;
			return ret;
		}
	
}