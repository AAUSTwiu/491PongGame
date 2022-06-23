import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;


public class pong {

	public static void main(String[] args){

		PongStartFrame sFrame = new PongStartFrame();
	}
}

///////////////////////////////////////////////
class PongStartFrame extends JFrame implements ActionListener{
	JLabel welcome, credits;
	JButton play, settings;
PongStartPanel panel1;
	PongStartFrame(){
	  	panel1 = new PongStartPanel();
	  	this.add(panel1);
	  
	  	this.setResizable(false);
	  	this.setBackground(Color.gray);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	  
			welcome = new JLabel("Welcome to Pong!");
		    panel1.add(welcome);
		    welcome.setFont(new Font("Times New Roman", Font.BOLD, 57));
		    welcome.setBounds(250,25,500,75);
		    welcome.setVisible(true);
		    
		    credits= new JLabel("Created by Alex & Brodie");
		    panel1.add(credits);
		    credits.setFont(new Font("Times New Roman", Font.BOLD, 24));
		    credits.setBounds(315,100,400,40);
		    credits.setVisible(true);
		    	
		    
		    play = new JButton("PLAY");
		    panel1.add(play);
		    play.addActionListener(this);
		    play.setBounds(380,380,150,65);
		    play.setVisible(true);
		    
		    settings = new JButton("Settings");
		    panel1.add(settings);
		    settings.addActionListener(this);
		    settings.setBounds(30,25,100,30);
		    settings.setVisible(true);
	    
	    
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PLAY")) {
			PongGameFrame frame = new PongGameFrame();

			
		
		}
	
	}
}

class PongGameFrame extends JFrame{
	JLabel end;
	PongGamePanel panel;
	PongGameFrame(){
	  	panel = new PongGamePanel();
	  	this.add(panel);
	  	this.setResizable(false);
	  	this.setBackground(Color.GRAY);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setVisible(true);
	  	this.setLocationRelativeTo(null);
	  	

	
	}
}


////////////////////////////////////////////////
class PowerUp extends Rectangle{
	int powerUpId;
	PowerUp(int xLoc, int yLoc, int powerupWidth, int powerupHeight, int id){
		super(xLoc,yLoc,powerupWidth,powerupHeight);
		this.powerUpId=id;
	}
	public void createPowerUp(Graphics g){
		if(powerUpId==1) {
			g.setColor(Color.red);
		}
		if(powerUpId==2) {
			g.setColor(Color.PINK);
		}
		if(powerUpId==3) {
			g.setColor(Color.MAGENTA);
		}
	
			
		g.fillRect(x,y,width,height);
 }
}
//////////////////////////////////////////////
class Paddle extends Rectangle {
	int paddleID;
	int veloc;
	int speed = 10;
	
	Paddle(int xLoc, int yLoc, int paddleWidth, int paddleHeight, int paddle){
	    super(xLoc,yLoc,paddleWidth,paddleHeight);
	    this.paddleID = paddle;
	}
	//I made this into a switch statement so that it is faster than if statements, that also means that there is an ID number instead of
	//paddle name entered in with the constructor
	public void keyPress(KeyEvent e){
	    switch(paddleID) {
	    case 1:
	    	if(e.getKeyCode()==KeyEvent.VK_W) {
	    		setDirection(-speed);
	    	}
	    	if(e.getKeyCode()==KeyEvent.VK_S) {
	    		setDirection(speed);
	    	}
	    	break;
	    case 2:
	    	if(e.getKeyCode()==KeyEvent.VK_UP) {
	    		setDirection(-speed);
	    	}
	    	if(e.getKeyCode()==KeyEvent.VK_DOWN) {
	    		setDirection(speed);
	    	}
	    	break;
	    }
	}
	  
	public void keyRelease(KeyEvent e){
		switch(paddleID) {
	    case 1:
	    	if(e.getKeyCode()==KeyEvent.VK_W) {
	    		setDirection(0);
	    	}
	    	if(e.getKeyCode()==KeyEvent.VK_S) {
	    		setDirection(0);
	    	}
	    	break;
	    case 2:
	    	if(e.getKeyCode()==KeyEvent.VK_UP) {
	    		setDirection(0);
	    	}
	    	if(e.getKeyCode()==KeyEvent.VK_DOWN) {
	    		setDirection(0);
	    	}
	    	break;
	    }
	}
	public void createPaddle(Graphics g){
		if(paddleID==1)
			g.setColor(Color.orange);
	    else
	      g.setColor(Color.green);
		g.fillRect(x,y,width,height);
	}
	public void setDirection(int direction) {
		veloc = direction;
	}
	public void move() {
		y = y + veloc;
	}
}


///////////////////////////////////

class Ball extends Rectangle{
	Random rand;
	int baseSpeed = 2;
	int xVeloc;
	int yVeloc;
	int topSpeed = 20;
	int ballId;
	Ball(int x, int y, int ballWidth, int ballHeight,int id){
		//uses rectangle to make the shape
		super(x,y,ballWidth,ballHeight);
		rand = new Random();
		int randXDirection = rand.nextInt(2);
		if(randXDirection == 0) {
			randXDirection--;
		}
		setXDirection(randXDirection*baseSpeed);
		
		int randYDirection = rand.nextInt(2);
		if(randYDirection == 0) {
			randYDirection--;
		}
		setYDirection(randYDirection*baseSpeed);
	}
	public void createBall(Graphics g){
		if(ballId==0) {        //initial spawn ball
	    g.setColor(Color.cyan);
		}
	    if(ballId==1) {        //ball that has been hit by player 1
	    	g.setColor(Color.orange);
	    }
	    if(ballId==2) {        //ball that has been hit by player 2
	    	g.setColor(Color.green);
	    }
	    if(ballId==3) {			//second spawn ball
	    	g.setColor(Color.black);
	    }
	    g.fillOval(x,y,width,height);
	}
	public void setXDirection(int xDir) {
		xVeloc = xDir;
	}
	public void setYDirection(int yDir) {
		yVeloc = yDir;
	}
	public void move() {
		x += xVeloc;
		y += yVeloc;
	}
	//sets a max speed so the ball is not too fast to hit. This  could change if it is too slow/fast
	public void maxSpeed() {
		if (this.xVeloc >= topSpeed) {
			this.xVeloc =  topSpeed;
		}
	}
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

///////////////////////////////////////

class Score extends Rectangle{
	  static int FIELD_WIDTH;
	  static int FIELD_HEIGHT;
	  int player1 = 0;
	  int player2 = 0;
	  int id =0;
	  Score(int w,int h,int id){
	    this.FIELD_WIDTH = w;
	    this.FIELD_HEIGHT = h;
	    this.id = id;
	
 	  }
	  
	  public void draw(Graphics g) {
	
		  g.setColor(Color.white);
		  
			   
		

		
		  g.setFont(new Font("Dialog",Font.PLAIN,60));
			
		  g.drawLine(FIELD_WIDTH/2, 0, FIELD_WIDTH/2, FIELD_HEIGHT);
		  g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (FIELD_WIDTH/2)-85, 50);
		  g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (FIELD_WIDTH/2)+20, 50);
	
	
	  }
}


class PongStartPanel extends JPanel{
	static final int FIELD_WIDTH = 1000;
	static final int FIELD_HEIGHT = 500;
	static final Dimension GAME_SIZE = new Dimension(FIELD_WIDTH,FIELD_HEIGHT);
	Image image;
	Graphics graphics;
	JLabel welcome;
	PongStartPanel psp;
	PongStartPanel(){
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
//////////////////////////////////////////

class PongGamePanel extends JPanel implements Runnable{
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

