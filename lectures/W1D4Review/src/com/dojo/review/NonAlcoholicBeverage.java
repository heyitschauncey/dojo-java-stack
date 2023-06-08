package com.dojo.review;

public class NonAlcoholicBeverage extends Beverage {
	private boolean hasSweenter;

	public NonAlcoholicBeverage(double temperature, boolean hasIce, boolean isCarbonated, int numOfOunces,
			boolean hasSweenter) {
		super(temperature, hasIce, isCarbonated, numOfOunces);
		this.hasSweenter = hasSweenter;
	}

	public boolean getHasSweenter() {
		return hasSweenter;
	}

	public void setHasSweenter(boolean hasSweenter) {
		this.hasSweenter = hasSweenter;
	}

	@Override
	public void mixBeverage() {
		// TODO Auto-generated method stub
		System.out.println("Make sure the sugar is all desolved.");
	}

	@Override
	public void drinkBeverage() {
		// TODO Auto-generated method stub
		System.out.println("Ahhhh, refreshing!");
	}
	
	
}
