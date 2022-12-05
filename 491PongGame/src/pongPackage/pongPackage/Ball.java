package pongPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

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
		this.ballId = id;
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
		Color color1= new Color(92,7,219);
		Color color2 = new Color(222,134,126);
		if(ballId==0) {
			g.setColor(color2);
			g.fillOval(x,y,width,height);
		}
		if(ballId==1) {
			g.setColor(Color.green);
			g.fillOval(x,y,width,height);
		}
		if(ballId==2) {
			g.setColor(color1);
			g.fillOval(x,y,width,height);
		}
		if(ballId==3) {
			g.setColor(Color.red);
			g.fillOval(x,y,width,height);
		}
		if(ballId==4) {
			g.setColor(Color.orange);
			g.fillOval(x,y,width,height);
		}
		if(ballId==5) {
			g.setColor(Color.pink);
			g.fillOval(x,y,width,height);
		}
		if(ballId==6) {
			g.setColor(Color.CYAN);
			g.fillOval(x,y,width,height);
		}
		if(ballId==7) {
			g.setColor(Color.red);
			g.drawRect(0, 0, 998, 498);
		}
		if(ballId==10) {
			g.setColor(Color.black);
			g.drawRect(x, y, width, height);
		}
	  
	}
	public void setXDirection(int xDir) {
		xVeloc = xDir;
	}
	public void setYDirection(int yDir) {
		yVeloc = yDir;
	}
	public int getXVeloc() {
		return xVeloc;
	}
	public int getYVeloc() {
		return yVeloc;
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