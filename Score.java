package pongPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle{
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
