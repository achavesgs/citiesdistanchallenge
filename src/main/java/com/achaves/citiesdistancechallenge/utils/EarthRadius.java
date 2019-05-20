package com.achaves.citiesdistancechallenge.utils;

/**
 * Enum that indicates the radius of the earth in Kilometers or Miles
 * 
 * @author Aline Chaves
 */
public enum EarthRadius {
	
	KM(6371), MI(3959);
	
	private int radius;

	private EarthRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
}