package com.pokergame.pokergame;

import java.util.*;


public class Player {
	private ArrayList<Card> myHand;
	Random random;
	int deckCounter = 0;
	int drawCounter = 0;
	
	// コンストラクタ
	public Player() {
		myHand = new ArrayList<>();
	}
	
	// 手札の追加
	public void draw(Deck deck,int index) {
		Card card = deck.drawCard(index);
		myHand.add(index,card);
		deckCounter++;
		card.setIsOpen(true);
	}
	
	public void change(Deck deck, int index,int changeIndex) {
		remove(index);
		Card card = deck.drawCard(changeIndex);
		myHand.add(index,card);
		deckCounter++;
		card.setIsOpen(true);
	}
	
	// 手札の削除
	public void remove(int index) {
		myHand.remove(index);
	}
	
	// 手札のリセット
	public void clear() {
		myHand.clear();
	}
	
	// 手札のカードを返す
	public Card getHandCard(int index) {
		return myHand.get(index);
	}
	
	// 手札のカードを全て返す
	public ArrayList<Card> getMyHand() {
		return myHand;
	}
	
}
