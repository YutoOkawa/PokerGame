package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class StartPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;
	Font font;
	private BufferedImage image;
	Path mpath = Paths.get("../public/HappyCommanders 1.wav");
	Path picpath = Paths.get("../public/b667141ad6d380481237b452f6a4b6fe_m.jpg");
	private String music_path = mpath.toAbsolutePath().toString();
	private String pic_path = picpath.toAbsolutePath().toString();
	
	public StartPanel(MainFrame mainFrame, String name) {
		this.mainFrame = mainFrame;
		this.setName(name);
		setLayout(null);
		MusicClip musicClip = new MusicClip(new File(music_path));
		Clip clip = musicClip.createClip();
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font fonts[] = graphicsEnvironment.getAllFonts();
		Random random = new Random(System.currentTimeMillis());
		int randomNumber = random.nextInt(642);
		String FontName = fonts[randomNumber].getName();
		font = new Font(FontName,Font.ITALIC, 100);
		Button startButton = new StartButton("START",500,500,true, mainFrame,clip);
		add(startButton);
		
		Button exitButton = new ExitButton("EXIT",500,550,clip);
		add(exitButton);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D graphics2d = (Graphics2D) g;
		
		try {
			image = ImageIO.read(new File(pic_path));
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}
		
		double imageWidth = image.getWidth();
		double imageHeight  = image.getHeight();
		double panelWidth = this.getWidth();
		double panelHeight = this.getWidth();
		
		double sx = (panelWidth/imageWidth);
		double sy = (panelHeight/imageHeight);
		
		AffineTransform affineTransform = AffineTransform.getScaleInstance(sx, sy);
		graphics2d.drawImage(image, affineTransform, this);
		
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString("Poker", 100, 150);	
	}

}
