package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
		Button startButton = new StartButton("START",500,500,true, mainFrame);
		add(startButton);
		
		Button exitButton = new ExitButton("EXIT",500,550);
		add(exitButton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Poker Game", 150, 200);
	}

}
