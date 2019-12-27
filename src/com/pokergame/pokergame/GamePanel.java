package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class GamePanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	MainFrame mainFrame;
	Boolean inGame;
	private Boolean isLoading=false;
	private static final int MY_HAND = 5;
	Button startButton;
	Button finishButton;
	Button changeCardButton;
	DealingCardThread dealingCardThread;
	JLabel[] cardLabels = new JLabel[5];
	ImageSeceltor imageSeceltor;
	Player player;
	Deck deck;
	GamePanel gamePanel = this;
	String yaku=null;
	Boolean[] changeIndex;
	Clip clip;
	boolean first = false;
	private String mainPicPath = "../public/b32051efcf10e0b8bb5066d5da63befc_m.jpg";
	private String musicPath = "../public/HappyStation1.wav";
	private String iconPath = "../public/CardImage/gif/z02.gif";
	
	public GamePanel(MainFrame mainFrame, String name, Boolean inGame) {
		this.mainFrame = mainFrame;
		this.inGame = inGame;
		this.setName(name);
		setLayout(null);
		MusicClip musicClip = new MusicClip(new File(musicPath));
		clip = musicClip.createClip();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		if(inGame) {
			finishButton = new StartButton("FINISH",500, 0, !inGame, mainFrame,clip);
			add(finishButton);
			
			startButton = new PokerButton("START!!",500, 100, this);
			add(startButton);
			
			changeCardButton = new ChangeCardButton(500, 100, this);
			add(changeCardButton);
			changeCardButton.setVisible(false);
		} else {
			finishButton = new StartButton("CONTINUE?",500, 100, !inGame, mainFrame,clip);
			add(finishButton);
			
			Button exitButton = new ExitButton("EXIT",500, 0,clip);
			add(exitButton);
		}
		paintCardImage(850, 50);
		addMouseListener(this);
	}
	
	public void paintCardImage(ArrayList<Card> myHand) {
		if(inGame) { 
			for(int i=0; i<cardLabels.length; i++) {
				imageSeceltor = new ImageSeceltor(myHand.get(i));
				ImageIcon imageIcon = new ImageIcon(imageSeceltor.getImageIcon());
				cardLabels[i] = new JLabel(); 
				cardLabels[i].setName("cardLabel" + i);
				cardLabels[i].setIcon(imageIcon);
			}
			dealingCardThread = new DealingCardThread(this,cardLabels);
			isLoading = true;
			dealingCardThread.start();
			remove(startButton);
			repaint();
		}
	}
	
	public void paintCardImage(int x, int y) {
		if(inGame) { 
			JLabel jLabel = new JLabel();
			jLabel.setName("Deck");
			ImageIcon imageIcon = new ImageIcon(iconPath);
			jLabel.setIcon(imageIcon);
			jLabel.setBounds(x, y, 200, 300);
			add(jLabel);
		}
	}
	
	public void init_poker() {
		player = new Player();
		deck = new Deck();
		for(int i=0; i<MY_HAND; i++)
			player.draw(deck, i);
			
		paintCardImage(player.getMyHand());
	}
	
	public void change_card() {
		int index=0;
		yaku = null;
		changeIndex = new Boolean[6];
		Component[] components = getComponents();
		for(int i=0; i<components.length; i++) {
			if(components[i].getClass().equals(JLabel.class)) {
				if(components[i].getName().equals("Deck")) {
					index = i;
				} else {
					if(!player.getHandCard(i-index-1).isOpen) {
						remove(cardLabels[i-index-1]);
						player.change(deck,i-index-1,player.deckCounter);
						changeIndex[i-index-1]=true;
					} else {
						changeIndex[i-index-1] = false;
					}
				}
			} 
		}
		repaint();
		
		JLabel[] addCardLabels = new JLabel[5];
		for(int i=0; i<5; i++) {
			if(changeIndex[i]) { 
				imageSeceltor = new ImageSeceltor(player.getHandCard(i));
				ImageIcon imageIcon = new ImageIcon(imageSeceltor.getImageIcon());
				addCardLabels[i] = new JLabel();
				addCardLabels[i].setName("CardLabel"+i); 
				addCardLabels[i].setIcon(imageIcon);
			}
		}
		dealingCardThread = new DealingCardThread(gamePanel, addCardLabels,changeIndex);
		isLoading = true;
		dealingCardThread.start();
		remove(changeCardButton);
		first = false;
	}
	
	public static Clip createClip(File path) {
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)) {
			AudioFormat audioFormat = ais.getFormat();
			DataLine.Info dataLine = new DataLine.Info(Clip.class, audioFormat);
			Clip clip = (Clip)AudioSystem.getLine(dataLine); 
			clip.open(ais);
			return clip;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setIsLoading(Boolean isLoading) {
		this.isLoading = isLoading;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D graphics2d = (Graphics2D) g;
		
		try {
			image = ImageIO.read(new File(mainPicPath));
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
		
		if(yaku!=null) {
			g.setColor(Color.RED);
			Font font = new Font("Sazanami Gothic", Font.PLAIN, 50);
			g.setFont(font);
			g.drawString(yaku, 450, 350);
			changeCardButton.setVisible(true);
		}
		
		if(player!=null) {
			for(int i=0; i<5; i++) {
				if(!player.getHandCard(i).isOpen) {
					g.setColor(Color.RED);
					Ellipse2D ellipse = new Ellipse2D.Double(125+200*i, 400, 40, 40);
					graphics2d.fill(ellipse);
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(y>450 && y<750 && !isLoading) {
			for(int i=0; i<player.getMyHand().size(); i++) {
				if(x>(50+i*200) && x<(50+200*(i+1))) {
					player.getHandCard(i).setIsOpen(!player.getHandCard(i).isOpen);
				} 
			}
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}