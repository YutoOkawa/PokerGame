package com.pokergame.pokergame;

public abstract class Card {
	public boolean isOpen = false;
	
	public Card() {
	}
	
	public abstract int getNumber();
	
    
	public abstract String getName();
}
