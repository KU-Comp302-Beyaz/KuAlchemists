package ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class ImageListCellRenderer implements ListCellRenderer {
	/**
	 * Needed for the JLists -> contains a list of JPanels with JLabels instead of Strings
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
	      Component component = (Component) value;
	      component.setForeground(Color.white);
	      component.setBackground(isSelected ? UIManager.getColor("Table.focusCellForeground") : Color.white);
	      return component;
	}
}