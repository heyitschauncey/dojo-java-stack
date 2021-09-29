package com.sconverse;

public abstract class Monster implements LivingThing{
	protected String type;
	
	public Monster() {
		this.type = "monster";
	}
	
	public void rest() {
		System.out.println("I am resting");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
