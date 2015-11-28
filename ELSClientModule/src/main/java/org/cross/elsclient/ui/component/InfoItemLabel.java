package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.ui.util.InfoFormatUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.InfoType;

public class InfoItemLabel extends ELSLabel{
	public ELSLabel nameLabel;
	public ELSTextField inputLabel;
	public ELSComboBox comboBox;
	public boolean isLegal;
	public int type;
	public InfoType infoType;
	public ELSDatePicker datePicker;
	
	public InfoItemLabel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setMaximumSize(new Dimension(UIConstant.CONTAINER_WIDTH, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		this.setMinimumSize(new Dimension(UIConstant.CONTAINER_WIDTH, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		this.isLegal = true;
	}
	
	public void initNormal(String name, String content){
		type = 1;
		nameLabel = new ELSLabel(name);
		ELSLabel contentLabel = new ELSLabel(content);
		
		nameLabel.setPreferredSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		contentLabel.setPreferredSize(new Dimension(200, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		contentLabel.setMaximumSize(new Dimension(200, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		contentLabel.setVerticalAlignment(JLabel.CENTER);
		contentLabel.setHorizontalAlignment(JLabel.LEFT);
		contentLabel.setFont(getFont().deriveFont(20f));

		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(10));
		this.add(contentLabel);
	}
	
	public void initEditable(String name, String defaultValue,
			boolean isEditable){
		type = 2;
		
		nameLabel = new ELSLabel(name);
		inputLabel = new ELSTextField(defaultValue);
		inputLabel.setEditable(isEditable);

		nameLabel.setPreferredSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		inputLabel.setPreferredSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setMaximumSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(20f));
		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(10));
		this.add(inputLabel);
	}
	
	public void initEditable(String name, String defaultValue,
			boolean isEditable, InfoType type){
		this.type = 3;
		infoType = type;
		
		nameLabel = new ELSLabel(name);
		inputLabel = new ELSTextField(defaultValue);
		ELSLabel iconLabel = new ELSLabel();
		ELSLabel textLabel = new ELSLabel();
		inputLabel.setEditable(isEditable);
		inputLabel.setFocusable(isEditable);

		nameLabel.setPreferredSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		inputLabel.setPreferredSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setMaximumSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(20f));
		inputLabel.addFocusListener(new TextFormatListener(inputLabel, iconLabel, textLabel, type));
		
		iconLabel.setMaximumSize(new Dimension(UIConstant.MANAGETABLE_ITEM_HEIGHT, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		iconLabel.setMinimumSize(new Dimension(UIConstant.MANAGETABLE_ITEM_HEIGHT, UIConstant.MANAGETABLE_ITEM_HEIGHT));

		// textLabel.setMaximumSize(new Dimension(itemHeight*6, itemHeight));
		textLabel.setMinimumSize(new Dimension(getHeight() * 3, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		textLabel.setHorizontalAlignment(JLabel.LEFT);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setFont(getFont().deriveFont(15f));
		textLabel.setForeground(Color.red);

		isLegal = checkFormat(textLabel.getText(), type);
		
		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(10));
		this.add(inputLabel);
		this.add(iconLabel);
		this.add(textLabel);
	}
	
	public void initBox(String name, String[] items, boolean isEditable){
		type = 4;
		
		nameLabel = new ELSLabel(name);
		comboBox = new ELSComboBox();
		comboBox.setEnabled(isEditable);

		nameLabel.setPreferredSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		comboBox.setModel(new DefaultComboBoxModel<>(items));
		comboBox.setPreferredSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		comboBox.setMaximumSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		comboBox.setFont(getFont().deriveFont(20f));

		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(10));
		this.add(comboBox);
	}
	
	public void initDatePicker(String name, boolean isEditable){
		type = 5;
		
		nameLabel = new ELSLabel(name);
		datePicker = new ELSDatePicker();
		datePicker.setEnabled(isEditable);

		nameLabel.setPreferredSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setMaximumSize(new Dimension(100, UIConstant.MANAGETABLE_ITEM_HEIGHT));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		datePicker.setPreferredSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		datePicker.setMaximumSize(new Dimension(150, UIConstant.MANAGETABLE_ITEM_HEIGHT - 15));
		datePicker.setFont(getFont().deriveFont(20f));

		this.add(Box.createHorizontalStrut(30));
		this.add(nameLabel);
		this.add(Box.createHorizontalStrut(10));
		this.add(datePicker);
	}
	
	@Override
	public String toString() {
		switch (type) {
		case 2:
		case 3:
			return inputLabel.getText();
		case 4:
			return (String)comboBox.getSelectedItem();
		case 5:
			return datePicker.getDate();
		default:
			break;
		}
		return null;
	}
	
	class TextFormatListener implements FocusListener {
		ELSTextField inputLabel;
		ELSLabel iconLabel;
		ELSLabel textLabel;
		InfoType type;

		public TextFormatListener(ELSTextField inputLabel, ELSLabel iconLabel,
				ELSLabel textLabel, InfoType type) {
			super();
			this.inputLabel = inputLabel;
			this.iconLabel = iconLabel;
			this.textLabel = textLabel;
			this.type = type;
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String src = inputLabel.getText();
			String result = InfoFormatUtil.CheckFormat(src, type);
			if (result == null) {
				iconLabel.setText("Y");
				textLabel.setText("");
				isLegal = true;
			} else {
				iconLabel.setText("N");
				textLabel.setText(result);
				isLegal = false;
			}
		}

	}
	
	public boolean checkFormat(String src, InfoType type){
		if(InfoFormatUtil.CheckFormat(src, type)==null){
			return true;
		}else{
			return false;
		}
	}

}
