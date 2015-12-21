package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;

public class FunctionBtn extends ELSButton {
	Color archiveColor;
	Color archiveFont;
	public boolean isArchive;
	ELSLabel text;
	ELSLabel icon;
	ELSLabel arrow;
	ImageIcon normalIcon;
	ImageIcon archiveIcon;
	
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
		setFont(getFont().deriveFont(20f));
		setFont(getFont().deriveFont(Font.PLAIN));
		
		icon = new ELSLabel();
		text = new ELSLabel();
		arrow = new ELSLabel();
		
		this.setLayout(null);
		icon.setBounds(18, 18, 20, 20);
		icon.setVerticalAlignment(JLabel.CENTER);
		text.setBounds(42, 18, 80, 20);
		text.setFont(getFont());
		text.setVerticalAlignment(JLabel.CENTER);
		text.setHorizontalAlignment(JLabel.LEFT);
		text.setForeground(Color.white);
		
		arrow.setBounds(142, 18, 20, 20);
		arrow.setVerticalAlignment(JLabel.CENTER);
		arrow.setIcon(Images.RIGHT_IMAGEICON);
		
		this.add(arrow);
		this.add(icon);
		this.add(text);
	}
	
	public void setBtnText(String text){
		this.text.setText(text);
	}
	
	public void setIcon() {
		normalIcon = Images.getImageIcon(this.getName());
		archiveIcon = Images.getActiveIcon(this.getName());
		icon.setIcon(normalIcon);
	}
	
	
	public void setArchive(boolean isArchive){
		this.isArchive = isArchive;
		if(isArchive){
			setBackground(archiveColor);
			text.setForeground(archiveFont);
			icon.setIcon(archiveIcon);
			arrow.setIcon(Images.RIGHT_ACTIVE_IMAGEICON);
		}else{
			setBackground(backColor);
			text.setForeground(Color.white);
			icon.setIcon(normalIcon);
			arrow.setIcon(Images.RIGHT_IMAGEICON);
		}
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		setIcon();
	}
}
