package com.pokergame.pokergame;


import java.util.*;

public class PokerGame {
	private static final int MY_HAND = 5;
	public static void main(String[] args) throws InterruptedException {
		MainFrame mainFrame = new MainFrame("Poker");
		mainFrame.setVisible(true);
	}
	
	public void poker() {
		Player player = new Player();
		Deck deck = new Deck();
		for(int i=0; i<MY_HAND; i++) {
			player.draw(deck,i);
			System.out.print("記号:"+player.getMyHand().get(i).getName());
			System.out.println("数字:"+player.getMyHand().get(i).getNumber());
		}
		
		ScoreCalculator scoreCalculator = new ScoreCalculator(player);
		String yaku = scoreCalculator.createScore();
		System.out.println(yaku);
		
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		
		player.remove(index);
		player.draw(deck, 5);
		
		for(int i=0; i<MY_HAND; i++) {
			System.out.print("記号:"+player.getMyHand().get(i).getName());
			System.out.println("数字:"+player.getMyHand().get(i).getNumber());
		}
		
		scoreCalculator = new ScoreCalculator(player);
		yaku = scoreCalculator.createScore();
		System.out.println(yaku);
	}
}
