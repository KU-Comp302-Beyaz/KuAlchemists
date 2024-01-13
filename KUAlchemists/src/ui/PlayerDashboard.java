package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerDashboard extends JFrame {
    private JLabel goldLabel, reputationLabel, sicknessLabel, turnLabel;
    private JTextField goldField, reputationField, sicknessField, turnField;
    private JButton artifactsButton;

    public PlayerDashboard() {
        // Set the title of the window
        super("Player Dashboard");

        // Initialize components
        goldLabel = new JLabel("Gold:");
        reputationLabel = new JLabel("Reputation Points:");
        sicknessLabel = new JLabel("Sickness Level:");
        turnLabel = new JLabel("Turn Points:");

        goldField = new JTextField(10);
        goldField.setEditable(false); // Set to non-editable
        reputationField = new JTextField(10);
        reputationField.setEditable(false); // Set to non-editable
        sicknessField = new JTextField(10);
        sicknessField.setEditable(false); // Set to non-editable
        turnField = new JTextField(10);
        turnField.setEditable(false); // Set to non-editable

        artifactsButton = new JButton("Artifact Storage");
        artifactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle artifact button click action here
                JOptionPane.showMessageDialog(PlayerDashboard.this, "Artifact Storage Button Clicked!");
            }
        });

        // Set layout manager
        setLayout(new GridLayout(6, 2, 10, 10)); // Added some space between components

        // Add components to the frame
        add(goldLabel);
        add(goldField);
        add(reputationLabel);
        add(reputationField);
        add(sicknessLabel);
        add(sicknessField);
        add(turnLabel);
        add(turnField);
        add(new JLabel()); // Empty label for spacing
        add(artifactsButton);

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250); // Slightly increased height for better spacing
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and display the frame
            PlayerDashboard playerDashboard = new PlayerDashboard();
            playerDashboard.setVisible(true);
        });
    }
}
