package pongPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setResizable(false);
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 37, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 130));
		panel.setBounds(0, 0, 1000, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Magneto", Font.PLAIN, 40));
		lblWelcome.setBounds(275, 25, 254, 55);
		panel.add(lblWelcome);
		
		JLabel lblP = new JLabel("P");
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		lblP.setForeground(Color.WHITE);
		lblP.setFont(new Font("Magneto", Font.PLAIN, 99));
		lblP.setBounds(350, 65, 150, 125);
		panel.add(lblP);
		
		JLabel lblOng = new JLabel("ong");
		lblOng.setHorizontalAlignment(SwingConstants.CENTER);
		lblOng.setForeground(Color.WHITE);
		lblOng.setFont(new Font("Magneto", Font.PLAIN, 48));
		lblOng.setBounds(440, 110, 100, 50);
		panel.add(lblOng);
		
		JLabel lblCreated = new JLabel("<html>Created by: <br/>Alex, Brodie, and Lily</html>");
		lblCreated.setForeground(new Color(255, 255, 255));
		lblCreated.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreated.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblCreated.setBounds(812, 421, 180, 69);
		panel.add(lblCreated);
		
		JButton btnHowTo = new JButton("How to Play");
		btnHowTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HowToPlayFrame htpf = new HowToPlayFrame();
				dispose();
				
			}
		});
		btnHowTo.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnHowTo.setContentAreaFilled(false);
		btnHowTo.setOpaque(false);
		btnHowTo.setBackground(new Color(246, 76, 114));
		btnHowTo.setForeground(new Color(246, 76, 114));
		btnHowTo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnHowTo.setBounds(30, 448, 125, 25);
		panel.add(btnHowTo);
		
		JButton btnPointsShop = new JButton("Points Shop");
		btnPointsShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PongStoreFrame frame = new PongStoreFrame();
				dispose();
			}
		});
		btnPointsShop.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnPointsShop.setContentAreaFilled(false);
		btnPointsShop.setOpaque(false);
		btnPointsShop.setBackground(new Color(246, 76, 114));
		btnPointsShop.setForeground(new Color(246, 76, 114));
		btnPointsShop.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnPointsShop.setBounds(30, 413, 125, 25);
		panel.add(btnPointsShop);
		
		JButton btnSingleplayer = new JButton("Singleplayer");
		btnSingleplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinglePlayerStartFrame spFrame = new SinglePlayerStartFrame();
				dispose();
			}
		});
		btnSingleplayer.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnSingleplayer.setContentAreaFilled(false);
		btnSingleplayer.setOpaque(false);
		btnSingleplayer.setBackground(new Color(246, 76, 114));
		btnSingleplayer.setForeground(new Color(246, 76, 114));
		btnSingleplayer.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnSingleplayer.setBounds(300, 225, 150, 75);
		panel.add(btnSingleplayer);
		
		JButton btnFaceoff = new JButton("Face-off");
		btnFaceoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FaceOffStartFrame foFrame = new FaceOffStartFrame();
				dispose();
			}
		});
		btnFaceoff.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnFaceoff.setContentAreaFilled(false);
		btnFaceoff.setOpaque(false);
		btnFaceoff.setBackground(new Color(246, 76, 114));
		btnFaceoff.setForeground(new Color(246, 76, 114));
		btnFaceoff.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnFaceoff.setBounds(500, 225, 150, 75);
		panel.add(btnFaceoff);
	}
}
