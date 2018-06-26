package com.pokergame.pokergame;

public class Spade extends Card {
	private int number;
	
	Spade(int number) {
		super(number);
	}
	
	@Override
	public int getNumber() {
		return number;
	}
	
	@Override
    public void setNumber(int number) {
        this.number = number;
    }
}
