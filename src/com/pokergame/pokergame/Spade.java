package com.pokergame.pokergame;

public class Spade extends Card {
	public static final String name = "Spade";
	private int number;
	
	public Spade(int number) {
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
