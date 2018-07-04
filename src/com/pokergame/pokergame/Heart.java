package com.pokergame.pokergame;

public class Heart extends Card {
	public static final String name = "Heart";
	private int number;
	
	public Heart(int number) {
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
