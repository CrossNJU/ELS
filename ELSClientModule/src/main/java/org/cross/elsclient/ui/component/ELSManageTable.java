package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.cross.elsclient.ui.util.UIConstant;

public class ELSManageTable extends JScrollPane {
	String[] name;
	ELSBox header;
	protected ELSBox container;
	ELSLabel tempLabel;
	protected ArrayList<Box> itemLabels;
	int[] itemWidth;
	int width;
	int height;
	public int gap;
	Font font;

	public ELSManageTable(){
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}
	
	public ELSManageTable(String[] name, int[] itemWidth) {
		super();
		this.name = name;
		this.itemWidth = itemWidth;
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}

	public void init() {
		setViewport(null);
		
		itemLabels = new ArrayList<>();
		container = new ELSBox(BoxLayout.Y_AXIS);
		header = new ELSBox(BoxLayout.X_AXIS);
		gap = 20;
		font = getFont().deriveFont(18f);

		setSize(width, UIConstant.MANAGETABLE_HEIGHT);
		setBorder(null);
		
		container.setSize(width,UIConstant.MANAGETABLE_HEIGHT);
//		container.setBackground(Color.LIGHT_GRAY);
//		container.setOpaque(true);
//		container.setSize(width, height);
//		container.setLocation(0, 0);

		header.setOpaque(true);
		header.setBackground(Color.GRAY);
		header.setPreferredSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		header.setMaximumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		header.setMinimumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));

		for (int i = 0; i < name.length; i++) {
			tempLabel = new ELSLabel(" " + name[i]);
			tempLabel.setForeground(Color.white);
			tempLabel.setFont(font);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
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
		itemLabel.setPreferredSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		itemLabel.setMaximumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		itemLabel.setMinimumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));

		for (int i = 0; i < item.length; i++) {
			tempLabel = new ELSLabel(" " + item[i]);
			tempLabel.setFont(font);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
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
