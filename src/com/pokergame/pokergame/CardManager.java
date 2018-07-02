package com.pokergame.pokergame;

import java.util.*;


public class CardManager {
	private ArrayList<Card> myHand;
	private int myHandCounter=0;
	private static final int MAX_HAND_CARDS = 5;  
	Random random;
	
	public CardManager() {
		myHand = new ArrayList<>();
	}
	
	public ArrayList<Card> getMyHand() {
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
	
	public void createRandom() {
		Long seed = System.currentTimeMillis();
		random = new Random(seed);
	}
	
	public Boolean isSameCard(Card card) {
		for(int i=0; i<myHand.size(); i++) {
			Card currentCard = myHand.get(i);
			if(card.getNumber()==(currentCard.getNumber()) && card.getName().equals(currentCard.getName())) {
				return false;
			}
		}
		return true;
	}
	
	public void createCard() {
		String kind=null;
		int number;
		int kind_number;
		
		createRandom();
		if((random.nextInt() % 53)==0) {
			kind = Joker.name;
		}
		
		createRandom();
		number = random.nextInt() % 13;
		createRandom();
		kind_number = random.nextInt() % 4;
		
		if(kind!=null) {
			switch (kind_number) {
				case 0 : kind = Spade.name; break;
				case 1 : kind = Diamond.name; break;
				case 2 : kind = Heart.name; break;
				default: kind = Club.name; break;
			}
		}	
		createCard(kind, number);
	}
	
	
	public void createCard(String kind, int number) {
		Card card;
		if (kind.equals(Joker.name)) {
			card = new Joker();
		} else if (kind.equals(Spade.name)) {
            card = new Spade(number);
        } else if (kind.equals(Diamond.name)) {
            card = new Diamond(number);
        } else if (kind.equals(Heart.name)) {
            card = new Heart(number);
        } else if (kind.equals(Club.name)) {
            card = new Club(number);
        } else {
        	card = null;
        }
		
		if(card!=null) {
			if(isSameCard(card)) {
				add(card);
			} else {
				createCard();
			}
		} else {
			// failed...
		}
	}
}
