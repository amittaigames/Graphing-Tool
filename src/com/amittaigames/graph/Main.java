package com.amittaigames.graph;

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
	}
	
	@Override
	public void render(Render r) {
		r.clear(255, 255, 255);
		
		r.setColor(82, 82, 82);
		graph.draw(r);
		
		r.setColor(0, 122, 163);
		for (int i = 0; i < Point.list.size(); i++) {
			Point p = Point.list.get(i);
			r.drawPoint(p);
		}
	}

	@Override
	public void update(int delta) {
		
	}
	
}