package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PongStorePanel extends JPanel{
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
	Ball ball2;
	Ball ball3;
	Ball ball4;
	Ball ball5;
	Ball ball6;
	int gameScreen = 0;


	


	//the speed that the ball increases with each hit
	static int boost = 1;
	


	
	PongStorePanel(){
		newPaddles();
		newBalls();
		this.setFocusable(true);
		this.setPreferredSize(GAME_SIZE);
		store = new Store(FIELD_WIDTH,FIELD_HEIGHT,0);
		
		
	}
	public void newBalls() {
		ball1 = new Ball(630,150,30,30,3);
		ball2 = new Ball(630,270,30,30,4);
		ball3 = new Ball(730,150,30,30,5);
		ball4 = new Ball(730,270,30,30,1);
		ball5 = new Ball(830,150,30,30,6);
		ball6 = new Ball(830,270,30,30,2);
	}
	
	public void newPaddles() {
		paddle1 = new Paddle(120, 150,PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(290,150,PADDLE_WIDTH,PADDLE_HEIGHT,2);
		paddle3 = new Paddle(120,270,PADDLE_WIDTH,PADDLE_HEIGHT,3);
		paddle4 = new Paddle(290,270,PADDLE_WIDTH,PADDLE_HEIGHT,4);
		paddle5 = new Paddle(460,150,PADDLE_WIDTH,PADDLE_HEIGHT,5);
		paddle6 = new Paddle(460,270,PADDLE_WIDTH,PADDLE_HEIGHT,6);
		paddle7 = new Paddle(460,270,PADDLE_WIDTH,PADDLE_HEIGHT,7);
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
		paddle7.createPaddle(g);
		ball1.createBall(g);
		ball2.createBall(g);
		ball3.createBall(g);
		ball4.createBall(g);
		ball5.createBall(g);
		ball6.createBall(g);
		store.draw(g);
	
	}


	
}
