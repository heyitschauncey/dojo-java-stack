package com.shawn.inheritance;

public class Wizard extends Human {

	public Wizard() {
		super();
		this.strength = 5;
		this.intelligence = 15;
		this.health = 75;
	}
	
	public void attack(Human target) {
		int damage = this.intelligence * 2;
		target.setHealth(target.getHealth() - damage);
		System.out.printf("The target took %d damage.\n", damage);
	}

}
