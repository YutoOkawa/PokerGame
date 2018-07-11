package com.pokergame.pokergame;

public class Heart extends Card {
	private int number;
	
	public Heart(int number) {
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
