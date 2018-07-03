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
			isJoker = true;
		} else {
			isJoker = false;
		}
	}
	
	public int checkJoker(int hands) {
		checkJoker();
		if(isJoker)
			return hands-1;
		else 
			return hands-2;
	}
	
	// 手札の全ての記号が同じか(Flushであるか)
	public boolean isFlush() {
		int hands = checkJoker(MY_HAND);
		for(int i=0; i<hands; i++) {
			if(!cardName.get(i).equals(cardName.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	// 手札の全ての数字が順番に並んでいるか(Straightであるか)
	public boolean isStraight() {
		int hands = checkJoker(MY_HAND);
		Collections.sort(cardNumber);
		for(int i=1; i<hands; i++) {
			if(cardNumber.get(0)!=(cardNumber.get(i)+i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isRoyalStraightFlush() {
		int aceIndex=cardNumber.indexOf(1);
		if(aceIndex==-1) {
			return false;
		} else {
			cardNumber.remove(aceIndex);
			cardNumber.add(aceIndex, 14);
			if(!(isStraight() && isFlush())) {
				cardNumber.add(MY_HAND-1,1);
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
		checkJoker();
		
		if(isRoyalStraightFlush()) {
			return Royal_Straight_Flash;
		} else if (isFlush() && isStraight()) {
			return Straight_flash;
		} else if (isFlush()) {
			return Flush;
		} else if (isStraight()) {
			return Straight;
		}
		
		if (Npair()==6 && isJoker) {
			return Five_Card;
		} else if (Npair()==6 || (Npair()==3 && isJoker)) {
			return Four_Card;
		} else if (Npair()==4 || (Npair()==2 && isJoker)) {
			return Full_House;
		} else if (Npair()==3 || (Npair()==1 && isJoker)) {
			return Three_Card;
		} else if (Npair()==2) {
			return Two_Pair;
		} else if (Npair()==1 || (Npair()==0 && isJoker)) {
			return one_Pair;
		} else {
			return No_Pair;
		}
	}

	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

}
