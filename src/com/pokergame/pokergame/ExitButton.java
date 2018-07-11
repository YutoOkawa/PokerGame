package com.pokergame.pokergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends Button{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExitButton(String text,int x, int y) {
		super(text,x,y);
		setActionListener();
	}

	@Override
	public void setActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}

}
