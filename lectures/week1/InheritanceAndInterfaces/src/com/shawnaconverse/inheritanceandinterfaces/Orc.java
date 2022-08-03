package com.shawnaconverse.inheritanceandinterfaces;

public class Orc extends Race {
	public Orc() {
		super();
		this.strength = 20;
		this.intelligence = 5;
		this.health = 150;
	}
	
	public void rest() {
		System.out.println("Resting...");
		this.health += 50;
	}
	
	public void eat() {
		System.out.println("Eat some boar!");
		this.health += 50;
	}
	
	public void attack(Race target) {
		target.health -= this.strength;
		System.out.println("Dealt " + this.strength + " damage.");
	}
}
