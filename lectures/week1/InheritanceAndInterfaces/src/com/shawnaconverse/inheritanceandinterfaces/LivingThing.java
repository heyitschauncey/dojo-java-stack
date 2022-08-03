package com.shawnaconverse.inheritanceandinterfaces;

public interface LivingThing {
	default void speak() {
		System.out.println("I AM SPEAKING!");
	}
	
	abstract void rest();
	
	abstract void eat();
}
