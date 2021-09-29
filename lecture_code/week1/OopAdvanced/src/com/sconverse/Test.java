package com.sconverse;

public class Test {

	public static void main(String[] args) {
		Human human = new Human();
		Rogue rogue = new Rogue();
		Slime slime = new Slime();
		Hobbit hobbit = new Hobbit();
		
//		System.out.println(human.getDexterity());
//		System.out.println(human.getHealth());
//		System.out.println(rogue.getDexterity());
//		System.out.println(rogue.getHealth());
		
		human.speak();
		rogue.speak();
		slime.speak();
		System.out.println(slime.getType());
		
		System.out.println(hobbit.getHeight());
		
	}

}
