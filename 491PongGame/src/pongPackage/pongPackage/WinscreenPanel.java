package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class WinscreenPanel extends JPanel{
	static final int WIDTH = 250;
	static final int HEIGHT = 250;
	static final Dimension SIZE = new Dimension(WIDTH , HEIGHT);
	String winner, player1, player2;
	Graphics graphics;
	Image image;
	int winScore;
	int mode;
	WinscreenPanel(String w, int m, String p1, String p2, int score, UserList ul){
		winner = w;
		mode = m;
		player1 = p1;
		player2 = p2;
		winScore = score;
		this.setFocusable(true);
		this.setPreferredSize(SIZE);
		this.setLayout(null);
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void paintComponent(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		}
	
	
}
