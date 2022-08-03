package com.shawnaconverse.inheritanceandinterfaces;

public class Rogue extends Human {

	public Rogue() {
		super();
		this.dexterity = 20;
	}
	
	public void attack(Human target) {
		target.health -= this.dexterity;
	}

}
