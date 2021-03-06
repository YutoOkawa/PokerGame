package com.pokergame.pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;
	private static final int MAX_SUIT = 4;
	private static final int MAX_NUMBER = 13;
	private int MAX_DECK = 53;
	
	public Deck() {
		deck = new ArrayList<>();
		for(int i=0; i<MAX_SUIT; i++) {
			for(int k=0; k<MAX_NUMBER; k++) {
				Card card;
				switch (i) {
					case 0: card = new Spade(k+1); break;
					case 1: card = new Diamond(k+1); break;
					case 2: card = new Heart(k+1); break;
					case 3: card = new Club(k+1); break;
					default: card = null; break;
				}
				deck.add(card);
			}
		}
		deck.add(new Joker(99));
		shuffle();
	}
	
	public void shuffle() {
		Long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		Collections.shuffle(deck, random);
	}
	
	public Card drawCard(int index) {
		MAX_DECK--;
		return deck.get(index);
	}

	public int getMAX_DECK() {
		return MAX_DECK;
	}
}
