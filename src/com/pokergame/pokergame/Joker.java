package com.pokergame.pokergame;

public class Joker extends Card {
	public static final String name = "Joker";
	private int number;
	
	public Joker(int number) {
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
