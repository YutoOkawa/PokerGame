package com.pokergame.pokergame;

public class Spade extends Card {
	private int number;
	public static final String name = "Spade";
	
	public Spade(int number) {
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
