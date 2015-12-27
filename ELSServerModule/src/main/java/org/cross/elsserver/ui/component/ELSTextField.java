package org.cross.elsserver.ui.component;

import java.awt.Font;

import javax.swing.JTextField;

import org.cross.elsserver.ui.util.UIConstant;


public class ELSTextField extends JTextField{
	public ELSTextField() {
		super();
		init();
	}
	
	public ELSTextField(String defaultValue){
		super(defaultValue);
		init();
	}
	
	public void init(){
		setFont(new Font("YouYuan", Font.TRUETYPE_FONT, 20));
		setForeground(UIConstant.MAINCOLOR);
	}
}