package pongPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{
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
