package com.pokergame.pokergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;


public class StartButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Clip clip;

	public StartButton(String text,int x, int y,Boolean inGame,MainFrame mainFrame,Clip clip) {
		super(text,x,y);
		this.mainFrame = mainFrame;
		this.inGame = inGame;
		setActionListener();
		this.clip = clip;
	}

	@Override
	public void setActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clip.close();
				removeAll();
				mainFrame.changePanel(new GamePanel(mainFrame,text,inGame));
			}
		});
	}
}
