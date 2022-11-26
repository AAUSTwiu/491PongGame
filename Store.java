package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Store extends Rectangle{
	  static int FIELD_WIDTH;
	  static int FIELD_HEIGHT;
	  int player1 = 0;
	  int player2 = 0;
	  int id =0;
	  Store(int w,int h,int id){
	    this.FIELD_WIDTH = w;
	    this.FIELD_HEIGHT = h;
	    this.id = id;
	
	  }
	  
	  public void draw(Graphics g) {
	
		  g.setColor(Color.black);
		  
			   
		  g.setFont(new Font("Dialog",Font.PLAIN,45));
		  g.drawString(String.valueOf("Points Shop"), 375, 100);
		  
		  
		  g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  g.drawString(String.valueOf("Player: "), 850, 30);
		  	g.setFont(new Font("Dialog",Font.PLAIN,15));
		  	g.drawString(String.valueOf("Alex"), 910, 30);
		  
		  g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  g.drawString(String.valueOf("Points: "), 850, 60);
		  	g.setFont(new Font("Times New Roman",Font.PLAIN,20));
		  	g.drawString(String.valueOf("13 coins"), 910, 60);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("10 coins"), 130,190);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("10 coins"), 300,190);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("15 coins"), 470,190);
		
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("10 coins"), 130,310);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("15 coins"), 300,310);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 470,310);
		  
		  // Coins for balls
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 617,317);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 717,317);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 817,317);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 617,197);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("5 coins"), 717,197);
		  
		  g.setFont(new Font("Dialog",Font.PLAIN,20));
		  g.drawString(String.valueOf("10 coins"), 817,197);
	
	  }
}
