package com.pokergame.pokergame;

public class Club extends Card {
	private int number;
	public static final String name = "Club";
	
	public Club(int number) {
		this.number = number;
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
