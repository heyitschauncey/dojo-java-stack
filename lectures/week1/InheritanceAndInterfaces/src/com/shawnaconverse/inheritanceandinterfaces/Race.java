package com.shawnaconverse.inheritanceandinterfaces;

public abstract class Race {
	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected int health;

	public Race() {
		this.strength = 10;
		this.dexterity = 10;
		this.intelligence = 10;
		this.health = 100;
	}
	
	
	abstract void rest();
	
	abstract void eat();


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
