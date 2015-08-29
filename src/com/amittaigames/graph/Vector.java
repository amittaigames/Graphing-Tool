package com.amittaigames.graph;

public class Vector {

	private float x;
	private float y;
	
	//public static List<Vector> list = new ArrayList<Vector>();
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
		//list.add(this);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}