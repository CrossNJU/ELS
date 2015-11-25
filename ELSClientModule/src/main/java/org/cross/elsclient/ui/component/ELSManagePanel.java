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
	protected ELSButton btn1;
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
		btn1 = new ELSButton();
		btn2 = new ELSButton();
		
		
		searchPanel.setSize(getWidth(),48);
//		searchPanel.setLayout(null);
		searchPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		
		
		modeBox.setPreferredSize(new Dimension(187, searchPanel.getHeight()));
		modeBox.setMaximumSize(new Dimension(187, searchPanel.getHeight()));
		modeBox.setMinimumSize(new Dimension(187,searchPanel.getHeight()));
		
		searchTextField.setPreferredSize(new Dimension(300, searchPanel.getHeight()));
//		searchTextField.setMaximumSize(new Dimension(50, searchPanel.getHeight()));
		searchTextField.setMinimumSize(new Dimension(200,searchPanel.getHeight()));
		
		btn1.setPreferredSize(new Dimension(150, searchPanel.getHeight()));
		btn1.setMaximumSize(new Dimension(250, searchPanel.getHeight()));
		btn1.setMinimumSize(new Dimension(150, searchPanel.getHeight()));
		
		btn2.setPreferredSize(new Dimension(150, searchPanel.getHeight()));
		btn2.setMaximumSize(new Dimension(250, searchPanel.getHeight()));
		btn2.setMinimumSize(new Dimension(150, searchPanel.getHeight()));
		
		searchPanel.add(modeBox);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchTextField);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(btn1);
//		searchPanel.add(Box.createHorizontalStrut(10));
		
		setSearchPanel();
		
		contentPanel.setSize(UIConstant.CONTENTPANEL_WIDTH, 800);
		contentPanel.setLayout(null);
		contentPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+searchPanel.getHeight());
		setContentPanel();
		
		add(searchPanel);
		add(contentPanel);
		
	}
	
	public void setSearchPanel(){
		
	}
	
	public void setContentPanel(){
		
	}
	
}
