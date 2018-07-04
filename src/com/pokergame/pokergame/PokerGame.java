package com.pokergame.pokergame;


public class PokerGame {
	private static final int MY_HAND = 5;
	public static void main(String[] args) {
		Player player = new Player();
		for(int i=0; i<MY_HAND; i++) {
			player.draw(i);
			System.out.print("記号:"+player.getMyHand().get(i).getName());
			System.out.println("数字:"+player.getMyHand().get(i).getNumber());
		}
		
		ScoreCalculator scoreCalculator = new ScoreCalculator(player);
		String yaku = scoreCalculator.createScore();
		System.out.println(yaku);

	}

}
