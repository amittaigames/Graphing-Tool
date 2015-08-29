package com.amittaigames.math;

import com.amittaigames.graph.Point;
import com.amittaigames.graph.Vector;

public class SlopeIntercept {

	public static float findSlope(Vector a, Vector b) {
		float slope = 0;
		float ax = a.getX();
		float ay = a.getY();
		float bx = b.getX();
		float by = b.getY();
		slope = (by - ay) / (bx - ax);
		return slope;
	}
	
	public static float findSlope(Point a, Point b) {
		float slope = 0;
		float ax = a.getRealX();
		float ay = a.getRealY();
		float bx = b.getRealX();
		float by = b.getRealY();
		slope = (by - ay) / (bx - ax);
		return slope;
	}
	
	public static float solveForY(float x, float slope, float yint) {
		float y = (slope * x) + yint;
		return y;
	}
	
	public static float findInterceptY(float x, float y, float slope) {
		float yint = 0;
		float a = x * slope;
		float b = y - a;
		yint = b;
		return yint;
	}
	
}