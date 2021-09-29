package com.sconverse;

public interface LivingThing {
	default void speak() {
		System.out.println("This living thing is speaking!!!");
	}
	
	abstract void rest();
}
