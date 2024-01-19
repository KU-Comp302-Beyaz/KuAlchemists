package ui;

import javax.swing.DefaultListSelectionModel;

/**
 * Needed for ingredient cards and potions panels etc, so they cannot be selected
 */
public class NoSelectionModel extends DefaultListSelectionModel {
	   @Override
	   public void setAnchorSelectionIndex(final int anchorIndex) {}

	   @Override
	   public void setLeadAnchorNotificationEnabled(final boolean flag) {}

	   @Override
	   public void setLeadSelectionIndex(final int leadIndex) {}

	   @Override
	   public void setSelectionInterval(final int index0, final int index1) { }
	}