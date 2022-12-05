package pongPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class FaceOffStartFrame extends JFrame implements ActionListener{
	JLabel singlePlayerL, playerIDL, gameModeL, play1L, play2L;
	JButton back, start, quickPlay;
	JTextField player1, player2, winScore;
	JComboBox<String> gameMode;
	SinglePlayerStartPanel foMenu;
	FaceOffStartFrame(){
		foMenu = new SinglePlayerStartPanel();
		this.add(foMenu);
		
		this.setResizable(false);
	  	this.setBackground(new Color(36, 37, 130));
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	  	
	  	singlePlayerL = new JLabel("Face Off");
	  	foMenu.add(singlePlayerL);
	  	singlePlayerL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	  	singlePlayerL.setForeground(new Color(255, 255, 255));
	    singlePlayerL.setBounds(350,25,500,75);
	    singlePlayerL.setVisible(true);
	    
	    playerIDL = new JLabel("Player IDs:");
	  	foMenu.add(playerIDL);
	  	playerIDL.setForeground(new Color(255, 255, 255));
	  	playerIDL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	    playerIDL.setBounds(100,150,500,75);
	    playerIDL.setVisible(true);
	    
	    play1L = new JLabel("Player 1:");
	    foMenu.add(play1L);
	    play1L.setForeground(new Color(255, 255, 255));
	  	play1L.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    play1L.setBounds(400,100,200,50);
	    play1L.setVisible(true);
	    
	    play2L = new JLabel("Player 2:");
	    foMenu.add(play2L);
	    play2L.setForeground(new Color(255, 255, 255));
	  	play2L.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    play2L.setBounds(700,100,200,50);
	    play2L.setVisible(true);
	    
	    gameModeL = new JLabel("Game Mode:");
	  	foMenu.add(gameModeL);
	  	gameModeL.setForeground(new Color(255, 255, 255));
	  	gameModeL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	    gameModeL.setBounds(100,300,500,75);
	    gameModeL.setVisible(true);
	    
	    player1 = new JTextField();
	    foMenu.add(player1);
	    player1.setBounds(400,160,200,50);
	    player1.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	    player2 = new JTextField();
	    foMenu.add(player2);
	    player2.setBounds(700,160,200,50);
	    player2.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	    winScore = new JTextField();
	    foMenu.add(winScore);
	    winScore.setBounds(800,310,100,50);
	    winScore.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	    String[] gm = {"Score (default 5)", "Timed in Minutes (default 2)"};
	    gameMode = new JComboBox<>();
	    foMenu.add(gameMode);
	    gameMode.setModel(new DefaultComboBoxModel<>(gm));
	    gameMode.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    gameMode.setBounds(440, 310, 350, 50);
	    gameMode.setVisible(true);
	    
	    back = new JButton ("<-- back");
	    foMenu.add(back);
	    back.addActionListener(this);
	    back.setBounds(30,10,100,30);
	    back.setVisible(true);
	    
	    start = new JButton ("Start");
	    foMenu.add(start);
	    start.addActionListener(this);
	    start.setBounds(850,450,100,30);
	    start.setVisible(true);
	    
	    quickPlay = new JButton ("Quick Play");
	    foMenu.add(quickPlay);
	    quickPlay.addActionListener(this);
	    quickPlay.setBounds(100,450,100,30);
	    quickPlay.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// will take data from timeScore, player, and gameMode to determine rules
		//will also add the new user, if they are new, to the userList
		
		if(e.getActionCommand().equals("<-- back")) {
			StartFrame frame = new StartFrame();
			frame.setVisible(true);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("Start")) {
			UserList users = new UserList();
			String p1 = player1.getText();
			String p2 = player2.getText();
			users.addNewUser(p1);
			users.addNewUser(p2);
			PongGameFrame game = new PongGameFrame(0,users,p1,p2,Integer.parseInt(winScore.getText()));
			this.dispose();
		}
		
		if(e.getActionCommand().equals("Quick Play")) {
			PongGameFrame qp = new PongGameFrame(0);
			this.dispose();
		}
	}
}
