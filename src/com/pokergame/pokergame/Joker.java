package com.pokergame.pokergame;

public class Joker extends Card {
	private int number;
	
	public Joker(int number) {
		setNumber(number);
	}
	
	@Override
	public int getNumber() {
		return number;
	}
	
    public void setNumber(int number) {
        this.number = number;
    }
	
}
