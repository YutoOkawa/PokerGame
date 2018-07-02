package com.pokergame.pokergame;

import java.util.ArrayList;

public class CardManager {
	private ArrayList<Card> myHand = new ArrayList<>();
	private int myHandCounter=0;
	private static final int MAX_HAND_CARDS = 5;  // 1 minute
	
	public ArrayList<Card> getCards() {
		return myHand;
	}
	
	public void add(Card card) {
		if(myHandCounter<MAX_HAND_CARDS) {
			myHand.add(card);
			myHandCounter++;
		} else {
			// failed...
		}
	}
	
	public void remove(int index) {
		myHand.remove(index);
	}
	
	public void clear() {
		myHand.clear();
	}
	
	public Card createCard(String kind, int number) {
		if (kind.equals(Spade.name)) {
            return new Spade(number);
        } else if (kind.equals(Diamond.name)) {
            return new Diamond(number);
        } else if (kind.equals(Heart.name)) {
            return new Heart(number);
        } else if (kind.equals(Club.name)) {
            return new Club(number);
        } 
        return null;
	}
}
