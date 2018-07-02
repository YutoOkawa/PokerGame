package com.pokergame.pokergame;

import java.util.*;

public class ScoreCalculator {
	private CardManager cardManager;
	private ArrayList<Integer> cardNumber;
	private ArrayList<String> cardName;
	private ArrayList<Card> cardList;
	private static final int MY_HAND = 5;
	private static final String Straight_flash = "Straight_flash"; 
	private static final String Four_Card = "Four_Card";
	private static final String Full_House = "Full_House"; 
	private static final String Flush = "Fulsh";
	private static final String Straight = "Straight"; 
	private static final String Three_Card = "Three_Card";
	private static final String Two_Pair = "Two_Pair"; 
	private static final String one_Pair = "One_Pair";
	private static final String No_Pair = "No_Pair"; 
	
	public ScoreCalculator(CardManager cardManager) {
		this.setCardManager(cardManager);
		cardList = cardManager.getMyHand();
		cardNumber = new ArrayList<>();
		cardName = new ArrayList<>();
		for(int i=0; i<MY_HAND; i++) {
			cardNumber.add(cardList.get(i).getNumber());
			cardName.add(cardList.get(i).getName());
		}
	}
	
	public boolean isFlush() {
		for(int i=0; i<MY_HAND-1; i++) {
			if(!cardList.get(i).getName().equals(cardList.get(i+1).getName())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isStraight() {
		Collections.sort(cardNumber);
		for(int i=1; i<MY_HAND; i++) {
			if(!(cardNumber.get(0)!=(cardNumber.get(i))+i)) {
				return false;
			}
		}
		return true;
	}

	// 0:NoPair, 1:OnePair, 2:TwoPair, 3:ThreeCard, 4:FullHouse, 6:FourCard, 10:FiveCard
	public int Npair() {
		int pairChecker=0;
		for(int i=0; i<MY_HAND; i++) {
			for(int k=4; i<k; k--) {
				if(cardNumber.get(i)==cardNumber.get(k)) {
					pairChecker++;
				}
			}
		}
		return pairChecker;
	}

	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

}
