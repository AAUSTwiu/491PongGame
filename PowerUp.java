package pongPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PowerUp extends Rectangle{
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