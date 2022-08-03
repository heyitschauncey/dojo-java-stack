package com.shawnaconverse.inheritanceandinterfaces;

public class Human extends Race implements LivingThing {
	public Human() {
		super();
	}
	
	public void attack(Race target) {
		target.health -= this.strength;
		System.out.println("Dealt " + this.strength + " damage.");
	}
	
	public void rest() {
		System.out.println("Resting...");
		this.health += 10;
	}
	
	public void eat() {
		System.out.println("Eat some pizza!");
		this.health += 40;
	}
	
	public void speak() {
		System.out.println("I AM A HUMAN SPEAKING");
	}
	
	public void test(LivingThing thing) {
		System.out.println(thing);
		thing.eat();
		System.out.println("Hello");
	}
}
