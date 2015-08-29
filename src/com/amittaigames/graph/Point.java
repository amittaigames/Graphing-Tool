package com.amittaigames.graph;

import java.util.ArrayList;
import java.util.List;

public class Point {

	private float x;
	private float y;
	private Vector v;
	
	public static List<Point> list = new ArrayList<Point>();
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
		this.v = new Vector(x * Graph.current.getWidthOffset(), y * Graph.current.getHeightOffset());
		list.add(this);
	}
	
	public Vector getVector() {
		return v;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
		setRealX(x);
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
		setRealY(y);
	}
	
	public float getRealX() {
		return v.getX();
	}
	
	public void setRealX(float x) {
		v.setX(x * Graph.current.getWidthOffset());
	}
	
	public float getRealY() {
		return v.getY();
	}
	
	public void setRealY(float y) {
		v.setY(y * Graph.current.getHeightOffset());
	}
	
}