package org.cross.elsclient.ui.component;

import java.awt.Color;

import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class FunctionBtn extends ELSButton {
	Color archiveColor;
	Color archiveFont;
	public boolean isArchive;
	ELSLabel text;
	ELSLabel icon;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		isArchive = false;
		backColor = UIConstant.MAINCOLOR;
		archiveColor = Color.white;
		archiveFont = UIConstant.MAINCOLOR;
		setBackground(backColor);
		setForeground(Color.white);
	}
	
	public void setArchive(boolean isArchive){
		this.isArchive = isArchive;
		if(isArchive){
			setBackground(archiveColor);
			setForeground(archiveFont);
		}else{
			setBackground(backColor);
			setForeground(Color.white);
		}
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		setIcon(Images.getImageIcon(name));
	}
}
