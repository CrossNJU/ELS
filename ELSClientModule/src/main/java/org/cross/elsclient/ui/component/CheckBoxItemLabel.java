package org.cross.elsclient.ui.component;

import javax.swing.Box;
import javax.swing.ImageIcon;

public class CheckBoxItemLabel extends ManageTableItemLabel{
	public ELSCheckBox checkBox;
	
	public CheckBoxItemLabel() {
		super();
	}

	public CheckBoxItemLabel(int axis) {
		super(axis);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(String[] item, int[] itemWidth, boolean isUpdateAndDelete) {
		checkBox = new ELSCheckBox();
		checkBox.setOpaque(false);
//		checkBox.setIcon(new ImageIcon("img/test-icon.png"));
//		checkBox.setSelectedIcon(new ImageIcon("img/test-icon2.png"));
//		checkBox.setRolloverIcon(new ImageIcon("img/test-icon2.png"));
		this.add(checkBox);
		this.add(Box.createHorizontalStrut(20));
		super.init(item, itemWidth, isUpdateAndDelete);
	}
}
