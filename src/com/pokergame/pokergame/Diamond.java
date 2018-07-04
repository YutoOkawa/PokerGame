package com.pokergame.pokergame;

public class Diamond extends Card {
	public static final String name = "Diamond";
	private int number;
	
	public Diamond(int number) {
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
