package pongPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

import pongPackage.Score;
import pongPackage.UserList;
import pongPackage.WinscreenFrame;
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
		UserList users = new UserList();
		String player1 = "Player 1", player2 = "Player 2";
		int winScore = 5;
		
		//Settings
		int mode; //0 for Face-Off, 1 for SinglePlayer


		//the speed that the ball increases with each hit
		static int boost = 1;
	


	//Constructor, requires integer value for game mode. 0 for FO, 1 for SP.
	PongGamePanel(int m){
		mode = m;
		newPaddles();
		newBall();
		newRedPowerUP();
		newPinkPowerUP();
		newMagentaPowerUP();
		secondBall();
		score = new Score(FIELD_WIDTH,FIELD_HEIGHT,0);
		this.setFocusable(true);
		this.addKeyListener(new ActionL());
		this.setPreferredSize(GAME_SIZE);
		gameT = new Thread(this);
		gameT.start();
	}
	
	PongGamePanel(int m, UserList ul, String p1, String p2, int ws){
		newPaddles();
		newBall();
		newRedPowerUP();
		newPinkPowerUP();
		newMagentaPowerUP();
		secondBall();
		score = new Score(FIELD_WIDTH,FIELD_HEIGHT,0);
		this.setFocusable(true);
		this.addKeyListener(new ActionL());
		this.setPreferredSize(GAME_SIZE);
		gameT = new Thread(this);
		gameT.start();
		mode = m;
		users = ul;
		player1 = p1;
		player2 = p2;
		winScore = ws;
		
		
	}
	
	//Power Ups
	public void newRedPowerUP() {
		rand = new Random();
		//decreases other players paddle size
		redPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,1);
	}

	public void newPinkPowerUP() {
		pinkPowerUp = new PowerUp(0,0,0,0,2);
	}
	
	public void newMagentaPowerUP() {
		magentaPowerUp = new PowerUp(0,0,0,0,0);
	}
	
	
	//pinkPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,2);
	//magentaPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,3);
	
	public void newBall() {
		rand = new Random();
		ball = new Ball((FIELD_WIDTH/2)-(BALL_SIZE/2),rand.nextInt(FIELD_HEIGHT-BALL_SIZE),BALL_SIZE,BALL_SIZE,0);
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

	public void player1Win() {
		player1Win = new Score(0,0,0);
	}
	
	public void player2Win() {
		player2Win = new Score(0,0,0);
	}
	
	
	
	//Graphics
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
	
	
	//Move Methods, dependent on game mode. 
	public void move() { 	//Temporary while changing rest of class, but is the same as Face-off mode.
		paddle1.move();
		paddle2.move();
		ball.move();
		secondBall.move();
	}
	//Face-off movement
	public void moveFO() { 
		paddle1.move();
		paddle2.move();
		ball.move();
		secondBall.move();
	}
	//SinglePlayer movement
	public void moveSP() { 
		paddle1.move();
		//Paddle 2 movement dependent on AI.
		ball.move();
		secondBall.move();
	}

	//AI player movement
	public void moveAIPaddle() {
		if (ball.getXVeloc() > 0 && ball.getX() >= 890 && ball.getX() <= 900) {
			 paddle2.setLocation(980, getRandomLocation() - 50);
		}
	}
	
		//Assists AI Player movement
		public int getRandomLocation() {
			int min = (int)ball.getY() - 100;
			int max = (int)ball.getY() + 100;
			int loc = min + (int)(Math.random() * ((max - min) + 1));
			if(ball.getYVeloc() > 0) {
				loc = loc + 50;
			}
			else loc = loc - 50;
			return loc;
		}
	
	
	
	
	
	
	
	
	
	
	//Collision detection
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
				redPowerUp = new PowerUp(0,0,0,0,0);
				pinkPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,2);
			}
		}
		//Checks to see if right paddle hit redPowerUp (Red Power up shrinks other players paddle)
		if(ball.ballId==2) {
			if(ball.intersects(redPowerUp)){
				paddle1.height = paddle1.height -6;
				redPowerUp = new PowerUp(0,0,0,0,0);
				magentaPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,3);
			}
		}
	
		//Checks to see if left paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==1) {
			if(ball.intersects(pinkPowerUp)){
				paddle1.height = paddle1.height +6 ;
				pinkPowerUp = new PowerUp(0,0,0,0,0);
				redPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,1);
			}
		}
		//Checks to see if right paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==2) {
			if(ball.intersects(pinkPowerUp)){
				pinkPowerUp = new PowerUp(0,0,0,0,0);
				magentaPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,3);
			}
		}
		//Checks to see if left paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==1) {
			if(ball.intersects(magentaPowerUp)){
				paddle1.height = paddle1.height +6 ;
				magentaPowerUp = new PowerUp(0,0,0,0,0);
				redPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,1);
			}
		}
				//Checks to see if right paddle hit pinkPowerUp (Pink Power up increases YOUR paddle)
		if(ball.ballId==2) {
			if(ball.intersects(magentaPowerUp)){
				magentaPowerUp = new PowerUp(0,0,0,0,0);
				pinkPowerUp = new PowerUp(rand.nextInt(FIELD_WIDTH-POWER_UP_WIDTH),rand.nextInt(FIELD_HEIGHT-POWER_UP_HEIGHT),POWER_UP_WIDTH,POWER_UP_HEIGHT,2);
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
			newRedPowerUP();
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
			newRedPowerUP();
		}
		if(secondBall.ballId==3&&secondBall.x>=FIELD_WIDTH-BALL_SIZE) {
			score.player1++;
			//this makes it so the ball isn't detected anymore. It will only be detected again if magenta is hit again
			secondBall.ballId=1;
		}
	}
	public void end() {
		if(score.player1 == winScore) {
			WinscreenFrame winner = new WinscreenFrame(player1, mode, player1, player2, winScore, users);
			stop();
		}
		if(score.player2 == winScore) {
			WinscreenFrame winner = new WinscreenFrame(player2, mode, player1, player2, winScore, users);
			stop();
		}
	}
	
	//Ends game
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
		
		
	//Runs game
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
				if(mode == 0) {
					moveFO();
				}
				if(mode == 1) {
					moveSP();
					moveAIPaddle();
				}
				checkColl();
				ball.maxSpeed();
				repaint();
				end();
				delta--;
		}
	}
}
	
	
}
