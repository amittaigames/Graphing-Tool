package com.amittaigames.math;

public class ExtraMath {

	public static float average(float... v) {
		float ret = 0;
		for (int i = 0; i < v.length; i++) {
			ret += v[i];
		}
		ret /= v.length;
		return ret;
	}
	
}