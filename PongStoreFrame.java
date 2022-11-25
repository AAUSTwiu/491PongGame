package pong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PongStoreFrame extends JFrame implements ActionListener{
	JLabel welcome, credits, points;
	JButton play, settings,store;
PongStorePanel panel1;
	PongStoreFrame(){
	  	panel1 = new PongStorePanel();
	  	this.add(panel1);
	  Color color1 = new Color(228,231,236);
	  	this.setResizable(false);
	  	this.setBackground(color1);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	  
		    
		    
		    
		    	
		   
		    
		    
		    settings = new JButton("<-- back");
		    panel1.add(settings);
		    settings.addActionListener(this);
		    settings.setBounds(30,200,100,30);
		    settings.setVisible(true);
		    
		    
	    
	    
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("<-- back")) {
			PongStartFrame frame = new PongStartFrame();

			
		
		}
	
	}
}
