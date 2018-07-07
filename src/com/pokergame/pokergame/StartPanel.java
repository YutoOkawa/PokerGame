package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;
	Font font;
	
	public StartPanel(MainFrame mainFrame, String name) {
		this.mainFrame = mainFrame;
		this.setName(name);
		setLayout(null);
		font = new Font("SonSerif", Font.ITALIC, 100);
		JButton  startButton = new JButton("START!!!");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自動生成されたメソッド・スタブ
				mainFrame.changePanel(new GamePanel(mainFrame, name,true));
			}
		});
		startButton.setBounds(500, 500, 100, 25);
		this.add(startButton);
		
		JButton finishButton = new JButton("EXIT");
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自動生成されたメソッド・スタブ
				System.exit(0);
			}
		});
		finishButton.setBounds(500,550,100,25);
		this.add(finishButton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Poker Game", 150, 200);
	}

}
