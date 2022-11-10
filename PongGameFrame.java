package pongPackage;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

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