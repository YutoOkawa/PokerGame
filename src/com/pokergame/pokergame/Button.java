package com.pokergame.pokergame;

import javax.swing.JButton;

public abstract class Button extends JButton {

	MainFrame mainFrame;
	Boolean inGame;
	String text;
	
	public Button(String text,int x, int y) {
		super(text);
		this.setBounds(x, y, 100, 25);
	}
	
	public abstract void setActionListener();
}
