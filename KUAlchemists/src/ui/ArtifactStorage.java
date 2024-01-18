package ui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.*;
import domain.Game;
import domain.Game.Controller;
import domain.artifact.Artifact;
import domain.artifact.ArtifactController;
import domain.artifact.WisdomIdol;

public class ArtifactStorage extends JFrame {

    private HashMap<String, Artifact> artifacts;

    public ArtifactStorage() {
    	artifacts = Game.getGame().getCurrPlayer().getArtifacts();
        setBounds(0, 0, 320, 150);
        setResizable(false);

        JPanel panel = new JPanel();
        createButtons(artifacts, panel);
        getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // Left-aligned flow layout

        
    }

    public void createButtons(HashMap<String, Artifact> map, JPanel panel) {
        int buttonWidth = 100;
        int buttonHeight = 100;
        

        for (Entry<String, Artifact> entry : map.entrySet()) {
            String name = entry.getKey();
            Artifact artifact = entry.getValue();

        
            String imagePath = artifact.getImagePath();

            JButton artifactButton = new JButton("");
            artifactButton.setIcon(new ImageIcon(ArtifactDeckDisplay.class.getResource(imagePath)));
            artifactButton.setToolTipText(artifact.getDescription());

            
            artifactButton.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
            
            artifactButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Game.getGame().getCurrPlayer().setCurrArtifact(artifact);	
            		Game.getGame().selectController(Controller.USE_ARTIFACT);
            		panel.remove(artifactButton);
    			}
    		});
           
           

            panel.add(artifactButton);  // Add the button to the panel
        }

     
        
    }

    public static void main(String[] args) {
        // Use EventQueue.invokeLater to ensure GUI updates are done on the EDT
        javax.swing.SwingUtilities.invokeLater(() -> {
            ArtifactStorage frame = new ArtifactStorage();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
