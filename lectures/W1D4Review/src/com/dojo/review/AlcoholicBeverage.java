package com.dojo.review;

public class AlcoholicBeverage extends Beverage {
	private double percentageOfAlcohol;

	public AlcoholicBeverage(double temperature, boolean hasIce, boolean isCarbonated, int numOfOunces, 
			double percentageOfAlcohol) {
		// super refers to the parent class
		// super() => calling the parent class constructor
		super(temperature, hasIce, isCarbonated, numOfOunces);
		this.percentageOfAlcohol = percentageOfAlcohol;
	}

	public double getPercentageOfAlcohol() {
		return percentageOfAlcohol;
	}

	public void setPercentageOfAlcohol(double percentageOfAlcohol) {
		this.percentageOfAlcohol = percentageOfAlcohol;
	}

	@Override
	public void mixBeverage() {
		// TODO Auto-generated method stub
		System.out.println("Shaken, not stirred.");
	}

	@Override
	public void drinkBeverage() {
		// TODO Auto-generated method stub
		System.out.println("Cheers!");
	}
	
	
}
