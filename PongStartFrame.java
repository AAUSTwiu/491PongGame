package pongPackage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;

public class PongStartFrame extends JFrame implements ActionListener{
	JLabel welcome, credits;
	JButton splay, mplay, settings, shop;
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
		    
		    credits= new JLabel("Created by Alex, Brodie, & Lily");
		    panel1.add(credits);
		    credits.setFont(new Font("Times New Roman", Font.BOLD, 24));
		    credits.setBounds(315,100,400,40);
		    credits.setVisible(true);
		    	
		    
		    splay = new JButton("Single-Player");
		    panel1.add(splay);
		    splay.addActionListener(this);
		    splay.setBounds(400,200,150,45);
		    splay.setVisible(true);
		    
		    mplay = new JButton("Face-Off");
		    panel1.add(mplay);
		    mplay.addActionListener(this);
		    mplay.setBounds(425,275,100,45);
		    mplay.setVisible(true);
		    
		    settings = new JButton("Settings");
		    panel1.add(settings);
		    settings.addActionListener(this);
		    settings.setBounds(30,450,100,30);
		    settings.setVisible(true);
		    
		    shop = new JButton("Shop");
		    panel1.add(shop);
		    shop.addActionListener(this);
		    shop.setBounds(165,450,100,30);
		    shop.setVisible(true);
	    
	    
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Single-Player")) {
			PongGameFrame frame = new PongGameFrame();
		}
		if(e.getActionCommand().equals("Face-Off")) {
			
		}
		if(e.getActionCommand().equals("Settings")) {
			
		}
		if(e.getActionCommand().equals("Shop")) {
			
		}
	
	}
}
