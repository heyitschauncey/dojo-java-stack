package com.dojo.review;

public abstract class Beverage implements TestInterface{
	// Member Variables
	private double temperature;
	private boolean hasIce;
	private boolean isCarbonated;
	private int numOfOunces;
	
	// Constructors
	public Beverage(double temperature, boolean hasIce, boolean isCarbonated, int numOfOunces) {
		this.temperature = temperature;
		this.hasIce = hasIce;
		this.isCarbonated = isCarbonated;
		this.numOfOunces = numOfOunces;
	}
	
	// Methods
	// these are method stubs
	// aka unimplemented methods
	public abstract void mixBeverage();
	public abstract void drinkBeverage();
	
	
	// Getters and Setters

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public boolean getHasIce() {
		return hasIce;
	}

	public void setHasIce(boolean hasIce) {
		this.hasIce = hasIce;
	}

	public boolean getIsCarbonated() {
		return isCarbonated;
	}

	public void setCarbonated(boolean isCarbonated) {
		this.isCarbonated = isCarbonated;
	}

	public int getNumOfOunces() {
		return numOfOunces;
	}

	public void setNumOfOunces(int numOfOunces) {
		this.numOfOunces = numOfOunces;
	}
	
}
