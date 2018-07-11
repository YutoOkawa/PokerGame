package com.pokergame.pokergame;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class DealingCardThread extends Thread{
	GamePanel nowPanel;
	JLabel[] cardLabels = new JLabel[5];
	ImageIcon imageIcon;
	ImageSeceltor imageSeceltor;
	ArrayList<Card> myHand;
	int currentX = 850;
	int currentY = 50;
	int seedX = 50;
	int endX;
	int endY = 450;
	int perX;
	int perY;
	int state = 0;
	int index = 0;
	Boolean[] changeIndex;
	String hand;
	
	public DealingCardThread(GamePanel jPanel,JLabel[] cardLabels) {
		nowPanel = jPanel;
		this.cardLabels = cardLabels;
		changeIndex = new Boolean[6];
		for(int i=0; i<5; i++) {
			changeIndex[i] = true;
		}
		changeIndex[5] = false;
		setCoordinate(state);
	}
	
	public DealingCardThread(GamePanel gamePanel, JLabel[] cardLabels, Boolean[] changeIndex) {
		nowPanel = gamePanel;
		this.cardLabels = cardLabels;
		this.changeIndex  = changeIndex;
		changeIndex[5] = false;
		setCoordinate(state);
	}
	
	public void run() {
		while(state!=5) {
			try {
				if(changeIndex[state])
					sleep(100);
			} catch (InterruptedException e) {}
			currentX = currentX + perX;
			currentY = currentY + perY;
			if(changeIndex[state]) {
				cardLabels[state].setBounds(currentX, currentY, 200, 300);
				nowPanel.add(cardLabels[state],-1);
			}
			nowPanel.repaint();
			if(endX==currentX && endY==currentY) {
				state++;
				if(state!=cardLabels.length) {
					setCoordinate(state);
				}
			}
		}
		nowPanel.setIsLoading(false);
		ScoreCalculator scoreCalculator = new ScoreCalculator(nowPanel.player);
		nowPanel.yaku = scoreCalculator.createScore();
		nowPanel.repaint();
	}
	
	public void setCoordinate(int state) {
		endX = seedX + 200*state;
		currentX = 850;
		currentY = 50;
		perX = (endX - currentX) / 10;
		perY = (endY - currentY) / 10;
	}

}
