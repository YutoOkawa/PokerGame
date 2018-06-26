package com.pokergame.pokergame;

public class Heart extends Card {
	private int number;
	
	@Override
	public int getNumber() {
		return number;
	}
	
	@Override
    public void setNumber(int number) {
        this.number = number;
    }
}
