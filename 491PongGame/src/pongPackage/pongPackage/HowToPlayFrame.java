package pongPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HowToPlayFrame extends JFrame {

	private JPanel contentPane;
	JPanel panelPage1, panelPage2;
	/**
	 * Create the frame.
	 */
	public HowToPlayFrame() {
		setBackground(new Color(36, 37, 130));
		setPreferredSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(500, 500));
		setBounds(new Rectangle(0, 0, 500, 500));
		setTitle("How to Play Pong");
		setSize(new Dimension(500, 500));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 397);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 500));
		contentPane.setSize(new Dimension(500, 500));
		contentPane.setMinimumSize(new Dimension(500, 500));
		contentPane.setMaximumSize(new Dimension(500, 500));
		contentPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.setBackground(new Color(36, 37, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnBackToHome.setBounds(25, 420, 125, 25);
		contentPane.add(btnBackToHome);
		
		
		//How to Play Page 1
		panelPage1 = new JPanel();
		panelPage1.setBackground(new Color(36, 37, 130));
		panelPage1.setBounds(new Rectangle(0, 0, 500, 500));
		panelPage1.setSize(new Dimension(500, 500));
		panelPage1.setPreferredSize(new Dimension(500, 500));
		panelPage1.setMinimumSize(new Dimension(500, 500));
		panelPage1.setMaximumSize(new Dimension(500, 500));
		panelPage1.setBounds(0, 0, 525, 460);
		contentPane.add(panelPage1);
		panelPage1.setLayout(null);
		
		JLabel lblHowToTitle = new JLabel("How to Play");
		lblHowToTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToTitle.setForeground(new Color(246, 76, 114));
		lblHowToTitle.setFont(new Font("Magneto", Font.PLAIN, 36));
		lblHowToTitle.setBounds(150, 30, 250, 50);
		panelPage1.add(lblHowToTitle);
		
		JLabel lblSP = new JLabel("Singleplayer");
		lblSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSP.setForeground(new Color(246, 76, 114));
		lblSP.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblSP.setBounds(50, 200, 150, 50);
		panelPage1.add(lblSP);
		
		JLabel lblFO = new JLabel("Face-Off");
		lblFO.setHorizontalAlignment(SwingConstants.CENTER);
		lblFO.setForeground(new Color(246, 76, 114));
		lblFO.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblFO.setBounds(350, 200, 125, 50);
		panelPage1.add(lblFO);
		
		JLabel lblInstructions = new JLabel("<html><p style=\"text-align:center\"> Use your paddle to hit the ball back towards your opponent. You score a point if your opponent misses. First to 10 points wins!</p></html>");
		lblInstructions.setSize(new Dimension(100, 100));
		lblInstructions.setPreferredSize(new Dimension(100, 100));
		lblInstructions.setMaximumSize(new Dimension(100, 100));
		lblInstructions.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setForeground(Color.WHITE);
		lblInstructions.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblInstructions.setBounds(100, 100, 375, 75);
		panelPage1.add(lblInstructions);
		
		JLabel lblSPDesc = new JLabel("<html><p style=\"text-align:center\"> Use the \"W\" and \"S\" keys to move paddle up and down.</p></html>");
		lblSPDesc.setSize(new Dimension(100, 100));
		lblSPDesc.setPreferredSize(new Dimension(100, 100));
		lblSPDesc.setMaximumSize(new Dimension(100, 100));
		lblSPDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSPDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblSPDesc.setForeground(Color.WHITE);
		lblSPDesc.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblSPDesc.setBounds(25, 250, 200, 50);
		panelPage1.add(lblSPDesc);
		
		JLabel lblFODesc = new JLabel("<html><p style=\"text-align:center\"> The player using the left paddle uses the \"W\" and \"S\" keys to move paddle down. The player using the right paddle uses the up and down arrow keys.</p></html>");
		lblFODesc.setSize(new Dimension(100, 100));
		lblFODesc.setPreferredSize(new Dimension(100, 100));
		lblFODesc.setMaximumSize(new Dimension(100, 100));
		lblFODesc.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFODesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblFODesc.setForeground(Color.WHITE);
		lblFODesc.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblFODesc.setBounds(315, 230, 200, 150);
		panelPage1.add(lblFODesc);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPage1.setVisible(false);
				panelPage2.setVisible(true);
			}
		});
		btnNext.setOpaque(false);
		btnNext.setForeground(new Color(246, 76, 114));
		btnNext.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnNext.setBackground(new Color(246, 76, 114));
		btnNext.setBounds(475, 420, 50, 25);
		panelPage1.add(btnNext);
		
		
		
		//How to Play Page 2
		panelPage2 = new JPanel();
		panelPage2.setLayout(null);
		panelPage2.setSize(new Dimension(500, 500));
		panelPage2.setPreferredSize(new Dimension(500, 500));
		panelPage2.setMinimumSize(new Dimension(500, 500));
		panelPage2.setMaximumSize(new Dimension(500, 500));
		panelPage2.setBounds(new Rectangle(0, 0, 500, 500));
		panelPage2.setBackground(new Color(36, 37, 130));
		panelPage2.setBounds(0, 0, 525, 475);
		contentPane.add(panelPage2);
		
		JLabel lblHowToTitle2 = new JLabel("How to Play");
		lblHowToTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToTitle2.setForeground(new Color(246, 76, 114));
		lblHowToTitle2.setFont(new Font("Magneto", Font.PLAIN, 36));
		lblHowToTitle2.setBounds(150, 30, 250, 50);
		panelPage2.add(lblHowToTitle2);
		
		JLabel lblPowerUps = new JLabel("Powerups");
		lblPowerUps.setHorizontalAlignment(SwingConstants.CENTER);
		lblPowerUps.setForeground(new Color(246, 76, 114));
		lblPowerUps.setFont(new Font("Magneto", Font.PLAIN, 24));
		lblPowerUps.setBounds(200, 80, 150, 55);
		panelPage2.add(lblPowerUps);
		
		JLabel lblMagenta = new JLabel("Magenta");
		lblMagenta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMagenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagenta.setForeground(new Color(246, 76, 114));
		lblMagenta.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblMagenta.setBounds(50, 125, 125, 50);
		panelPage2.add(lblMagenta);
		
		JLabel lblMagentaDesc = new JLabel("<html><p style=\"text-align:center\">The magenta power up splits the ball into 2!</p></html>");
		lblMagentaDesc.setSize(new Dimension(100, 100));
		lblMagentaDesc.setPreferredSize(new Dimension(100, 100));
		lblMagentaDesc.setMaximumSize(new Dimension(100, 100));
		lblMagentaDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMagentaDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagentaDesc.setForeground(Color.WHITE);
		lblMagentaDesc.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblMagentaDesc.setBounds(50, 175, 125, 100);
		panelPage2.add(lblMagentaDesc);
		
		JLabel lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		lblRed.setForeground(new Color(246, 76, 114));
		lblRed.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblRed.setBounds(210, 125, 125, 50);
		panelPage2.add(lblRed);
		
		JLabel lblwRedDesc = new JLabel("<html><p style=\"text-align:center\">The red power up shrinks your opponent's paddle.\r\n</p></html>");
		lblwRedDesc.setSize(new Dimension(100, 100));
		lblwRedDesc.setPreferredSize(new Dimension(100, 100));
		lblwRedDesc.setMaximumSize(new Dimension(100, 100));
		lblwRedDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		lblwRedDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblwRedDesc.setForeground(Color.WHITE);
		lblwRedDesc.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblwRedDesc.setBounds(215, 175, 125, 100);
		panelPage2.add(lblwRedDesc);
		
		JLabel lblPink = new JLabel("Pink");
		lblPink.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPink.setHorizontalAlignment(SwingConstants.CENTER);
		lblPink.setForeground(new Color(246, 76, 114));
		lblPink.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblPink.setBounds(375, 125, 125, 50);
		panelPage2.add(lblPink);
		
		JLabel lblPinkDesc = new JLabel("<html><p style=\"text-align:center\">The pink power up increases the size of your own paddle.</p></html>");
		lblPinkDesc.setSize(new Dimension(100, 100));
		lblPinkDesc.setPreferredSize(new Dimension(100, 100));
		lblPinkDesc.setMaximumSize(new Dimension(100, 100));
		lblPinkDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPinkDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinkDesc.setForeground(Color.WHITE);
		lblPinkDesc.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblPinkDesc.setBounds(375, 175, 125, 100);
		panelPage2.add(lblPinkDesc);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPage1.setVisible(true);
				panelPage2.setVisible(false);
			}
		});
		btnBack.setOpaque(false);
		btnBack.setForeground(new Color(246, 76, 114));
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		btnBack.setBackground(new Color(246, 76, 114));
		btnBack.setBounds(475, 420, 50, 25);
		panelPage2.add(btnBack);
		
		
		
	}
	
	
}
