package pongPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class WinscreenFrame extends JFrame implements ActionListener {
	JLabel name;
	JButton again, stop;
	WinscreenPanel panel;
	int ws;
	String player1, player2;
	UserList users;
	int mode;
	WinscreenFrame(String winner, int m, String p1, String p2, int score, UserList ul){
		panel = new WinscreenPanel(winner, m, p1, p2, score, ul);
		player1 = p1;
		player2 = p2;
		ws = score;
		mode = m;
		this.add(panel);
	  	this.setResizable(false);
	  	this.setBackground(Color.GRAY);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setVisible(true);
	  	this.setLocationRelativeTo(null);
	  	
	  		name = new JLabel(winner + " wins!");
	  		panel.add(name);
	  		name.setFont(new Font("Times New Roman", Font.BOLD, 35));
	  		name.setBounds(10,10,250,50);
	  		name.setVisible(true);
	  		
	  		again = new JButton("Play Again?");
	  		panel.add(again);
	  		again.addActionListener(this);
	  		again.setBounds(10,180,100,40);
	  		again.setVisible(true);
	  		
	  		stop = new JButton("Main Menu");
	  		panel.add(stop);
	  		stop.addActionListener(this);
	  		stop.setBounds(120,180,100,40);
	  		stop.setVisible(true);
	  	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play Again?")) {
			PongGameFrame frame = new PongGameFrame(mode, users, player1, player2, ws);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("Main Menu")) {
			StartFrame sFrame = new StartFrame();
			sFrame.setVisible(true);
			this.dispose();
		}
		
	}
}
