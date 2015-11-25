package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class ELSManagePanel extends ELSPanel {
	protected JPanel contentPanel;
	protected ELSBox searchPanel;
	protected ELSComboBox modeBox;
	protected ELSButton searchBtn;
	protected ELSButton btn2;
	protected ELSTextField searchTextField;

//	public ELSManagePanel() {
//		init();
//	}
	
	public void init() {
		setLayout(null);
		setSize(UIConstant.CONTENTPANEL_WIDTH,UIConstant.CONTENTPANEL_HEIGHT);
		
		contentPanel = new JPanel();
		searchPanel = new ELSBox(BoxLayout.X_AXIS);
		modeBox = new ELSComboBox();
		searchTextField = new ELSTextField();
		searchBtn = new ELSButton();
		btn2 = new ELSButton();
		
		
		searchPanel.setSize(getWidth(),48);
//		searchPanel.setLayout(null);
		searchPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		
		
		modeBox.setPreferredSize(new Dimension(187, UIConstant.SEARCHPANEL_HEIGHT));
		modeBox.setMaximumSize(new Dimension(187, UIConstant.SEARCHPANEL_HEIGHT));
		modeBox.setMinimumSize(new Dimension(187,UIConstant.SEARCHPANEL_HEIGHT));
		
		searchTextField.setPreferredSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
//		searchTextField.setMaximumSize(new Dimension(50, searchPanel.getHeight()));
		searchTextField.setMinimumSize(new Dimension(200,UIConstant.SEARCHPANEL_HEIGHT));
		
		searchBtn.setPreferredSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.setMinimumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		

		
		searchPanel.add(modeBox);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchTextField);
		searchPanel.add(Box.createGlue());
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);
//		searchPanel.add(Box.createHorizontalStrut(10));
		
		setSearchPanel();
		
		contentPanel.setSize(UIConstant.CONTENTPANEL_WIDTH, 800);
		contentPanel.setLayout(null);
		contentPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		setContentPanel();
		
		add(searchPanel);
		add(contentPanel);
		
	}
	
	/**
	 * 对搜索栏进行设置
	 * @para 
	 * @return void
	 */
	public void setSearchPanel(){
		
	}
	
	/**
	 * 对内容栏进行设置
	 * @para 
	 * @return void
	 */
	public void setContentPanel(){
		
	}
	
}
