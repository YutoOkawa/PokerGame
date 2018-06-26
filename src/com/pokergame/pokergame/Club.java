package com.pokergame.pokergame;

public class Club extends Card {
	private int number;
	
	Club(int number) {
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
