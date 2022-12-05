package pongPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointShopFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PointShopFrame() {
		setBackground(new Color(36, 37, 130));
		setMaximumSize(new Dimension(1000, 500));
		setMinimumSize(new Dimension(1000, 500));
		setSize(new Dimension(1000, 500));
		setResizable(false);
		setTitle("Pong Points Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(1000, 500));
		contentPane.setMinimumSize(new Dimension(1000, 500));
		contentPane.setSize(new Dimension(1000, 500));
		contentPane.setBackground(new Color(36, 37, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPointsShop = new JLabel("Points Shop");
		lblPointsShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsShop.setForeground(new Color(246, 76, 114));
		lblPointsShop.setFont(new Font("Magneto", Font.PLAIN, 30));
		lblPointsShop.setBounds(25, 10, 200, 50);
		contentPane.add(lblPointsShop);
		
		JLabel lblCurrentPlayer = new JLabel("Current Player:");
		lblCurrentPlayer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCurrentPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentPlayer.setForeground(new Color(246, 76, 114));
		lblCurrentPlayer.setFont(new Font("Magneto", Font.PLAIN, 18));
		lblCurrentPlayer.setBounds(25, 60, 175, 25);
		contentPane.add(lblCurrentPlayer);
		
		JComboBox comboBoxPlayer = new JComboBox();
		comboBoxPlayer.setBackground(new Color(36, 37, 130));
		comboBoxPlayer.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		comboBoxPlayer.setModel(new DefaultComboBoxModel(new String[] {"Choose Player...", "Create New Player", "Lily"}));
		comboBoxPlayer.setForeground(new Color(246, 76, 114));
		comboBoxPlayer.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		comboBoxPlayer.setBounds(200, 60, 150, 25);
		contentPane.add(comboBoxPlayer);
		
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
		btnBackToHome.setBounds(25, 426, 125, 25);
		contentPane.add(btnBackToHome);
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setForeground(new Color(246, 76, 114));
		lblPoints.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblPoints.setBounds(825, 10, 100, 30);
		contentPane.add(lblPoints);
		
		JLabel lblPointsValue = new JLabel("?");
		lblPointsValue.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPointsValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsValue.setForeground(new Color(246, 76, 114));
		lblPointsValue.setFont(new Font("Magneto", Font.PLAIN, 18));
		lblPointsValue.setBounds(900, 10, 50, 30);
		contentPane.add(lblPointsValue);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(36, 37, 130));
		tabbedPane.setName("");
		tabbedPane.setBounds(25, 90, 950, 325);
		contentPane.add(tabbedPane);
		
		JPanel panelThemes = new JPanel();
		panelThemes.setForeground(new Color(246, 76, 114));
		panelThemes.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 10));
		panelThemes.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		panelThemes.setBackground(new Color(36, 37, 130));
		tabbedPane.addTab("Themes", null, panelThemes, null);
		tabbedPane.setBackgroundAt(0, new Color(246, 76, 114));
		panelThemes.setLayout(null);
		
		JPanel panelPaddles = new JPanel();
		panelPaddles.setLayout(null);
		panelPaddles.setForeground(new Color(246, 76, 114));
		panelPaddles.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 10));
		panelPaddles.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		panelPaddles.setBackground(new Color(36, 37, 130));
		tabbedPane.addTab("Paddles", null, panelPaddles, null);
		tabbedPane.setBackgroundAt(1, new Color(246, 76, 114));
		
		JPanel panelPurchased = new JPanel();
		panelPurchased.setLayout(null);
		panelPurchased.setForeground(new Color(246, 76, 114));
		panelPurchased.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 10));
		panelPurchased.setBorder(new LineBorder(new Color(246, 76, 114), 2));
		panelPurchased.setBackground(new Color(36, 37, 130));
		tabbedPane.addTab("Purchased", null, panelPurchased, null);
		tabbedPane.setBackgroundAt(2, new Color(246, 76, 114));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxPlayer.getSelectedItem();
				
			}
		});
		btnOk.setOpaque(false);
		btnOk.setForeground(new Color(246, 76, 114));
		btnOk.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnOk.setContentAreaFilled(false);
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(246, 76, 114));
		btnOk.setBounds(355, 60, 30, 25);
		contentPane.add(btnOk);
	}
}
