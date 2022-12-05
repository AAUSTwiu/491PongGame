package pongPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class FaceOffStartFrame extends JFrame implements ActionListener{
	FaceOffStartPanel foMenu;
	UserList users = new UserList();
	FaceOffStartFrame(){
		foMenu = new FaceOffStartPanel();
		foMenu.setBounds(0, 0, 1000, 500);
		getContentPane().add(foMenu);
		
		this.setResizable(false);
	  	this.setBackground(new Color(36, 37, 130));
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
		setTitle("Face-Off Mode Game Setup");
		
		JLabel lblTitleFO = new JLabel("Face-Off Mode");
		lblTitleFO.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleFO.setForeground(new Color(246, 76, 114));
		lblTitleFO.setFont(new Font("Magneto", Font.PLAIN, 48));
		lblTitleFO.setBounds(250, 50, 550, 50);
		foMenu.add(lblTitleFO);
		
		JLabel lblPlayer1 = new JLabel("Player 1:");
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setForeground(new Color(246, 76, 114));
		lblPlayer1.setFont(new Font("Magneto", Font.PLAIN, 44));
		lblPlayer1.setBounds(125, 125, 225, 50);
		foMenu.add(lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel("Player 2:");
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setForeground(new Color(246, 76, 114));
		lblPlayer2.setFont(new Font("Magneto", Font.PLAIN, 44));
		lblPlayer2.setBounds(125, 175, 225, 50);
		foMenu.add(lblPlayer2);
		
		JLabel lblGameMode = new JLabel("Game Mode:");
		lblGameMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameMode.setForeground(new Color(246, 76, 114));
		lblGameMode.setFont(new Font("Magneto", Font.PLAIN, 42));
		lblGameMode.setBounds(125, 250, 300, 50);
		foMenu.add(lblGameMode);
		
		JButton btnStart = new JButton("Start Game!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PongGameFrame gFrame = new PongGameFrame(0);
	    		gFrame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnStart.setOpaque(false);
		btnStart.setForeground(new Color(246, 76, 114));
		btnStart.setFont(new Font("Century Gothic", Font.BOLD, 30));
		btnStart.setContentAreaFilled(false);
		btnStart.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnStart.setBackground(new Color(246, 76, 114));
		btnStart.setBounds(375, 350, 225, 75);
		foMenu.add(btnStart);
		
		JComboBox comboBoxPlayer1 = new JComboBox();
		comboBoxPlayer1.setForeground(new Color(246, 76, 114));
		comboBoxPlayer1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
		comboBoxPlayer1.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		comboBoxPlayer1.setBackground(new Color(36, 37, 130));
		comboBoxPlayer1.setBounds(450, 125, 300, 40);
		foMenu.add(comboBoxPlayer1);
		
		JComboBox comboBoxPlayer2 = new JComboBox();
		comboBoxPlayer2.setForeground(new Color(246, 76, 114));
		comboBoxPlayer2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
		comboBoxPlayer2.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		comboBoxPlayer2.setBackground(new Color(36, 37, 130));
		comboBoxPlayer2.setBounds(450, 175, 300, 40);
		foMenu.add(comboBoxPlayer2);
		
		JComboBox comboBoxGameMode = new JComboBox();
		comboBoxGameMode.setForeground(new Color(246, 76, 114));
		comboBoxGameMode.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
		comboBoxGameMode.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		comboBoxGameMode.setBackground(new Color(36, 37, 130));
		comboBoxGameMode.setBounds(450, 250, 300, 40);
		foMenu.add(comboBoxGameMode);
		
		JButton btnBackToHome = new JButton("Back to Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartFrame sFrame = new StartFrame();
				sFrame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBackToHome.setOpaque(false);
		btnBackToHome.setForeground(new Color(246, 76, 114));
		btnBackToHome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnBackToHome.setContentAreaFilled(false);
		btnBackToHome.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnBackToHome.setBackground(new Color(246, 76, 114));
		btnBackToHome.setBounds(25, 425, 125, 25);
		foMenu.add(btnBackToHome);
	    
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
		
		/*
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
		*/
	}
}
