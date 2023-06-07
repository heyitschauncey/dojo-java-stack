package com.codingdojo.oopadvanced;

public class Test {

	public static void main(String[] args) {
//		String s1 = "Hello there.";
//		String s2 = new String("General Kenobi");
//		
//		// Java has wrapper classes for primitive data types
//		int primNum1 = 3;
//		Integer num1 = 3;
//		Double num2 = 3.5;
//		Boolean thing = true;

		// when making a variable the syntax is 
		// datatype varName = data
//		Job jason = new Job();
//		Job jake = new Job();
//		
//		jason.attack(jake);
//			
//		System.out.println(jake.getHealth());
//		
//		jake.rest();
//		
//		System.out.println(jake.getHealth());
		
		
		Paladin tim = new Paladin();
		Paladin will = new Paladin();
		
		System.out.println("Health of Paladin object: " + will.getHealth());
		System.out.println(tim.getFaith());
		
		tim.attack(will);
		
		System.out.println(will.getHealth());
		
		System.out.println(tim.dexterity);
		
		will.rest();
		
	}

}

