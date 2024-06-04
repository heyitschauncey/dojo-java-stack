package com.shawn.stsdemo;

public class Dog {
	private String name;
	private int age;
	private String hairColor;

	public Dog() {}

	public Dog(String name, int age, String hairColor) {
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}
