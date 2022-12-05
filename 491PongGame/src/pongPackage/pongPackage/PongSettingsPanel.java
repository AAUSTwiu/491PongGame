package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PongSettingsPanel extends JPanel{
	//I'm currently not the biggest fan of the size of the field, but I think it is ok atm, definitely something to change tho
	static final int FIELD_WIDTH = 1000;
	static final int FIELD_HEIGHT = 500;
	static final Dimension GAME_SIZE = new Dimension(FIELD_WIDTH,FIELD_HEIGHT);
	static final int BALL_SIZE = 20;
	static final int PADDLE_WIDTH = 100;
	static final int PADDLE_HEIGHT = 20;
	static final int POWER_UP_HEIGHT=17;
	static final int POWER_UP_WIDTH=17;
	Store store;
	Thread gameT;
	Image image;
	Graphics graphics;
	Paddle paddle1;
	Paddle paddle2;
	Paddle paddle3;
	Paddle paddle4;
	Paddle paddle5;
	Paddle paddle6;
	Paddle paddle7;
	Ball ball1;
	Settings settings;
	int gameScreen = 0;

	//the speed that the ball increases with each hit

	PongSettingsPanel(){
		newPaddles();
		this.setFocusable(true);
		this.setPreferredSize(GAME_SIZE);
		settings = new Settings(FIELD_WIDTH,FIELD_HEIGHT,0);
		
		
	}
	
	public void newPaddles() {
		paddle1 = new Paddle(220,133,20,20,10);
		paddle2 = new Paddle(220,166,20,20,10);
		paddle3 = new Paddle(230,255,20,20,10);
		paddle4 = new Paddle(230,288,20,20,10);
		paddle5 = new Paddle(260,325,15,15,10);
		paddle6 = new Paddle(260,355,15,15,10);
		
	}

	public void paintComponent(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);

	}

	public void draw(Graphics g) {
		paddle1.createPaddle(g);
		paddle2.createPaddle(g);
		paddle3.createPaddle(g);
		paddle4.createPaddle(g);
		paddle5.createPaddle(g);
		paddle6.createPaddle(g);
		settings.draw(g);
	
	}


	
}