package com.pokergame.pokergame;


public class PokerGame {
	private static final int MY_HAND = 5;
	public static void main(String[] args) {
		CardManager cardManager = new CardManager();
		for(int i=0; i<MY_HAND; i++) {
			cardManager.createCard();
			System.out.print("記号:"+cardManager.getMyHand().get(i).getName());
			System.out.println("数字:"+cardManager.getMyHand().get(i).getNumber());
		}

	}

}
