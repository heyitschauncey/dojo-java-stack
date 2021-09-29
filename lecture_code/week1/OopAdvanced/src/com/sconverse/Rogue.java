package com.sconverse;

public class Rogue extends Human {
	public Rogue() {
		super();
		this.dexterity = 20;
	}
	
	public void attack(Race target) {
		target.health -= this.dexterity;
	}
}
