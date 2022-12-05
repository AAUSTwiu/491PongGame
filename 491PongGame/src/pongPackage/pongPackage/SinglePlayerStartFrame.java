package pongPackage;
	
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class SinglePlayerStartFrame extends JFrame implements ActionListener {
	SinglePlayerStartPanel spMenu;
	UserList users = new UserList();
	private JLabel lblTitleSP;
	private JLabel lblPlayer;
	private JLabel lblGameMode;
	private JComboBox comboBoxPlayer;
	private JComboBox comboBoxMode;
	private JButton btnBackToHome;
	private JButton btnStart;
	SinglePlayerStartFrame(){
		spMenu = new SinglePlayerStartPanel();
		getContentPane().add(spMenu);
		
		this.setResizable(false);
	  	this.setBackground(new Color(36, 37, 130));
	  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.pack();
	  	this.setLocationRelativeTo(null);
	  	this.setVisible(true);
	    
	    lblTitleSP = new JLabel("Singleplayer Mode");
	    lblTitleSP.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitleSP.setForeground(new Color(246, 76, 114));
	    lblTitleSP.setFont(new Font("Magneto", Font.PLAIN, 48));
	    lblTitleSP.setBounds(250, 50, 550, 50);
	    spMenu.add(lblTitleSP);
	    
	    lblPlayer = new JLabel("Player:");
	    lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPlayer.setForeground(new Color(246, 76, 114));
	    lblPlayer.setFont(new Font("Magneto", Font.PLAIN, 44));
	    lblPlayer.setBounds(250, 150, 200, 50);
	    spMenu.add(lblPlayer);
	    
	    lblGameMode = new JLabel("Game Mode:");
	    lblGameMode.setHorizontalAlignment(SwingConstants.CENTER);
	    lblGameMode.setForeground(new Color(246, 76, 114));
	    lblGameMode.setFont(new Font("Magneto", Font.PLAIN, 42));
	    lblGameMode.setBounds(150, 250, 300, 50);
	    spMenu.add(lblGameMode);
	    
	    String[] gm = {"Score (default 5)", "Timed in Minutes (default 2)"};
	    
	    comboBoxPlayer = new JComboBox();
	    comboBoxPlayer.setModel(new DefaultComboBoxModel(new String[] {"Choose Player...", "Lily", "Create New Player"}));
	    comboBoxPlayer.setForeground(new Color(246, 76, 114));
	    comboBoxPlayer.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
	    comboBoxPlayer.setBorder(new LineBorder(new Color(246, 76, 114), 2));
	    comboBoxPlayer.setBackground(new Color(36, 37, 130));
	    comboBoxPlayer.setBounds(500, 150, 300, 40);
	    spMenu.add(comboBoxPlayer);
	    
	    comboBoxMode = new JComboBox();
	    comboBoxMode.setModel(new DefaultComboBoxModel(new String[] {"Points", "Timed"}));
	    comboBoxMode.setForeground(new Color(246, 76, 114));
	    comboBoxMode.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
	    comboBoxMode.setBorder(new LineBorder(new Color(246, 76, 114), 2));
	    comboBoxMode.setBackground(new Color(36, 37, 130));
	    comboBoxMode.setBounds(500, 250, 300, 40);
	    spMenu.add(comboBoxMode);
	    
	    btnBackToHome = new JButton("Back to Home");
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
	    btnBackToHome.setBounds(25, 450, 125, 25);
	    spMenu.add(btnBackToHome);
	    
	    btnStart = new JButton("Start Game!");
	    btnStart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		PongGameFrame gFrame = new PongGameFrame(1);
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
	    spMenu.add(btnStart);
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
		/*if(e.getActionCommand().equals("Start")) {
			UserList users = new UserList();
			String p1 = player.getText();
			String p2 = "CPU";
			users.addNewUser(p1);
			PongGameFrame game = new PongGameFrame(1,users,p1,p2,Integer.parseInt(winScore.getText()));
		}
		*/
	}
}
