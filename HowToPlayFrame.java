package pongPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class HowToPlayFrame extends JFrame implements ActionListener {
	JLabel title;
	JTextArea htp;
	JButton back;
	HowToPlayPanel panel;
	
	HowToPlayFrame(){
		panel = new HowToPlayPanel();
		this.add(panel);
		
		this.setResizable(false);
	  	this.setBackground(new Color(36, 37, 130));
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	  	
	  	title = new JLabel("How to Play");
	  	panel.add(title);
	  	title.setForeground(new Color(255, 255, 255));
	  	title.setFont(new Font("Times New Roman", Font.BOLD, 57));
	  	title.setBounds(350,25,500,75);
	  	title.setVisible(true);
	  	
	  	htp = new JTextArea("*The Objective of the game is to score the ball\non your oppoents side of the board by hitting it with your own paddle.\n*Player1 uses W to move up, and S to move down\n*Player2 uses UP arrow and DOWN arrow to move.\n*Magenta power ups split the ball\n*Hitting the red power up shrinks the oppoents paddle\n*The pink power up increases your paddle's size");
	  	panel.add(htp);
	  	htp.setFont(new Font("Times New Roman", Font.BOLD, 26));
	  	htp.setBounds(75, 120, 850, 300);
	  	htp.setVisible(true);
	  	
	  	back = new JButton ("<-- back");
	    panel.add(back);
	    back.addActionListener(this);
	    back.setBounds(30,10,100,30);
	    back.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("<-- back")) {
			StartFrame frame = new StartFrame();
			frame.setVisible(true);
			this.dispose();
		}
	}
}
