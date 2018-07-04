package com.pokergame.pokergame;

import java.util.*;



public class Player {
	private Boolean isJoker = false;
	private ArrayList<Card> myHand;
	private int myHandCounter=0;
	private static final int MAX_HAND_CARDS = 5;
	private Deck deck;
	Random random;
	
	// コンストラクタ
	public Player() {
		deck = new Deck();
		myHand = new ArrayList<>();
	}
	
	// 手札の追加
	public void draw(int index) {
		Card card = deck.drawCard(index);
		if(myHandCounter<MAX_HAND_CARDS) {
			myHand.add(card);
			myHandCounter++;
		} else {
			// failed...
		}
	}
	
	// 手札の削除
	public void remove(int index) {
		myHand.remove(index);
	}
	
	// 手札と山札のリセット
	public void clear() {
		myHand.clear();
		deck.shuffle();
	}
	
	// 乱数生成
//	public int createRandom(int times) {
//		int number;
//		Long seed = System.currentTimeMillis();
//		random = new Random(seed);
//		number = random.nextInt() % times;
//		if(number<0) {
//			number*=-1;
//		}
//		return number;
//	}
	
//	// 同じカードを引いているかどうか
//	public Boolean isSameCard(String kind, int number) {
//		switch (kind) {
//			case Spade.name: if(spadeList.number[number]==0) return true;
//			case Diamond.name: if(diamondList.number[number]==0) return true;
//			case Heart.name: if(heartList.number[number]==0) return true;
//			case Club.name: if(clubList.number[number]==0) return true;
//		}
//		return false;
//	}
//	
//	// カードを生成する
//	public void createCard() {
//		String kind;
//		int number;
//		int kind_number;
//		Card card=null;
//		
//		// Jokerを生成するかしないか
//		if(!isJoker) {
//			if(createRandom(53)==0) {
//				card = new Joker(99);
//				isJoker = true;
//				add(card);
//			}
//		}
//		
//		// Jokerでない場合
//		if(card==null) {
//			kind_number = createRandom(4);
//			
//			switch (kind_number) {
//				case 0: kind = Spade.name; break;
//				case 1: kind = Diamond.name; break;
//				case 2: kind = Heart.name; break;
//				case 3: kind = Club.name; break;
//				default: kind = null; break;
//			}
//			
//			// 数字(0~12)を生成
//			number = createRandom(13);
//	
//			// すでに山札からそのカードが引かれているかどうか
//			if(!isSameCard(kind, number)) {
//				// カードを生成したあとは山札リストの数字を0にする
//				switch (kind) {
//					case Spade.name: card = new Spade(number+1);
//						 			  spadeList.number[number] = 0;
//						 			  break;
//					case Diamond.name: card = new Diamond(number+1);
//						 				diamondList.number[number] = 0;
//						 				break;
//					case Heart.name: card = new Heart(number+1);
//						 	 		  heartList.number[number] = 0;
//						 	 		  break;
//					case Club.name: card = new Club(number+1);
//				 		 			clubList.number[number] = 0;
//				 		 			break;
//					default: card = null;
//						 	break;
//				}
//				add(card);
//			} else {
//				// 乱数生成の結果同じ数字となったので作り直し
//				createCard();
//			}
//		}	
//	}
//	
	public ArrayList<Card> getMyHand() {
		return myHand;
	}
	
}
