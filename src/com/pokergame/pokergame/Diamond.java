package com.pokergame.pokergame;

public class Diamond extends Card {
	private int number;
	public static final String name = "Diamond";
	
	public Diamond(int number) {
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
