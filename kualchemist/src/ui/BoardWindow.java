package ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class BoardWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public BoardWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 971, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 971, 412));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel boardDisplay = new JPanel();
		boardDisplay.setBounds(0, 0, 971, 384);
		contentPane.add(boardDisplay);
		boardDisplay.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOARD");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		lblNewLabel.setBounds(394, 157, 204, 60);
		boardDisplay.add(lblNewLabel);
		
	}
	
	public void initialize() {
		
		setVisible(true);
	}

}
