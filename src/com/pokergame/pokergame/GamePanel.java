package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;
	Boolean inGame;
	
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

}
