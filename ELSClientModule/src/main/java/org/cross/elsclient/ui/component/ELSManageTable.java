package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ELSManageTable extends JScrollPane {
	String[] name;
	ELSBox header;
	ELSBox container;
	ELSLabel tempLabel;
	protected ArrayList<Box> itemLabels;
	int[] itemWidth;
	int width;
	int height;

	public ELSManageTable(String[] name, int[] itemWidth, int tableWidth,int tableHeight) {
		super();
		this.name = name;
		this.itemWidth = itemWidth;
		width = tableWidth;
		height = tableHeight;
		init();
	}

	public void init() {
		setViewport(null);
		
		itemLabels = new ArrayList<>();
		container = new ELSBox(BoxLayout.Y_AXIS);
		header = new ELSBox(BoxLayout.X_AXIS);

		setSize(width, 500);
		setBorder(null);
		
		
		container.setSize(width,500);
//		container.setBackground(Color.LIGHT_GRAY);
//		container.setOpaque(true);
//		container.setSize(width, height);
//		container.setLocation(0, 0);

		header.setOpaque(true);
		header.setBackground(Color.GRAY);
		header.setPreferredSize(new Dimension(width,height));
		header.setMaximumSize(new Dimension(width,height));
		header.setMinimumSize(new Dimension(width,height));

		for (int i = 0; i < name.length; i++) {
			tempLabel = new ELSLabel(" " + name[i]);
			tempLabel.setForeground(Color.white);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			header.add(tempLabel);
		}

		container.add(header);
		setViewportView(container);
		validate();
		repaint();
	}
	
	protected void addItemLabel(String[] item) {
		Box itemLabel = new Box(BoxLayout.X_AXIS);

		itemLabel.setOpaque(true);
		itemLabel.setBackground(Color.lightGray);
		itemLabel.setPreferredSize(new Dimension(width, header.getPreferredSize().height));
		itemLabel.setMaximumSize(new Dimension(width, header.getPreferredSize().height));
		itemLabel.setMinimumSize(new Dimension(width, header.getPreferredSize().height));

		for (int i = 0; i < item.length; i++) {
			tempLabel = new ELSLabel(" " + item[i]);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i], header.getPreferredSize().height));
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			itemLabel.add(tempLabel);
		}

		itemLabels.add(itemLabel);
		container.add(itemLabel);
		validate();
		repaint();
	}
	
	
}
