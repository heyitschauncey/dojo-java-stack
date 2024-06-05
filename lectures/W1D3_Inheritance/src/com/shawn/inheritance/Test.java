package com.shawn.inheritance;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Human h1 = new Human();
//		Human h2 = new Human();
//		
//		h1.attack(h2);
//		h1.attack(h2);
//		h1.attack(h2);
//		
//		h2.rest();
		
//		System.out.println(h2.getHealth());
		
		Warrior w1 = new Warrior();
		Warrior w2 = new Warrior();
		Wizard wiz1 = new Wizard();
		
		w1.attack(wiz1);
		w1.attack(wiz1);
		w1.attack(wiz1);
		
		wiz1.rest();
		
		System.out.println(wiz1.getHealth());
		
		
		// List of all the characters in my game
		ArrayList<Human> list = new ArrayList<Human>();
		
		list.add(wiz1);
		list.add(w1);
		list.add(w2);
		
//		System.out.println(list);
	}

}
