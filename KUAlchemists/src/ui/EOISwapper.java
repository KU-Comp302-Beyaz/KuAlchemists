package ui;

import javax.swing.*;

import domain.Game;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class EOISwapper extends JFrame {
    private ArrayList<Ingredient> ingredients = IngredientStorage.getInstance().getIngredientCards();
    private Ingredient first, second, third;
    private int num;

    public EOISwapper() {

        setTitle("EOI Swapper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold the cards
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.num = 1;
        for (Ingredient card : ingredients.subList(0, 3)) {
        		JButton cardButton = new JButton("");
        		cardButton.setIcon(new ImageIcon(card.getPhoto()));
        		cardButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		String[] position = {"1", "2", "3"};
                    String ans = (String)JOptionPane.showInputDialog(null,"Chose the new position","Player Number",
                    		JOptionPane.QUESTION_MESSAGE,null,position,position[0]);
                 if(Integer.valueOf(ans) == 1) {
                	 first = card;                       	 
                 }
                 else if(Integer.valueOf(ans) == 2) {
                	 second = card;
                 }
                 else if(Integer.valueOf(ans) == 3) {
                	 third = card;
                 }
            	}
            });
            cardPanel.add(cardButton);
            num++;
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

//    private class CardButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            // Handle card button clicks (you can add functionality if needed)
//        	
//        }
//    }

    private class RearrangeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           
        	ingredients.set(0, first);
        	ingredients.set(1, second);
        	ingredients.set(2, third);
            JOptionPane.showMessageDialog(EOISwapper.this, "Rearrangement completed!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EOISwapper().setVisible(true);
        });
    }
}

