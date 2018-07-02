package com.pokergame.pokergame;

public class Club extends Card {
	private int number;
	public static final String name = "Club";
	
	Club(int number) {
		super(number);
	}
	
	@Override
	public String getName() {
		return name;
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
