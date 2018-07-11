package com.pokergame.pokergame;


import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	StartPanel startPanel;
	public String[] PanelNames = {"start", "game"};
	
	public MainFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1100, 800);
		setLocationRelativeTo(null);
		startPanel = new StartPanel(this, PanelNames[0]);
		add(startPanel);
	}
	
	public void changePanel(JPanel jPanel) {
		getContentPane().removeAll();
		add(jPanel);
		validate();
		repaint();
	}
	
}
