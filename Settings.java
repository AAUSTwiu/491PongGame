package pongPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Settings extends Rectangle{
	  static int FIELD_WIDTH;
	  static int FIELD_HEIGHT;
	  int player1 = 0;
	  int player2 = 0;
	  int id =0;
	  Settings(int w,int h,int id){
	    this.FIELD_WIDTH = w;
	    this.FIELD_HEIGHT = h;
	    this.id = id;
	
	  }
	  
	  public void draw(Graphics g) {
	
		  g.setColor(Color.black);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,45));
		  g.drawString(String.valueOf("Settings"), 375, 100);
		  
		  
		  g.setFont(new Font("Times New Roman",Font.PLAIN,25));
		  g.drawString(String.valueOf("Player ID: "), 100, 150);
		  
		  	g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  	g.drawString(String.valueOf("create new player "), 250, 150);
		  	g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  	g.drawString(String.valueOf("select existing player "), 250, 181);
		  
		  g.setFont(new Font("Times New Roman",Font.PLAIN,25));
		  g.drawString(String.valueOf("Gamemode: "), 100, 270);
		  
		  	g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  	g.drawString(String.valueOf("timed "), 260, 270);
		  	g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  	g.drawString(String.valueOf("points "), 260, 303);
		  		g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  		g.drawString(String.valueOf("5 pts"), 285, 340);
		  		g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  		g.drawString(String.valueOf("10 pts"), 285, 369);
		  
	
	
	
	  }
}