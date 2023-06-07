package com.sconverse.stsdemo;

import java.io.Console;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello from my STS project.");
		
		Car car1 = new Car(1993, "Ford", "Cobra", "red");
		
		System.out.println(car1.getYear());
		System.out.println();
		
		Console console = System.console();
		
		String userName = console.readLine();
		
		System.out.println(userName);
	}

}
