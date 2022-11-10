package pongPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
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

