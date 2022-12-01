package pongPackage;
	
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class SinglePlayerStartFrame extends JFrame implements ActionListener {
	JLabel singlePlayerL, playerIDL, gameModeL;
	JButton back, start;
	JTextField player, timeScore;
	JComboBox<String> gameMode;
	SinglePlayerStartPanel spMenu;
	SinglePlayerStartFrame(){
		spMenu = new SinglePlayerStartPanel();
		this.add(spMenu);
		
		this.setResizable(false);
	  	this.setBackground(Color.gray);
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	  	
	  	singlePlayerL = new JLabel("SinglePlayer");
	  	spMenu.add(singlePlayerL);
	  	singlePlayerL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	    singlePlayerL.setBounds(350,25,500,75);
	    singlePlayerL.setVisible(true);
	    
	    playerIDL = new JLabel("Player ID:");
	  	spMenu.add(playerIDL);
	  	playerIDL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	    playerIDL.setBounds(100,150,500,75);
	    playerIDL.setVisible(true);
	    
	    gameModeL = new JLabel("Game Mode:");
	  	spMenu.add(gameModeL);
	  	gameModeL.setFont(new Font("Times New Roman", Font.BOLD, 57));
	    gameModeL.setBounds(100,300,500,75);
	    gameModeL.setVisible(true);
	    
	    player = new JTextField();
	    spMenu.add(player);
	    player.setBounds(500,160,200,50);
	    player.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	    timeScore = new JTextField();
	    spMenu.add(timeScore);
	    timeScore.setBounds(800,310,100,50);
	    timeScore.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	    String[] gm = {"Score (default 5)", "Timed in Minutes (default 2)"};
	    gameMode = new JComboBox<>();
	    spMenu.add(gameMode);
	    gameMode.setModel(new DefaultComboBoxModel<>(gm));
	    gameMode.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    gameMode.setBounds(440, 310, 350, 50);
	    gameMode.setVisible(true);
	    
	    back = new JButton ("<-- back");
	    spMenu.add(back);
	    back.addActionListener(this);
	    back.setBounds(30,10,100,30);
	    back.setVisible(true);
	    
	    start = new JButton ("Start");
	    spMenu.add(start);
	    start.addActionListener(this);
	    start.setBounds(850,450,100,30);
	    start.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// will take data from timeScore, player, and gameMode to determine rules
		//will also add the new user, if they are new, to the userList
		
		if(e.getActionCommand().equals("<-- back")) {
			PongStartFrame frame = new PongStartFrame();
			this.dispose();
		}
	}
}
