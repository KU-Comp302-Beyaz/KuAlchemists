package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;

public class OnlineLoginWindow extends JFrame {

	private static OnlineLoginWindow onlineLoginWindow = new OnlineLoginWindow();

    private JPanel contentPane;
    
    public static OnlineLoginWindow getInstance() {
    	return onlineLoginWindow;
    }
	
	OnlineLoginWindow() {
		
		setResizable(false);
		//get screen height and width
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = dimension.height;
        int screenWidth = dimension.width;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 800);
		setResizable(false);        
        
        
        getContentPane().setLayout(null);
        
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        startGameButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//waiting Players to Join
        	}
        });
        startGameButton.setBounds(512, 536, 378, 74);
        getContentPane().add(startGameButton);
        
        JLabel waitingLabel = new JLabel("Waiting Players to Join...");
        waitingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
        waitingLabel.setBounds(344, 26, 777, 74);
        getContentPane().add(waitingLabel);
		
		
		
	}
	
	public void initialize() {
		setVisible(true);
	}
}
