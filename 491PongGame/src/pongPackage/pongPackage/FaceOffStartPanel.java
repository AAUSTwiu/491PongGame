package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FaceOffStartPanel extends JPanel{
	static final int FIELD_WIDTH = 1000;
	static final int FIELD_HEIGHT = 500;
	static final Dimension GAME_SIZE = new Dimension(FIELD_WIDTH,FIELD_HEIGHT);
	Image image;
	Graphics graphics;
	JLabel welcome;
	SinglePlayerStartPanel psp;
	FaceOffStartPanel(){
		this.setFocusable(true);
		this.setPreferredSize(GAME_SIZE);
		this.setLayout(null);
	}
	public void draw(Graphics g) {
		
	}
	
	public void paintComponent(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);

	}

	
}