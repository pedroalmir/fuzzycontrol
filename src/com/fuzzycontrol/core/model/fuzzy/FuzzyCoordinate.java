package com.fuzzycontrol.core.model.fuzzy;

/**
 * @author ewertonsjp
 */
public class FuzzyCoordinate {

	private double x;
	private double y;
	
	public FuzzyCoordinate() {
		
	}
	
	public FuzzyCoordinate(double x, double y) {
		this();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "FuzzyCoordinate [x=" + x + ", y=" + y + "]";
	}
	
}