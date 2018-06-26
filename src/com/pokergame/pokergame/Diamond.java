package com.pokergame.pokergame;

public class Diamond extends Card {
	private int number;
	
	Diamond(int number) {
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
