package com.dojo.review;

public class Main {

	public static void main(String[] args) {
//		Beverage bev1 = new Beverage(55.0, false, true, 16);
//		Beverage bev2 = new Beverage(175.0, false, false, 12);
//
//		bev1.stirBeverage();
//		bev2.drinkBeverage();
//		System.out.println(bev2.getNumOfOunces());
		
		
		AlcoholicBeverage beer = new AlcoholicBeverage(35.0, false, true, 12, 5.0);
		AlcoholicBeverage wine = new AlcoholicBeverage(55.0, false, false, 6, 12.0);
		NonAlcoholicBeverage lemonade = new NonAlcoholicBeverage(35.0, true, false, 12, true);
		
		
		System.out.println(beer.getPercentageOfAlcohol());

		System.out.println(beer.getTemperature());
		
		System.out.println(lemonade.getHasSweenter());
		
		
		beer.mixBeverage();
		lemonade.mixBeverage();
	}

}
