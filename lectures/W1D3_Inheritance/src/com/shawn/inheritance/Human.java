package com.shawn.inheritance;

public class Human {
	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected int health;

	// Constructor
	public Human() {
		this.strength = 10;
		this.dexterity = 10;
		this.intelligence = 10;
		this.health = 100;
	}

	// Methods
	public void attack(Human target) {
		target.setHealth(target.getHealth() - this.strength);
		System.out.printf("The target took %d damage.\n", this.strength);
	}
	
	public void rest() {
		this.health += 10;
		System.out.println("Rested and healed 10 health.");
	}
	
	// Getters and Setters
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
