package ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PublicationTrackDisplay extends JFrame {
	
	private static PublicationTrackDisplay isDisplay = new PublicationTrackDisplay();
	
	
	
	private PublicationTrackDisplay() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        setResizable(false);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.addActionListener(e -> {
			
			;
			
		});
		panel.add(pauseButton, BorderLayout.WEST);
		
		JButton returnButton = new JButton("Back To Board");
		returnButton.addActionListener( e -> {
			
			BoardWindow board = BoardWindow.getBoardWindow();
			board.initialize();
			setVisible(false);
			
		});
		
		panel.add(returnButton, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Publication Track");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel cardTheoryContainer = new JPanel();
		getContentPane().add(cardTheoryContainer, BorderLayout.CENTER);
		cardTheoryContainer.setLayout(new BoxLayout(cardTheoryContainer, BoxLayout.Y_AXIS));
		
		
		
		
		JPanel publicationCardContainer = new JPanel();
		cardTheoryContainer.add(publicationCardContainer);
		publicationCardContainer.setLayout(new BoxLayout(publicationCardContainer, BoxLayout.X_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		publicationCardContainer.add(verticalGlue);
		
		JLabel lblNewLabel_1 = new JLabel("Card1");
		publicationCardContainer.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Card2");
		publicationCardContainer.add(lblNewLabel_2);
		
		Component glueBetweenContainers = Box.createVerticalGlue();
		
		cardTheoryContainer.add(glueBetweenContainers);
		
		JPanel theoryContainer = new JPanel();
		cardTheoryContainer.add(theoryContainer);
		theoryContainer.setLayout(new BoxLayout(theoryContainer, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("Theory1");
		theoryContainer.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Theory2");
		theoryContainer.add(lblNewLabel_4);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		theoryContainer.add(verticalGlue_1);
	}
	
	
	
	public static PublicationTrackDisplay getIsDisplay() {
		return isDisplay;
	}





	public void initialize() {
		setVisible(true);
	}

}
