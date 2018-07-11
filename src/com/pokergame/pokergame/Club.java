package com.pokergame.pokergame;

public class Club extends Card {
	private int number;
	
	public Club(int number) {
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
