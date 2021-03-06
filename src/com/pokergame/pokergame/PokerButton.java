package com.pokergame.pokergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokerButton extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel gamePanel;

	public PokerButton(String text,int x, int y, GamePanel gamePanel) {
		super(text, x, y);
		this.gamePanel = gamePanel;
		setActionListener();
	}

	@Override
	public void setActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gamePanel.init_poker();
			}
		});
	}

}
