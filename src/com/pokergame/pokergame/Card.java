package com.pokergame.pokergame;

public abstract class Card {
	private int number;
	
	Card(int number) {
		this.number = number;
	}
	
	public abstract int getNumber();
	
	public abstract void setNumber(int number);
	
	public abstract String getName();
}
