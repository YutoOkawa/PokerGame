package com.pokergame.pokergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StartButton(String text,int x, int y,Boolean inGame,MainFrame mainFrame) {
		super(text,x,y);
		this.mainFrame = mainFrame;
		this.inGame = inGame;
		setActionListener();
	}

	@Override
	public void setActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				mainFrame.changePanel(new GamePanel(mainFrame,text,inGame));
			}
		});
	}
}
