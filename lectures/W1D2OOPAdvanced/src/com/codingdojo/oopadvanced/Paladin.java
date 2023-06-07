package com.codingdojo.oopadvanced;


// INHERITANCE
public class Paladin extends Job {
	private int faith;
	
	// CONSTRUCTOR
	public Paladin() {
		// super refers to the parent class (aka super class)
		// in this case think of super as Job()
		// when we see the name of a class that is invoked we are making
		// an instance (aka object)
		// in other words calling the constructor of the parent
		super();
		this.faith = 20;
		this.strength = 15;
		this.health = 150;
		
	}
	
	// attack comes from job
	// Polymorphism allows us to overwrite and change methods
	// from the parent
	public void attack(Job target) {
		int newHealth = target.getHealth() - (this.strength + this.faith);
		
		target.setHealth(newHealth);
	}

	public int getFaith() {
		return faith;
	}

	public void setFaith(int faith) {
		this.faith = faith;
	}

}
