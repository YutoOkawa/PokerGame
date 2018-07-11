package com.pokergame.pokergame;

public class Spade extends Card {
	private int number;
	
	public Spade(int number) {
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
