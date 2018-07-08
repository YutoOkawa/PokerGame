package com.pokergame.pokergame;

import java.util.*;


public class Player {
	private ArrayList<Card> myHand;
	Random random;
	
	// コンストラクタ
	public Player() {
		myHand = new ArrayList<>();
	}
	
	// 手札の追加
	public void draw(Deck deck,int index) {
		Card card = deck.drawCard(index);
		myHand.add(card);
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
	
	public ArrayList<Card> getMyHand() {
		return myHand;
	}
	
}
