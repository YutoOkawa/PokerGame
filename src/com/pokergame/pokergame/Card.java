package com.pokergame.pokergame;

public abstract class Card {
	private int number;
	
	public Card() {
		
	}
	
	public Card(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
    public void setNumber(int number) {
        this.number = number;
    }
	
	public abstract String getName();
}
