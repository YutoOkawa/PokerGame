package com.pokergame.pokergame;

public class Club extends Card {
	public static final String name = "Club";
	private int number;
	
	public Club(int number) {
		setNumber(number);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getNumber() {
		return number;
	}
	
    public void setNumber(int number) {
        this.number = number;
    }
}
