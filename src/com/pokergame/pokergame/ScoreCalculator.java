package com.pokergame.pokergame;

import java.util.*;


public class ScoreCalculator {
	private CardManager cardManager;
	private ArrayList<Integer> cardNumber;
	private ArrayList<String> cardName;
	private ArrayList<Card> cardList;
	private Boolean isJoker;
	private static final int MY_HAND = 5;
	private static final String Royal_Straight_Flash = "Royal_Straight_Flash";
	private static final String Five_Card = "Five_Card";
	private static final String Straight_flash = "Straight_flash"; 
	private static final String Four_Card = "Four_Card";
	private static final String Full_House = "Full_House"; 
	private static final String Flush = "Fulsh";
	private static final String Straight = "Straight"; 
	private static final String Three_Card = "Three_Card";
	private static final String Two_Pair = "Two_Pair"; 
	private static final String one_Pair = "One_Pair";
	private static final String No_Pair = "No_Pair"; 
	
	// コンストラクタ
	public ScoreCalculator(CardManager cardManager) {
		this.setCardManager(cardManager);
		cardList = cardManager.getMyHand();
		cardNumber = new ArrayList<>();
		cardName = new ArrayList<>();
		for(int i=0; i<MY_HAND; i++) {
			cardNumber.add(cardList.get(i).getNumber());
			cardName.add(cardList.get(i).getName());
		}
		checkJoker();
	}
	
	// Jokerが手札にあるかどうか
	public void checkJoker() {
		if(cardName.indexOf(Joker.name)!=-1) {
			isJoker = false;
		}
		isJoker = true;
	}
	
	// 手札の全ての記号が同じか(Flushであるか)
	public boolean isFlush() {
		for(int i=0; i<MY_HAND-1; i++) {
			if(!cardName.get(i).equals(cardName.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	// 手札の全ての数字が順番に並んでいるか(Straightであるか)
	public boolean isStraight() {
		Collections.sort(cardNumber);
		for(int i=1; i<MY_HAND; i++) {
			if(cardNumber.get(0)!=(cardNumber.get(i)+i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isRoyalStraightFlush() {
		int aceIndex;
		if((aceIndex=cardNumber.indexOf(1))==-1) {
			return false;
		} else {
			cardNumber.add(aceIndex, 14);
			if(!(isStraight() && isFlush())) {
				return false;
			}
		}
		return true;
	}

	// ストレート、フラッシュ以外の役の検索
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
	
	// 役の選出
	public String createScore() {
		if(isRoyalStraightFlush()) {
			return Royal_Straight_Flash;
		} else if (isFlush() && isStraight()) {
			return Straight_flash;
		} else if (isFlush()) {
			return Flush;
		} else if (isStraight()) {
			return Straight;
		}
		
		switch (Npair()) {
			case 1:return one_Pair; 
			case 2:return Two_Pair;
			case 3:return Three_Card;
			case 4:return Full_House;
			case 6:return Four_Card;
			case 10:return Five_Card;
			default: break;
		}
		
		return No_Pair;
	}

	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

}
