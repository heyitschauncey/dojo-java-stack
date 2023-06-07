package com.codingdojo.oopadvanced;

public class Bard extends Job implements JobAbilities {
	private int rizz;
	
	
	public Bard() {
		super();
		this.strength = 6;
		this.health = 80;
		this.dexterity = 15;
		this.rizz = 30;
	}


	public int getRizz() {
		return rizz;
	}


	public void setRizz(int rizz) {
		this.rizz = rizz;
	}
	
	@Override
	public void attack(Job target) {
		int newHealth = target.getHealth() - (this.dexterity + this.rizz);
		
		target.setHealth(newHealth);
	}
	
	@Override
	public void rest() {
		this.health += 8;
	}


	@Override
	public void warcry() {
		System.out.println("LEEEEEEROOOOOY");
	}

	@Override
	public void catchphrase() {
		System.out.println("Follow me on Spotify.");
	}
}
