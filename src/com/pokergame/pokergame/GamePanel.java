package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;
	Boolean inGame;
	private static final int MY_HAND = 5;
	
	public GamePanel(MainFrame mainFrame, String name, Boolean inGame) {
		this.mainFrame = mainFrame;
		this.inGame = inGame;
		this.setName(name);
		setLayout(null);
		JButton  endButton = new JButton("END");
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自動生成されたメソッド・スタブ
				mainFrame.changePanel(new GamePanel(mainFrame, name,!inGame));
			}
		});
		endButton.setBounds(500, 0, 100, 25);
		add(endButton);
		
		if(inGame) 
			init_poker();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) {
			paintCard(g, 50,550);
			paintCard(g, 250,550);
			paintCard(g, 450,550);
			paintCard(g, 650,550);
			paintCard(g, 850,550);
			paintCard(g, 850,50);
			
			g.setColor(Color.RED);
			g.drawString("Game", 500, 400);
		} else {
			g.setColor(Color.BLUE);
			g.drawString("END", 500, 400);
		}
	}
	
	public void paintCard(Graphics g, int x, int y) {
		g.drawRect(x, y, 150, 200);
	}
	
	public void paintCardContent() {
		
	}
	
	public void init_poker() {
		Player player = new Player();
		Deck deck = new Deck();
		for(int i=0; i<MY_HAND; i++)
			player.draw(deck, i);
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
