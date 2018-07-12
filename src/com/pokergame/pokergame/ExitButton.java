package com.pokergame.pokergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;

public class ExitButton extends Button{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Clip clip;

	public ExitButton(String text,int x, int y,Clip clip) {
		super(text,x,y);
		setActionListener();
		this.clip = clip;
	}

	@Override
	public void setActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clip.close();
				System.exit(0);
			}
		});
		
	}

}
