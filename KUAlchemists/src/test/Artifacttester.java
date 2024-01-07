package test;
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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class Artifacttester {
	
	private static String outcome;
	
	private Player currplayer = new Player("tester", 1);
	
	

		
		//the river normal no effect
		@Test
		@DisplayName("Testing TheRiver Artifact under normal conditions")
		public void testTheRiver_NormalCondition() {
			currplayer.setGoldBalance(3);
			currplayer.setTurnNumber(1);
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currplayer);
			assertEquals(0, currplayer.getGoldBalance());
			assertEquals(0,  currplayer.getTurnNumber());
			
		}
		// eoi normal no effect
		@Test
		@DisplayName("Testing EOI Artifact under normal conditions")
		public void testEOI_NormalCondition() {
			currplayer.setGoldBalance(3);
			currplayer.setTurnNumber(1);
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currplayer);
			assertEquals(0, currplayer.getGoldBalance());
			assertEquals(0,  currplayer.getTurnNumber());
			
		}
		@Test
		@DisplayName("Testing TheRiver Artifact - the player has no gold")
		//the river no balance no effect
		public void testTheRiver_NoGold() {
			currplayer.setGoldBalance(0);
			currplayer.setTurnNumber(1);
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currplayer);
			assertEquals(0, currplayer.getGoldBalance());
			assertEquals(1,  currplayer.getTurnNumber());
			
		}
		@Test
		@DisplayName("Testing TheRiver Artifact - the player has no turn points")
		//the river no turn no effect
		public void testTheRiver_NoTurn() {
			currplayer.setGoldBalance(3);
			currplayer.setTurnNumber(0);
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currplayer);
			assertEquals(3, currplayer.getGoldBalance());
			assertEquals(0,  currplayer.getTurnNumber());
			
		}
		
		@Test
		@DisplayName("Testing EOI Artifact - the player has no gold")
		// eoi no balance no effect
		public void testEOI_NoGold() {
			currplayer.setGoldBalance(0);
			currplayer.setTurnNumber(1);
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currplayer);
			assertEquals(0, currplayer.getGoldBalance());
			assertEquals(1,  currplayer.getTurnNumber());
			
		}
		@Test
		@DisplayName("Testing EOI Artifact - the player has no turn points")
		// eoi no turn no effect
		public void testEOI_NoTurn() {
			currplayer.setGoldBalance(3);
			currplayer.setTurnNumber(0);
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currplayer);
			assertEquals(3, currplayer.getGoldBalance());
			assertEquals(0,  currplayer.getTurnNumber());
			
		}
	}


