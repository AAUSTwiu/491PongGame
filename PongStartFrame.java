package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PongStartFrame extends JFrame implements ActionListener{
	JLabel welcome, credits;
	JButton play, settings, store, howToPlay;
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
	  Color c = new Color(122,235,191);
			welcome = new JLabel("Welcome to Pong!");
		    panel1.add(welcome);
		    welcome.setFont(new Font("Times New Roman", Font.BOLD, 75));
		    welcome.setForeground(c);
		    welcome.setBounds(200,25,600,80);
		    welcome.setVisible(true);
		    
		    credits= new JLabel("Created by Alex, Lily, & Brodie");
		    panel1.add(credits);
		    credits.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    credits.setBounds(325,100,400,40);
		    credits.setVisible(true);
		    	
		    
		    play = new JButton("PLAY");
		    panel1.add(play);
		    play.addActionListener(this);
		    play.setBounds(380,380,150,65);
		    play.setVisible(true);
		    
		    settings = new JButton("Settings");
		    panel1.add(settings);
		    settings.addActionListener(this);
		    settings.setBounds(30,25,100,30);
		    settings.setVisible(true);
		    
		    store = new JButton("Store");
		    panel1.add(store);
		    store.addActionListener(this);
		    store.setBounds(130,450,100,30);
		    store.setVisible(true);
		    
		    howToPlay = new JButton("How To Play");
		    panel1.add(howToPlay);
		    howToPlay.addActionListener(this);
		    howToPlay.setBounds(20,450,120,30);
		    howToPlay.setVisible(true);
	    
	    
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PLAY")) {
			PongGameFrame frame = new PongGameFrame();

		}
		if(e.getActionCommand().equals("Store")) {
			PongStoreFrame frame = new PongStoreFrame();

		}
		
		if(e.getActionCommand().equals("Settings")) {
			PongSettingsFrame frame = new PongSettingsFrame();

		}
	
	}
}