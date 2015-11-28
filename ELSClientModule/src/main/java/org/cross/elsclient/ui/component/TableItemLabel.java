package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import org.cross.elsclient.ui.util.UIConstant;

public class TableItemLabel extends ELSBox{
	int width;
	int height;
	
	public TableItemLabel(){
		super(BoxLayout.X_AXIS);
	}
	
	public TableItemLabel(int axis) {
		super(axis);
	}

	public void init(){
		width = UIConstant.CONTAINER_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
		
		this.setOpaque(true);
		this.setBackground(Color.lightGray);
		this.setPreferredSize(new Dimension(width ,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
	}
	
}
