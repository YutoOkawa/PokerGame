package com.pokergame.pokergame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public GamePanel(MainFrame mainFrame, String name, Boolean inGame) {
		this.mainFrame = mainFrame;
		this.inGame = inGame;
		this.setName(name);
		setLayout(null);
		
		if(inGame) {
			finishButton = new StartButton("FINISH",500, 0, !inGame, mainFrame);
			add(finishButton);
			
			
			startButton = new PokerButton("START!!",500, 100, this);
			add(startButton);
			
			changeCardButton = new ChangeCardButton(500, 200, this);
			add(changeCardButton);
		} else {
			finishButton = new StartButton("CONTINUE?",500, 0, !inGame, mainFrame);
			add(finishButton);
			
			Button exitButton = new ExitButton("EXIT",500, 100);
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
			ImageIcon imageIcon = new ImageIcon("/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/z02.gif");
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
	}
	
	public void setIsLoading(Boolean isLoading) {
		this.isLoading = isLoading;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!inGame) {
			g.setColor(Color.BLUE);
			g.drawString("END", 500, 400);
		}
		
		if(yaku!=null) {
			g.setColor(Color.RED);
			Font font = new Font("SanSerif", Font.ITALIC, 30);
			g.setFont(font);
			g.drawString(yaku, 500, 350);
		}
		
		if(player!=null) {
			for(int i=0; i<5; i++) {
				if(!player.getHandCard(i).isOpen) {
					g.setColor(Color.BLACK);
					g.drawString("選択中", 100+i*200, 400);
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