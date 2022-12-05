package pongPackage;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

class PongGameFrame extends JFrame{
	PongGamePanel panel;
	PongGameFrame(int m){
	  	panel = new PongGamePanel(m);
	  	this.add(panel);
	  	this.setResizable(false);
	  	this.setBackground(Color.GRAY);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setVisible(true);
	  	this.setLocationRelativeTo(null);
	  	

	
	}
	PongGameFrame(int m, UserList users, String p1, String p2, int ws){
	  	panel = new PongGamePanel(m, users, p1, p2, ws);
	  	this.add(panel);
	  	this.setResizable(false);
	  	this.setBackground(Color.GRAY);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setVisible(true);
	  	this.setLocationRelativeTo(null);
	  	

	
	}
}