package com.amittaigames.graph;

public class Graph {

	private float offw;
	private float offh;
	
	public static Graph current;
	
	public Graph(float offw, float offh) {
		this.offw = offw;
		this.offh = offh;
		current = this;
	}
	
	public void draw(Render r) {
		for (float x = getWidthOffset(); x < Main.WIDTH; x += getWidthOffset()) {
			r.drawLine(new Vector(x, 0), new Vector(x, Main.HEIGHT), 1);
		}
		for (float y = getHeightOffset(); y < Main.HEIGHT; y += getHeightOffset()) {
			r.drawLine(new Vector(0, y), new Vector(Main.WIDTH, y), 1);
		}
	}
	
	public float getWidthOffset() {
		return offw;
	}
	
	public void setWidthOffset(float offw) {
		this.offw = offw;
	}
	
	public float getHeightOffset() {
		return offh;
	}
	
	public void setHeightOffset(float offh) {
		this.offh = offh;
	}
	
}