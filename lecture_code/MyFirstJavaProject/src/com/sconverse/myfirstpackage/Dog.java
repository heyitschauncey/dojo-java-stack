package com.sconverse.myfirstpackage;

public class Dog {
	private String name;
	private String hairColor;
	
	public Dog(String name, String hairColor) {
		super();
		this.name = name;
		this.hairColor = hairColor;
	}
	
	public void borf() {
		System.out.println("Borf borf my name is: " + this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
}
