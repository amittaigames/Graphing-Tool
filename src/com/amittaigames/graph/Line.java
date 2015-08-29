package com.amittaigames.graph;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private Vector a;
	private Vector b;
	
	public static List<Line> list = new ArrayList<Line>();
	
	public Line(Vector a, Vector b) {
		this.a = a;
		this.b = b;
		list.add(this);
	}
	
	public Vector getPointA() {
		return a;
	}
	
	public Vector getPointB() {
		return b;
	}
	
}