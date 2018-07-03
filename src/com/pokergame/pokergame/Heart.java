package com.pokergame.pokergame;

public class Heart extends Card {
	private int number;
	public static final String name = "Heart";
	
	public Heart(int number) {
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
