package com.pokergame.pokergame;

public class Diamond extends Card {
	private int number;
	
	public Diamond(int number) {
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
