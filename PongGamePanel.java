package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

import pongPackage.PongGamePanel.ActionL;

public class PongGamePanel extends JPanel implements Runnable{
	//I'm currently not the biggest fan of the size of the field, but I think it is ok atm, definitely something to change tho
	static final int FIELD_WIDTH = 1000;
	static final int FIELD_HEIGHT = 500;
	static final Dimension GAME_SIZE = new Dimension(FIELD_WIDTH,FIELD_HEIGHT);
	static final int BALL_SIZE = 20;
	static final int PADDLE_WIDTH = 20;
	static final int PADDLE_HEIGHT = 100;
	static final int POWER_UP_HEIGHT=17;
	static final int POWER_UP_WIDTH=17;
	Thread gameT;
	Image image;
	Graphics graphics;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	Score player1Win;
	Score player2Win;
	Random rand;
	PowerUp redPowerUp;
	PowerUp pinkPowerUp;
	PowerUp magentaPowerUp;
	Ball secondBall;
	int gameScreen = 0;


	


	//the speed that the ball increases with each hit
	static int boost = 1;
	


	
	PongGamePanel(){
		newPaddles();
		newBall();
		newPowerUP();
		secondBall();
		score = new Score(FIELD_WIDTH,FIELD_HEIGHT,0);
		this.setFocusable(true);
		this.addKeyListener(new ActionL());
		this.setPreferredSize(GAME_SIZE);
		gameT = new Thread(this);
		gameT.start();
	}
	public void newPowerUP() {

		rand = new Random();
		//decreases other players paddle size
		redPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,1);
		//increases your paddle size
		pinkPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,2);
		//spawns another ball
		magentaPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,3);
}

	public void newBall() {
		rand = new Random();
		ball = new Ball((FIELD_WIDTH/2)-(BALL_SIZE/2),rand.nextInt(FIELD_HEIGHT-BALL_SIZE),BALL_SIZE,BALL_SIZE,0);


	}
	
	public void player1Win() {
		player1Win = new Score(0,0,0);
	}
	
	public void player2Win() {
		player2Win = new Score(0,0,0);
	}
	
	public void secondBall() {
		rand = new Random();
		//spawns second ball at start but you can't see it until first ball hits magenta
		secondBall = new Ball(0,0,0,0,0);
		
	}
	
	public void newPaddles() {
		paddle1 = new Paddle(0,(FIELD_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(FIELD_WIDTH-PADDLE_WIDTH,(FIELD_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
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
		ball.createBall(g);
		secondBall.createBall(g);
		score.draw(g);
		redPowerUp.createPowerUp(g);
		pinkPowerUp.createPowerUp(g);
		magentaPowerUp.createPowerUp(g);
	}
	
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
		secondBall.move();
		
	
	}
	

	
	public void checkColl() {
	
		//Creates Id for paddle 1, creating a way to distinguish who hit the powerUp
		if(ball.intersects(paddle1)){
	       ball.ballId = 1;
			}
		//Creates Id for paddle 2, creating way to distinguish who hit the powerUp
		if(ball.intersects(paddle2)) {
			ball.ballId = 2;
		}
		//Checks to see if left paddle hit redPowerUp (Red Power up shrinks other players paddle)
		if(ball.ballId==1) {
			if(ball.intersects(redPowerUp)){
				paddle2.height = paddle2.height -6;
				newPowerUP();
			}
		}
		//Checks to see if right paddle hit redPowerUp (Red Power up shrinks other players paddle)
		if(ball.ballId==2) {
			if(ball.intersects(redPowerUp)){
				paddle1.height = paddle1.height -6;
				newPowerUP();
			}
		}
	
		//Checks to see if left paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==1) {
			if(ball.intersects(pinkPowerUp)){
				paddle1.height = paddle1.height +6 ;
				newPowerUP();
			}
		}
		//Checks to see if right paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==2) {
			if(ball.intersects(pinkPowerUp)){
				paddle2.height = paddle2.height +6;
				newPowerUP();
			}
		}
		//Spawns second ball if ball 1 hits magenta power up
		if(ball.ballId==1||ball.ballId==2) {
		if(ball.intersects(magentaPowerUp)) {
			secondBall = new Ball((FIELD_WIDTH/2)-(BALL_SIZE/2),rand.nextInt(FIELD_HEIGHT-BALL_SIZE),BALL_SIZE,BALL_SIZE,1);
			secondBall.ballId=3;
			newPowerUP();
		}
	}
		//roof collision
		if (ball.y <= 0) {
			ball.setYDirection(-ball.yVeloc);
		}
		if(secondBall.y <= 0) {
			secondBall.setYDirection(-secondBall.yVeloc);
		}
		//floor collision
		if(ball.y >= FIELD_HEIGHT-BALL_SIZE) {
			ball.setYDirection(-ball.yVeloc);
		}
		if(secondBall.y >= FIELD_HEIGHT-BALL_SIZE) {
			secondBall.setYDirection(-secondBall.yVeloc);
		}
		//either paddle collision and speeds the ball up by
		if(ball.intersects(paddle1)) {
			ball.xVeloc = -ball.xVeloc + boost;
		}
		if(secondBall.intersects(paddle1)) {
			secondBall.xVeloc = -secondBall.xVeloc + boost;
		}
		if(ball.intersects(paddle2)) {
			ball.xVeloc = -ball.xVeloc - boost;
		}
		if(secondBall.intersects(paddle2)) {
			secondBall.xVeloc = -secondBall.xVeloc - boost;
		}
		//makes the paddles not leave the screen
		if(paddle1.y <= 0) {
			paddle1.y = 0;
		}
		if(paddle1.y >= (FIELD_HEIGHT-PADDLE_HEIGHT)) {
			paddle1.y = FIELD_HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle2.y <= 0) {
			paddle2.y = 0;
		}
		if(paddle2.y >= (FIELD_HEIGHT-PADDLE_HEIGHT)) {
			paddle2.y = FIELD_HEIGHT-PADDLE_HEIGHT;
		}
		//checks for score
		if(score.player1==10) {
			stop();
			
			
		}
		if(score.player2==10) {
			stop();
			
			
		}
		if(ball.x<=0) {
			score.player2++;
			newPaddles();
			newBall();
			newPowerUP();
		}
		if(secondBall.ballId==3&&secondBall.x<=0) {
			score.player2++;
			//this makes it so the ball isn't detected anymore. It will only be detected again if magenta is hit again
			secondBall.ballId=1;
		}
		if(ball.x>=FIELD_WIDTH-BALL_SIZE) {
			score.player1++;
			newPaddles();
			newBall();
			newPowerUP();
		}
		if(secondBall.ballId==3&&secondBall.x>=FIELD_WIDTH-BALL_SIZE) {
			score.player1++;
			//this makes it so the ball isn't detected anymore. It will only be detected again if magenta is hit again
			secondBall.ballId=1;
		}
	}
	
		public void stop() {
			long lastTime = System.nanoTime();
			double delta = 0;
			while(true) {
				long now = System.nanoTime();
				delta += (lastTime - now);
				
			}
		}
		
		
		public class ActionL extends KeyAdapter{
			public void keyPressed(KeyEvent e) {
				paddle1.keyPress(e);
				paddle2.keyPress(e);
			}
			public void keyReleased(KeyEvent e) {
				paddle1.keyRelease(e);
				paddle2.keyRelease(e);
			}
		}
		
		public void run() {
			//I got this from stackExchage. It is supposed to be the game loop that MC uses. Idk how to do game loops so this was best I
			// could do. This may be the weakest part, not sure. Here's a link to the post tho.
			//https://gamedev.stackexchange.com/questions/52841/the-most-efficient-and-accurate-game-loop
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			while(true) {
				long now = System.nanoTime();
				delta += (now - lastTime)/ns;
				lastTime = now;
				if(delta >= 1) {
					move();
					checkColl();
					ball.maxSpeed();
					repaint();
					delta--;
			}
		}
	}
	
	
}
