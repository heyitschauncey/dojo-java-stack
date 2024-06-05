package com.shawn.inheritance;

public class Warrior extends Human {

	public Warrior() {
		super(); // Human()
		this.strength = 15;
		this.intelligence = 5;
		this.health = 150;
	}
	
	public void attack(Human target) {
		int damage = this.strength * 2;
		target.setHealth(target.getHealth() - damage);
		System.out.printf("The target took %d damage.\n", damage);
	}

}
