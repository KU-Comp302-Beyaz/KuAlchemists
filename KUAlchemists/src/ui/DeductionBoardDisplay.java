package ui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;


public class DeductionBoardDisplay extends JFrame{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon X;
    private byte value;

  	
    	public DeductionBoardDisplay() {
    		getContentPane().setBackground(SystemColor.menu);
    		setBounds(300, 300, 1550, 900);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)

           
            JPanel panel = new JPanel();
            panel.setBackground(new Color(248, 248, 255));
    		getContentPane().add(panel, BorderLayout.CENTER);
    		GridBagLayout gbl_panel = new GridBagLayout();
    		gbl_panel.columnWidths = new int[]{1, 298, 291, 245, 578, 0};
    		gbl_panel.rowHeights = new int[]{1, 129, 0, 156, 0, 0, 0, 0, 0, 0, 0, 0};
    		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
    		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    		panel.setLayout(gbl_panel);

    		  		JButton btnNewButton = new JButton("Publish Theory");
    		  		btnNewButton.setForeground(new Color(139, 0, 0));
    		  		btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 13));
    		  		btnNewButton.addActionListener(new ActionListener() {
    		  			public void actionPerformed(ActionEvent e) {
 

    		  			}
    		  		});
 
    		  		    		JPanel deductionBoardPanel = new JPanel();
    		  		    		deductionBoardPanel.setBackground(new Color(224, 255, 255));
    		  		    		GridBagConstraints gbc_deductionBoardPanel = new GridBagConstraints();
    		  		    		gbc_deductionBoardPanel.gridwidth = 2;
    		  		    		gbc_deductionBoardPanel.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_deductionBoardPanel.fill = GridBagConstraints.BOTH;
    		  		    		gbc_deductionBoardPanel.gridheight = 4;
    		  		    		gbc_deductionBoardPanel.gridx = 3;
    		  		    		gbc_deductionBoardPanel.gridy = 1;
    		  		    		panel.add(deductionBoardPanel, gbc_deductionBoardPanel);
    		  		    		
    		  		    		GridBagLayout gbl_deductionBoardPanel = new GridBagLayout();
    		  		    		gbl_deductionBoardPanel.columnWidths = new int[]{28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 0, 0};
    		  		    		gbl_deductionBoardPanel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    		  		    		gbl_deductionBoardPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    		  		    		gbl_deductionBoardPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    		  		    		deductionBoardPanel.setLayout(gbl_deductionBoardPanel);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_3_4 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_3_4 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_3_4.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_3_4.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_3_4.gridx = 8;
    		  		    		gbc_rdbtnNewRadioButton_1_3_4.gridy = 1;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_3_4, gbc_rdbtnNewRadioButton_1_3_4);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_3_5 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_3_5 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_3_5.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_3_5.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_3_5.gridx = 7;
    		  		    		gbc_rdbtnNewRadioButton_1_3_5.gridy = 2;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_3_5, gbc_rdbtnNewRadioButton_1_3_5);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_3 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_3.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_3.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_3.gridx = 9;
    		  		    		gbc_rdbtnNewRadioButton_1_3.gridy = 2;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_3, gbc_rdbtnNewRadioButton_1_3);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_2 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_2.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_2.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_2.gridx = 6;
    		  		    		gbc_rdbtnNewRadioButton_1_2.gridy = 3;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_2, gbc_rdbtnNewRadioButton_1_2);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_1_2 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_1_2 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_1_2.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_1_2.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_1_2.gridx = 8;
    		  		    		gbc_rdbtnNewRadioButton_1_1_2.gridy = 3;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_1_2, gbc_rdbtnNewRadioButton_1_1_2);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_3_2 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_3_2 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_3_2.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_3_2.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_3_2.gridx = 10;
    		  		    		gbc_rdbtnNewRadioButton_1_3_2.gridy = 3;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_3_2, gbc_rdbtnNewRadioButton_1_3_2);
    		  		    		
    		  		    		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("");
    		  		    		GridBagConstraints gbc_rdbtnNewRadioButton_1_1 = new GridBagConstraints();
    		  		    		gbc_rdbtnNewRadioButton_1_1.anchor = GridBagConstraints.NORTHWEST;
    		  		    		gbc_rdbtnNewRadioButton_1_1.insets = new Insets(0, 0, 5, 5);
    		  		    		gbc_rdbtnNewRadioButton_1_1.gridx = 5;
    		  		    		gbc_rdbtnNewRadioButton_1_1.gridy = 4;
    		  		    		deductionBoardPanel.add(rdbtnNewRadioButton_1_1, gbc_rdbtnNewRadioButton_1_1);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_1_1_3 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_1_1_3 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_1_1_3.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton_1_1_3.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_1_1_3.gridx = 7;
    		  		    			gbc_rdbtnNewRadioButton_1_1_3.gridy = 4;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_1_1_3, gbc_rdbtnNewRadioButton_1_1_3);
    		  		    				
    		  		    				
    		  		    				JRadioButton rdbtnNewRadioButton_1_1_4 = new JRadioButton("");
    		  		    				GridBagConstraints gbc_rdbtnNewRadioButton_1_1_4 = new GridBagConstraints();
    		  		    				gbc_rdbtnNewRadioButton_1_1_4.anchor = GridBagConstraints.NORTHWEST;
    		  		    				gbc_rdbtnNewRadioButton_1_1_4.insets = new Insets(0, 0, 5, 5);
    		  		    				gbc_rdbtnNewRadioButton_1_1_4.gridx = 9;
    		  		    				gbc_rdbtnNewRadioButton_1_1_4.gridy = 4;
    		  		    				deductionBoardPanel.add(rdbtnNewRadioButton_1_1_4, gbc_rdbtnNewRadioButton_1_1_4);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_1_1_1 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_1_1_1.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton_1_1_1.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_1_1_1.gridx = 11;
    		  		    			gbc_rdbtnNewRadioButton_1_1_1.gridy = 4;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_1_1_1, gbc_rdbtnNewRadioButton_1_1_1);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton.gridx = 4;
    		  		    			gbc_rdbtnNewRadioButton.gridy = 5;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_1_3_3 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_1_3_3 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_1_3_3.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton_1_3_3.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_1_3_3.gridx = 6;
    		  		    			gbc_rdbtnNewRadioButton_1_3_3.gridy = 5;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_1_3_3, gbc_rdbtnNewRadioButton_1_3_3);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_1_3_1 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_1_3_1 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_1_3_1.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton_1_3_1.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_1_3_1.gridx = 8;
    		  		    			gbc_rdbtnNewRadioButton_1_3_1.gridy = 5;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_1_3_1, gbc_rdbtnNewRadioButton_1_3_1);
    		  		    			
    		  		    				JRadioButton rdbtnNewRadioButton_1_3_6 = new JRadioButton("");
    		  		    				GridBagConstraints gbc_rdbtnNewRadioButton_1_3_6 = new GridBagConstraints();
    		  		    				gbc_rdbtnNewRadioButton_1_3_6.anchor = GridBagConstraints.NORTHWEST;
    		  		    				gbc_rdbtnNewRadioButton_1_3_6.insets = new Insets(0, 0, 5, 5);
    		  		    				gbc_rdbtnNewRadioButton_1_3_6.gridx = 10;
    		  		    				gbc_rdbtnNewRadioButton_1_3_6.gridy = 5;
    		  		    				deductionBoardPanel.add(rdbtnNewRadioButton_1_3_6, gbc_rdbtnNewRadioButton_1_3_6);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTHWEST;
    		  		    			gbc_rdbtnNewRadioButton_1.gridx = 12;
    		  		    			gbc_rdbtnNewRadioButton_1.gridy = 5;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_2.gridx = 3;
    		  		    			gbc_rdbtnNewRadioButton_2.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_3.gridx = 5;
    		  		    			gbc_rdbtnNewRadioButton_3.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_11 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_11.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_11.gridx = 7;
    		  		    			gbc_rdbtnNewRadioButton_11.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_11, gbc_rdbtnNewRadioButton_11);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_10 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_10.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_10.gridx = 9;
    		  		    			gbc_rdbtnNewRadioButton_10.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_10, gbc_rdbtnNewRadioButton_10);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_9 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_9.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_9.gridx = 11;
    		  		    			gbc_rdbtnNewRadioButton_9.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_9, gbc_rdbtnNewRadioButton_9);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_8.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_8.gridx = 13;
    		  		    			gbc_rdbtnNewRadioButton_8.gridy = 6;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_14 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_14.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_14.gridx = 2;
    		  		    			gbc_rdbtnNewRadioButton_14.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_14, gbc_rdbtnNewRadioButton_14);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_13 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_13.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_13.gridx = 4;
    		  		    			gbc_rdbtnNewRadioButton_13.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_13, gbc_rdbtnNewRadioButton_13);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_12 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_12.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_12.gridx = 6;
    		  		    			gbc_rdbtnNewRadioButton_12.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_12, gbc_rdbtnNewRadioButton_12);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_4.gridx = 8;
    		  		    			gbc_rdbtnNewRadioButton_4.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_5.gridx = 10;
    		  		    			gbc_rdbtnNewRadioButton_5.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_6.gridx = 12;
    		  		    			gbc_rdbtnNewRadioButton_6.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 0, 5, 5);
    		  		    			gbc_rdbtnNewRadioButton_7.gridx = 14;
    		  		    			gbc_rdbtnNewRadioButton_7.gridy = 7;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_1 = new JRadioButton("");
    		  		    			rdbtnNewRadioButton_6_1.setBackground(SystemColor.activeCaptionText);
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_1 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_1.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_1.gridx = 1;
    		  		    			gbc_rdbtnNewRadioButton_6_1.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_1, gbc_rdbtnNewRadioButton_6_1);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_2 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_2 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_2.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_2.gridx = 3;
    		  		    			gbc_rdbtnNewRadioButton_6_2.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_2, gbc_rdbtnNewRadioButton_6_2);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_3 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_3 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_3.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_3.gridx = 5;
    		  		    			gbc_rdbtnNewRadioButton_6_3.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_3, gbc_rdbtnNewRadioButton_6_3);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_4 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_4 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_4.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_4.gridx = 7;
    		  		    			gbc_rdbtnNewRadioButton_6_4.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_4, gbc_rdbtnNewRadioButton_6_4);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_5 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_5 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_5.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_5.gridx = 9;
    		  		    			gbc_rdbtnNewRadioButton_6_5.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_5, gbc_rdbtnNewRadioButton_6_5);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_6 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_6 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_6.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_6.gridx = 11;
    		  		    			gbc_rdbtnNewRadioButton_6_6.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_6, gbc_rdbtnNewRadioButton_6_6);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_7 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_7 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_7.insets = new Insets(0, 0, 0, 5);
    		  		    			gbc_rdbtnNewRadioButton_6_7.gridx = 13;
    		  		    			gbc_rdbtnNewRadioButton_6_7.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_7, gbc_rdbtnNewRadioButton_6_7);
    		  		    			
    		  		    			JRadioButton rdbtnNewRadioButton_6_8 = new JRadioButton("");
    		  		    			GridBagConstraints gbc_rdbtnNewRadioButton_6_8 = new GridBagConstraints();
    		  		    			gbc_rdbtnNewRadioButton_6_8.gridx = 15;
    		  		    			gbc_rdbtnNewRadioButton_6_8.gridy = 8;
    		  		    			deductionBoardPanel.add(rdbtnNewRadioButton_6_8, gbc_rdbtnNewRadioButton_6_8);
    		  		
    		  		btnNewButton.setBackground(new Color(0, 0, 0));
    		  		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
    		  		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
    		  		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
    		  		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
    		  		gbc_btnNewButton.gridx = 1;
    		  		gbc_btnNewButton.gridy = 3;
    		  		panel.add(btnNewButton, gbc_btnNewButton);
    		  		
    		  		JPanel deductionGridPanel = new JPanel();
    		  		deductionGridPanel.setBackground(new Color(221, 160, 221));
    		  		GridBagConstraints gbc_deductionGridPanel = new GridBagConstraints();
    		  		gbc_deductionGridPanel.gridwidth = 2;
    		  		gbc_deductionGridPanel.anchor = GridBagConstraints.NORTH;
    		  		gbc_deductionGridPanel.fill = GridBagConstraints.HORIZONTAL;
    		  		gbc_deductionGridPanel.insets = new Insets(0, 0, 5, 0);
    		  		gbc_deductionGridPanel.gridx = 3;
    		  		gbc_deductionGridPanel.gridy = 5;
    		  		gbc_deductionGridPanel.gridheight = 4;
    		  		panel.add(deductionGridPanel, gbc_deductionGridPanel);
    		  		deductionGridPanel.setLayout(new GridLayout(9, 9, 0, 0)); 



    		
    		  		X = createScaledImageIcon("src/images/X.png", 100, 100);
    		  		
    		  	// Add labels for Y axis (1, 2, 3, ...)
    		  		for (int i = 0; i < 8; i++) {
    		  		    JLabel label = new JLabel(Integer.toString(i + 1));
    		  		    label.setHorizontalAlignment(JLabel.CENTER);
    		  		    deductionGridPanel.add(label);
    		  		}

    		  		JButton buttons[] = new JButton[64];
    		  		for (int i = 0; i < 64; i++) {
    		  		    // Add labels for X axis (1, 2, 3, ...)
    		  		    if (i % 8 == 0) {
    		  		        int xAxisLabel = i / 8 + 1;
    		  		        JLabel label = new JLabel(Integer.toString(xAxisLabel));
    		  		        label.setHorizontalAlignment(JLabel.CENTER);
    		  		        deductionGridPanel.add(label);
    		  		    }

    		  		    buttons[i] = new JButton();
    		  		    buttons[i].setPreferredSize(new Dimension(50, 50)); // Set the preferred size for each button
    		  		    buttons[i].addActionListener(new ActionListener() {
    		  		        @Override
    		  		        public void actionPerformed(ActionEvent e) {
    		  		            value++;
    		  		            value %= 3;
    		  		            switch (value) {
    		  		                case 0:
    		  		                    ((JButton) e.getSource()).setIcon(null);
    		  		                    break;
    		  		                case 1:
    		  		                    ((JButton) e.getSource()).setIcon(X);
    		  		                    break;
    		  		            }
    		  		        }
    		  		    });
    		  		    deductionGridPanel.add(buttons[i]);
    		  		}
    		 
		
    		//-- Menu bar
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu fileMenu = new JMenu("Menu");
            menuBar.add(fileMenu);
            
            JMenuItem openDialogMenuItem = new JMenuItem("Open Menu");
            fileMenu.add(openDialogMenuItem);
            
            // Add ActionListener to open the dialog when the menu item is clicked
            openDialogMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openDialog();
                }
            });
            
            
            
            //back to Board button
            JButton backToBoardButton = new JButton("Back to Board");
            menuBar.add(backToBoardButton);
            
            backToBoardButton.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				BoardWindow board = BoardWindow.getBoardWindow();
    				board.initialize();
    				setVisible(false);
    			}
    		});

}
    	
    	  private ImageIcon createScaledImageIcon(String path, int width, int height) {
    	        ImageIcon icon = new ImageIcon(path);
    	        Image image = icon.getImage();
    	        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	        return new ImageIcon(scaledImage);
    	    }
    	
	//method for menu bar
		protected void openDialog() {
			// Create a small dialog
	        JDialog dialog = new JDialog(this, "In Game Menu", true);
	        dialog.setSize(300, 150);

	        // Panel for the buttons in the dialog
	        JPanel buttonPanel = new JPanel(new FlowLayout());

	        // Buttons in the dialog
	        JButton helpButton = new JButton("Help");
	        JButton pauseButton = new JButton("Pause");
	        JButton exitButton = new JButton("Exit");

	        // Add ActionListener to the "Exit" button to close the dialog
	        exitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dialog.dispose();
	            }
	        });
	        
	        pauseButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(dialog, "Game Paused");
	                 showResumePausePage();
	                    //  Hide the "Pause Game" button and show the "Resume Game" button
	                    pauseButton.setVisible(false);
	                    //resumeButton.setVisible(true);
	                    dialog.dispose();
	                
	            }
	        });

	        // Add buttons to the panel
	        buttonPanel.add(helpButton);
	        buttonPanel.add(pauseButton);
	        buttonPanel.add(exitButton);

	        // Add the panel to the dialog
	        dialog.getContentPane().add(buttonPanel);

	        // Set the dialog location relative to the main frame
	        dialog.setLocationRelativeTo(this);

	        // Make the dialog visible
	        dialog.setVisible(true);
			
		}
		
		

	     
	    

		//method for menu bar
		protected void showResumePausePage() {
			JDialog dialog = new JDialog(this, "In Game Menu", true);
	        dialog.setSize(300, 150);

	        // Panel for the buttons in the dialog
	        JPanel buttonPanel = new JPanel(new FlowLayout());

	        // Buttons in the dialog
	        JButton resumeButton = new JButton("Resume Game");
	        
	        resumeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //JOptionPane.showMessageDialog(dialog, "Game Resumed");
	               // Hide the "Resume Game" button and show the "Pause Game" button
	                resumeButton.setVisible(false);
	              // pauseButton.setVisible(true);
	                                        
	                dialog.dispose();

	            }
	        });
	        
	        // Add buttons to the panel
	        buttonPanel.add(resumeButton);

	        // Add the panel to the dialog
	        dialog.getContentPane().add(buttonPanel);

	        // Set the dialog location relative to the main frame
	        dialog.setLocationRelativeTo(this);

	        // Make the dialog visible
	        dialog.setVisible(true);
			
		}

    public void initialize() {
		setVisible(true);
	}
}
