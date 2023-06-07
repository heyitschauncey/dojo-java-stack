package com.codingdojo.oopadvanced;

public class Job {
	// MEMBER VARIABLES
	// these variables are declared NOT initialized
	
	// 
	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected int health;
	
	// CONSTRUCTOR
	// this is where we initialize the member variables
	public Job() {
		this.strength = 10;
		this.dexterity = 10;
		this.intelligence = 10;
		this.health = 100;
	}
	
	// METHODS
	// method syntax
	// accessModifier returnDataType funcName(param1, param2...){}
	// void means we will not have a return statement
	public void attack(Job target) {
		int newHealth = target.getHealth() - this.strength;
		
		target.setHealth(newHealth);
	}
	
	public void rest() {
		this.health += 10;
	}
	
	// GETTERS AND SETTERS

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
