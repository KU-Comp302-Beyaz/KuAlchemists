package ui;

import javax.swing.JButton;

import domain.artifact.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import domain.Game;
import domain.Game.Controller;
import domain.Player;
import domain.ingredients.Ingredient;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ArtifactDeckDisplay extends JFrame {
    
    
    
    
    private ArrayList<JLabel> artifactCardLabels;
    private ArrayList<JPanel> artifactCardPanels;
    
    private static final int IMAGE_WIDTH = 200, IMAGE_HEIGHT = 200, IMAGE_NUMBER = 12;

    private static ArtifactDeckDisplay artifactDeckDisplay; // Singleton
    private JTextField txtArtifactDeck;
    private JTextField txtGold;

    public static ArtifactDeckDisplay getArtifactDeckDisplay() {
        if (artifactDeckDisplay == null) {
            artifactDeckDisplay = new ArtifactDeckDisplay();
        }
        return artifactDeckDisplay;
    }

    private ArtifactDeckDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1440, 800);
        setResizable(false);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Menu");
        menuBar.add(fileMenu);

        JMenuItem openDialogMenuItem = new JMenuItem("Open Menu");
        fileMenu.add(openDialogMenuItem);

        openDialogMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });

        JTextPane effectDisplay = new JTextPane();
        effectDisplay.setText("123\n");
        effectDisplay.setBounds(1013, 329, 367, 237);
        getContentPane().add(effectDisplay);
        
        JButton backToBoardButton = new JButton("Back to Board");
        menuBar.add(backToBoardButton);
        getContentPane().setLayout(null);
        
        txtArtifactDeck = new JTextField();
        txtArtifactDeck.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        txtArtifactDeck.setEditable(false);
        txtArtifactDeck.setBackground(UIManager.getColor("Button.background"));
        txtArtifactDeck.setBounds(732, 6, 230, 73);
        txtArtifactDeck.setText("ARTIFACT DECK\n");
        getContentPane().add(txtArtifactDeck, BorderLayout.NORTH);
        txtArtifactDeck.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Button.background"));
        panel.setBounds(6, 150, 939, 425);
        getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton buyTheRiverButton = new JButton("");
        buyTheRiverButton.setIcon(new ImageIcon(ArtifactDeckDisplay.class.getResource("/images/artifacts/riverartifact 2.png")));
        buyTheRiverButton.setToolTipText("The River\n\nUse Type: Immediate\n\nWhen used this artifact will boost player's turn points by 2. \nThis artifact costs no turn points to buy.\nCan be bought once per turn.");
        panel.add(buyTheRiverButton);
         
        buyTheRiverButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.BUY_THE_RIVER); //buys the card utilising the controller
				effectDisplay.setText(ArtifactController.getArtifactController().displayMessage(Game.currPlayer , new TheRiver())); //displays the cards message
			}
		});
        
        JButton buyEOIButton = new JButton("");
        buyEOIButton.setIcon(new ImageIcon(ArtifactDeckDisplay.class.getResource("/images/artifacts/eoiartifact 2.png")));
        buyEOIButton.setToolTipText("Elixir of Insight:\n\nUse Type: Immidiate\n\nThis artifact allows the player to see and shuffle the top 3 ingredient cards in the deck");
        panel.add(buyEOIButton);
        
        txtGold = new JTextField();
        txtGold.setText("Gold: " );
        txtGold.setBounds(537, 648, 218, 45);
        getContentPane().add(txtGold);
        txtGold.setColumns(10);
        
        
        JTextPane txtpnHoverOverTo = new JTextPane();
        txtpnHoverOverTo.setBackground(UIManager.getColor("Button.background"));
        txtpnHoverOverTo.setEditable(false);
        txtpnHoverOverTo.setSelectedTextColor(Color.LIGHT_GRAY);
        txtpnHoverOverTo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        txtpnHoverOverTo.setSelectionColor(Color.LIGHT_GRAY);
        txtpnHoverOverTo.setText("Click on an artifact to purchase.\nHover over to see detailes.");
        txtpnHoverOverTo.setBounds(1014, 150, 357, 180);
        getContentPane().add(txtpnHoverOverTo);
        
        
        buyEOIButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.BUY_EOI);
				effectDisplay.setText(ArtifactController.getArtifactController().displayMessage(Game.currPlayer , new ElixirOfInsight()));
			}
		});
        

        backToBoardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BoardWindow board = BoardWindow.getBoardWindow();
                board.initialize();
                setVisible(false);
            }
        });
    }


    public void initialize(Player player) {
        if (player.getArtifacts() == null)
            return;

        
    }

    

    

    public void setArtifactCardLabels(ArrayList<JLabel> artifactCardLabels) {
        this.artifactCardLabels = artifactCardLabels;
    }
    
    public ArrayList<JPanel> getArtifactCardPanels() {
		return artifactCardPanels;
	}

    public void setArtifactCardPanels(ArrayList<JPanel> artifactCardPanels) {
        this.artifactCardPanels = artifactCardPanels;
    }
    
    public ArrayList<JLabel> getArtifactCardLabels() {
		return artifactCardLabels;
	}

   
   

    protected void openDialog() {
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(300, 150);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton helpButton = new JButton("Help");
        JButton pauseButton = new JButton("Pause");
        JButton exitButton = new JButton("Exit");

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
                pauseButton.setVisible(false);
                dialog.dispose();
            }
        });

        buttonPanel.add(helpButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(exitButton);

        dialog.getContentPane().add(buttonPanel);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    protected void showResumePausePage() {
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(300, 150);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton resumeButton = new JButton("Resume Game");

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeButton.setVisible(false);
                dialog.dispose();
            }
        });

        buttonPanel.add(resumeButton);
        dialog.getContentPane().add(buttonPanel);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}