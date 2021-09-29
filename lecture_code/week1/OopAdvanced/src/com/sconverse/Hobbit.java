package com.sconverse;

public class Hobbit extends Race {
	private String height;
	
	public Hobbit() {
		super();
		this.strength = 5;
		this.health = 70;
		this.dexterity = 13;
		this.height = "quite short";
	}
	
	public String getHeight() {
		return this.height;
	}
}
