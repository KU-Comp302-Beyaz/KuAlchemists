package ui;

import javax.swing.*;

import domain.Game;
import domain.ingredients.Ingredient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class EOISwapper extends JFrame {
    private List<Ingredient> ingredients = Game.getGame().getCurrPlayer().getIngredientCards();

    public EOISwapper() {
        // Replace this with your actual array retrieval logic

        setTitle("EOI Swapper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold the cards
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for (Ingredient card : ingredients.subList(0, 3)) {
            JButton cardButton = new JButton("");
            cardButton.addActionListener(new CardButtonListener());
            cardPanel.add(cardButton);
        }

        // Create a button to perform the rearrangement
        JButton rearrangeButton = new JButton("Rearrange Cards");
        rearrangeButton.addActionListener(new RearrangeButtonListener());

        // Add components to the frame
        add(cardPanel, BorderLayout.CENTER);
        add(rearrangeButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private class CardButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle card button clicks (you can add functionality if needed)
        }
    }

    private class RearrangeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform rearrangement logic here
            // For example, you can update the order of elements in the 'ingredientCards' list
            // and update the buttons in the cardPanel accordingly
            JOptionPane.showMessageDialog(EOISwapper.this, "Rearrangement completed!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EOISwapper().setVisible(true);
        });
    }
}

