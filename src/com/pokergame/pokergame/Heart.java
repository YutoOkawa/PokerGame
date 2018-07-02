package com.pokergame.pokergame;

public class Heart extends Card {
	private int number;
	public static final String name = "Heart";
	
	Heart(int number) {
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
